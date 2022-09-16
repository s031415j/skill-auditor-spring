package com.example.skill.application.category.eventListener;

import com.example.skill.application.category.events.CreateCategoryEvent;
import com.example.skill.application.category.interfaces.INFCategoryRepository;
import com.example.skill.application.category.interfaces.convertors.INFCategoryToCategoryJpaConvertor;
import com.example.skill.domain.common.Identity;
import com.example.skill.domain.skill.Category;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RabbitListener(queues = "createCategoryQueue")
public class CreateCategoryListener {

    private INFCategoryRepository repository;
    private INFCategoryToCategoryJpaConvertor categoryToCategoryJpaConvertor;
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private ObjectMapper mapper;

    @RabbitHandler
    public void createCategoryListener(String message){
//        try {
//            CreateCategoryEvent createCategoryEvent = mapper.readValue(event, CreateCategoryEvent.class);
//
//            Optional<CategoryJpa> categoryJpa = repository.findByName(createCategoryEvent.getName());
//
//            if (categoryJpa.isEmpty()) {
//                createNewCategory(createCategoryEvent);
//            } else {
//                LOG.info("Category already exists");
//            }
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void createNewCategory(CreateCategoryEvent event) {

        Identity identity = new Identity(event.getId());
        Category category = Category.categoryOf(identity, event.getName());
        repository.save(categoryToCategoryJpaConvertor.convert(category));
        LOG.info("New category created");
    }
}
