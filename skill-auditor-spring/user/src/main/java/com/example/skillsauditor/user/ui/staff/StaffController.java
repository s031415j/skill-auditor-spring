package com.example.skillsauditor.user.ui.staff;

import com.example.skillsauditor.user.application.staff.commands.EditStaffCommand;
import com.example.skillsauditor.user.application.staff.staffSkill.commands.AddStaffSkillCommand;
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

    @PostMapping("/staffSkill/add")
    public void editStaff(@RequestBody AddStaffSkillCommand addStaffSkillCommand){
        UserDetails userDetails = UserDetails.userDetailsOf(addStaffSkillCommand, editStaffCommand.getToken(), editStaffCommand.getUsername());

        if(identityService.isAdmin(userDetails) || identityService.isSpecifiedUser(userDetails, editStaffCommand.getUserId())){
            applicationService.editStaff(editStaffCommand);
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User does not have access");
        }
    }

    //remove method at the end
    @GetMapping("/findAll")
    public Iterable<?> getAllStaffDetails() {
        return queryHandler.findAllStaff();
    }

    @GetMapping("{staffId}")
    public Optional<?> getStaffById(@PathVariable(value = "staffId") UUID staffId) {
        Optional<?> result = queryHandler.findStaffById(staffId);

        if (result.isPresent()) {
            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found.");
        }
    }



//done
    @PutMapping("/editDetails")
    public void updateStaffDetails(@RequestBody EditStaffCommand editStaffCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(editStaffCommand.getUserId(), editStaffCommand.getToken(), editStaffCommand.getUsername());

        if(identityService.isAdmin(userDetails) || identityService.isSpecifiedUser(userDetails, editStaffCommand.getUserId())){
            applicationService.editStaff(editStaffCommand);
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User does not have access");
        }
    }
}
