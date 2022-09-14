package com.example.skill.infrastructure.skill;

import com.example.skill.application.skill.interfaces.INFSkillJpa;
import com.example.skill.infrastructure.category.CategoryJpa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "skill")
@Table(name = "skill")
@ToString
@Getter
@Setter
@AllArgsConstructor
public class SkillJpa implements INFSkillJpa {

    @Id
    @Column
    private String id;

    @Column(name = "skill_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryJpa category;

    protected SkillJpa(){
    }

    public static SkillJpa skillOf(String id, String name, CategoryJpa category){
        return new SkillJpa(id, name, category);
    }

}
