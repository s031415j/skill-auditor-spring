package com.example.skillsauditor.user.domain.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserDetails {

    private String id;
    private String username;
    private String token;

    public static UserDetails userDetailsOf(String id, String username, String token){
        return new UserDetails(id, username, token);
    }
}
