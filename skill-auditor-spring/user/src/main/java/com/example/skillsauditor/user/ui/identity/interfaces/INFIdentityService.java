package com.example.skillsauditor.user.ui.identity.interfaces;

import com.example.skillsauditor.user.domain.common.UserDetails;

public interface INFIdentityService {

    boolean isSpecifiedUser(UserDetails token, String user_id);
    boolean isAdmin(UserDetails token);


}
