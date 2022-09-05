package com.example.skill.domain.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class IdentifiedValueObject extends AssertionConcern {

    private long id = -1;

    protected long id(){
        return id;
    }
}
