package com.example.skill.application.category;

import com.example.skill.application.category.events.CreateCategoryEvent;
import com.example.skill.application.category.events.DeleteCategoryEvent;
import com.example.skill.application.category.events.EditCategoryEvent;
import com.example.skill.application.category.interfaces.INFCategoryRepository;
import com.example.skill.application.category.interfaces.convertors.INFCategoryToCategoryJpaConvertor;
import com.example.skill.domain.common.Identity;
import com.example.skill.domain.skill.Category;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.ui.category.INFCategoryApplicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryApplicationService implements INFCategoryApplicationService {

    private INFCategoryRepository repository;
    private INFCategoryToCategoryJpaConvertor categoryToCategoryJpaConvertor;
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private ObjectMapper mapper;

    @RabbitListener(queues = "createCategoryQueue")
    @RabbitHandler
    public void createCategoryListener(String event) {

        try {
            CreateCategoryEvent createCategoryEvent = mapper.readValue(event, CreateCategoryEvent.class);

            Optional<CategoryJpa> categoryJpa = repository.findByName(createCategoryEvent.getName());

            if (categoryJpa.isEmpty()) {
                createNewCategory(createCategoryEvent);
            } else {
                LOG.info("Category already exists");
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @RabbitListener(queues = "editCategoryQueue")
    @RabbitHandler
    public void editCategoryListener(String event) {

        try {
            EditCategoryEvent editCategoryEvent = mapper.readValue(event, EditCategoryEvent.class);

            Optional<CategoryJpa> categoryJpa = repository.findById(editCategoryEvent.getId());

            if (categoryJpa.isPresent()) {
                editCategory(editCategoryEvent);

            } else {
                LOG.info("Category does not exist");
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @RabbitListener(queues = "deleteCategoryQueue")
    @RabbitHandler
    public void deleteCategoryListener(String event) {

        try {
            DeleteCategoryEvent deleteCategoryEvent = mapper.readValue(event, DeleteCategoryEvent.class);

            Optional<CategoryJpa> categoryJpa = repository.findById(deleteCategoryEvent.getId());

            if (categoryJpa.isPresent()) {
                repository.delete(categoryJpa.get());
                LOG.info("Category was successfully deleted");
            } else {
                LOG.info("Category does not exist");
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void createNewCategory(CreateCategoryEvent event) {

        Identity identity = new Identity(event.getId());
        Category category = Category.categoryOf(identity, event.getName());
        repository.save(categoryToCategoryJpaConvertor.convert(category));
        LOG.info("New category created");
    }

    public void editCategory(EditCategoryEvent event) {

        Identity identity = new Identity(event.getId());
        Category category = Category.categoryOf(identity, event.getName());
        repository.save(categoryToCategoryJpaConvertor.convert(category));
        LOG.info("Category changes were successful");
    }
}
