package com.example.skillsauditor.user.ui.identity.interfaces;

public interface INFIdentityService {

    boolean isSpecifiedUser(String token, String user_id);
    boolean isAdmin(String token);


}
