package com.example.skillsauditor.user.application.staff.commands;

import com.example.skillsauditor.user.domain.common.Address;
import com.example.skillsauditor.user.domain.common.FullName;
import com.example.skillsauditor.user.domain.common.LoginDetails;
import com.example.skillsauditor.user.domain.common.interfaces.INFEditStaffCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditStaffCommand implements INFEditStaffCommand {

    private String userId;
    private String token;
    private String username;

    private String staffId;
    private FullName fullName;
    private LoginDetails loginDetails;
    private String jobRole;
    private Address address;

}
