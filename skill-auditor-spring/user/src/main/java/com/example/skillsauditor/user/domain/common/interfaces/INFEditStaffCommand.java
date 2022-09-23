package com.example.skillsauditor.user.domain.common.interfaces;

import com.example.skillsauditor.user.domain.common.Address;
import com.example.skillsauditor.user.domain.common.LoginDetails;
import com.example.skillsauditor.user.domain.common.FullName;

public interface INFEditStaffCommand {

    String getToken();
    String getUsername();

    String getStaffId();
    FullName getFullName();
    LoginDetails getLoginDetails();
    String getJobRole();
    Address getAddress();

}
