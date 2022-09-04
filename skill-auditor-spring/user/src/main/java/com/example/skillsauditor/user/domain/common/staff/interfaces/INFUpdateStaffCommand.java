package com.example.skillsauditor.user.domain.common.staff.interfaces;

import com.example.skillsauditor.user.domain.common.staff.Address;
import com.example.skillsauditor.user.domain.common.staff.FullName;
import com.example.skillsauditor.user.domain.common.staff.LoginDetails;

public interface INFUpdateStaffCommand {

    String getToken();
    String getUsername();

    String getStaffId();
    FullName getFullName();
    LoginDetails getLoginDetails();
    String getJobRole();
    Address getAddress();

}
