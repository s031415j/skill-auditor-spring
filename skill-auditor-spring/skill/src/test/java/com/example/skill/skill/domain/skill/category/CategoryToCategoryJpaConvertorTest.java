package com.example.skill.skill.domain.skill.category;

import com.example.skill.domain.common.Identity;
import com.example.skill.domain.common.UniqueIdFactory;
import com.example.skill.domain.skill.Category;
import com.example.skill.domain.skill.convertors.CategoryToCategoryJpaConvertor;
import com.example.skill.infrastructure.category.CategoryJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryToCategoryJpaConvertorTest {

    private CategoryToCategoryJpaConvertor convertor;
    private Category category;
    private final Identity ID = UniqueIdFactory.createId();
    private final String NAME = "NameTest";

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);

        category = new Category(ID, NAME);
        convertor = new CategoryToCategoryJpaConvertor();
    }


    @Test
    public void convert_When_Given_A_Category_Return_A_CategoryJpa_With_The_Same_Data(){

        CategoryJpa categoryJpa = convertor.convert(category);

        assertEquals(ID.id(), categoryJpa.getId());
        assertEquals(NAME, categoryJpa.getName());

    }
}
