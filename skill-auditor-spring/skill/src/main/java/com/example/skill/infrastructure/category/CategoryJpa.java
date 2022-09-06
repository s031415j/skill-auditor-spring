package com.example.skill.infrastructure.category;


import com.example.skill.application.category.interfaces.INFCategoryJpa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "category")
@Table(name = "category")
@Setter
@Getter
@ToString
@AllArgsConstructor
public class CategoryJpa implements INFCategoryJpa {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    protected CategoryJpa(){
    }

    public static CategoryJpa categoryOf(String id, String name){
        return new CategoryJpa(id, name);
    }
}
