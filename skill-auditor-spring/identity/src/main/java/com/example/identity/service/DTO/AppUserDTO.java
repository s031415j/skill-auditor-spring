package com.example.identity.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AppUserDTO {

    public final static String ID = "id";
    public final static String FIRST_NAME = "first name";
    public final static String SURNAME = "surname";
    public final static String USERNAME = "username";
    public final static String PASSWORD = "password";
    public final static String JOB_ROLE = "job role";

    private String id;
    private String firstName;
    private String surname;
    private String username;
    private String password;
    private String jobRole;

}
