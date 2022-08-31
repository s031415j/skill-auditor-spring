package com.example.skillsauditor.user.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDetails {

    private String id;
    private String username;
    private String token;

    public UserDetails(){

    }

    public static UserDetails userDetailsOf(String id, String username, String token){
        return new UserDetails(id, username, token);
    }
}
