package com.example.skillsauditor.user.domain.common.staff;

import com.example.skillsauditor.user.domain.common.ValueObject;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class FullName extends ValueObject {

    private String firstName;
    private String surname;


}
