package com.example.skill.application.category;

import com.example.skill.application.category.events.CreateCategoryEvent;
import com.example.skill.application.category.events.DeleteCategoryEvent;
import com.example.skill.application.category.events.EditCategoryEvent;
import com.example.skill.application.category.interfaces.INFCategoryRepository;
import com.example.skill.application.category.interfaces.convertors.INFCategoryToCategoryJpaConvertor;
import com.example.skill.domain.skill.Category;
import com.example.skill.ui.category.INFCategoryApplicationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryApplicationService implements INFCategoryApplicationService {


    private INFCategoryRepository repository;
    private INFCategoryToCategoryJpaConvertor categoryToCategoryJpaConvertor;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public void createNewCategory(CreateCategoryEvent event) {

    }

    @Override
    public void editCategory(EditCategoryEvent event) {

    }

    @Override
    public void deleteCategory(DeleteCategoryEvent event) {

    }

    public void addNewCategory(Category category){
        LOG.info("Buyer already exists");
        category = buyerJpaToBuyerConvertor.convert(buyer1.get());
    }
}
