package com.example.skill.application.skill.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SkillDTOList {

    private List<SkillDTO> skills;
    public SkillDTOList() {
        this.skills = new ArrayList<>();
    }

}
