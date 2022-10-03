package com.example.skill.application.skill.DTO;

import com.example.skill.application.category.DTO.CategoryDTO;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class SkillDTO {

    private String id;
    private String name;
    private CategoryDTO category;

    public SkillDTO() {

    }
}
