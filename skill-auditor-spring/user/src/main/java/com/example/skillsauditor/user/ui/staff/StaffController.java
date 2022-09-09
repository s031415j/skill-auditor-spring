package com.example.skillsauditor.user.ui.staff;

import com.example.skillsauditor.user.application.staff.commands.EditStaffCommand;
import com.example.skillsauditor.user.application.staff.staffSkill.commands.AddStaffSkillCommand;
import com.example.skillsauditor.user.application.staff.staffSkill.commands.DeleteStaffSkillCommand;
import com.example.skillsauditor.user.application.staff.staffSkill.commands.EditStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.UserDetails;
import com.example.skillsauditor.user.ui.identity.interfaces.INFIdentityService;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffApplicationService;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/staff")
@RestController
@AllArgsConstructor
public class StaffController {

    private INFStaffApplicationService applicationService;
    private INFIdentityService identityService;

    @PutMapping("/editDetails")
    public void updateStaffDetails(@RequestBody EditStaffCommand editStaffCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(editStaffCommand.getUserId(), editStaffCommand.getToken(), editStaffCommand.getUsername());

        if(identityService.isAdmin(userDetails) || identityService.isSpecifiedUser(userDetails, editStaffCommand.getUserId())) {
            applicationService.editStaff(editStaffCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    @PostMapping("/staffSkill/add")
    public void addStaffSkill(@RequestBody AddStaffSkillCommand addStaffSkillCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(addStaffSkillCommand.getUserId(), addStaffSkillCommand.getToken(), addStaffSkillCommand.getUsername());

        if(identityService.isAdmin(userDetails) || identityService.isSpecifiedUser(userDetails, addStaffSkillCommand.getUserId())) {
            applicationService.addStaffSkill(addStaffSkillCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    @PutMapping("/staffSkill/updateSkill")
    public void updateStaffSkill(@RequestBody EditStaffSkillCommand editStaffSkillCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(editStaffSkillCommand.getUserId(), editStaffSkillCommand.getToken(), editStaffSkillCommand.getUsername());

        if(identityService.isAdmin(userDetails) || identityService.isSpecifiedUser(userDetails, editStaffSkillCommand.getUserId())) {
            applicationService.editStaffSkill(editStaffSkillCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    @DeleteMapping("/staffSkill/deleteStaffSkill")
    public void removeStaffSkill(@RequestBody DeleteStaffSkillCommand deleteStaffSkillCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(deleteStaffSkillCommand.getUserId(), deleteStaffSkillCommand.getToken(), deleteStaffSkillCommand.getUsername());

        if(identityService.isAdmin(userDetails) || identityService.isSpecifiedUser(userDetails, deleteStaffSkillCommand.getUserId())) {
            applicationService.deleteStaffSkill(deleteStaffSkillCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }
}
