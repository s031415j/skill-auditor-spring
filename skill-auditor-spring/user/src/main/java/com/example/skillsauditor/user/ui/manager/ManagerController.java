package com.example.skillsauditor.user.ui.manager;

import com.example.skillsauditor.user.application.manager.commands.category.CreateCategoryCommand;
import com.example.skillsauditor.user.application.manager.commands.category.DeleteCategoryCommand;
import com.example.skillsauditor.user.application.manager.commands.category.EditCategoryCommand;
import com.example.skillsauditor.user.application.manager.commands.skill.CreateSkillCommand;
import com.example.skillsauditor.user.application.manager.commands.skill.DeleteSkillCommand;
import com.example.skillsauditor.user.application.manager.commands.skill.EditSkillCommand;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTOList;
import com.example.skillsauditor.user.domain.common.UserDetails;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import com.example.skillsauditor.user.ui.identity.interfaces.INFIdentityService;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerApplicationService;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/manager")
@AllArgsConstructor
public class ManagerController {

    private INFManagerQueryHandler queryHandler;
    private INFManagerApplicationService applicationService;
    private INFIdentityService identityService;

    @PostMapping("/team/findTeamByManager/{manager_id}")
    public List<?> getTeam(@PathVariable(value = "manager_id") String managerId, @RequestBody UserDetails userDetails) {

        if (identityService.isAdmin(userDetails)) {
            List<?> result = queryHandler.findTeamMembersByManagerId(managerId);

            if (!result.isEmpty()) {
                return result;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager not found");
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
    }

    @PostMapping("team/bySkill/{skill_id}")
    public List<?> getTeamMembersBySkillId(@PathVariable(value = "skill_id") String skillId,
                                           @RequestBody UserDetails userDetails) {

        if (identityService.isAdmin(userDetails)) {
            List<?> result = queryHandler.findTeamMembersBySkillId(userDetails.getId(), skillId);

            if (!result.isEmpty()) {
                return result;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill not found");
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
    }

    @PostMapping("/team/expiredSkills")
    public List<?> getAllTeamMembersWithExpiredSkills(@RequestBody UserDetails userDetails) {

        if (identityService.isAdmin(userDetails)) {
            List<?> result = queryHandler.findAllWithExpiredSkills();
            if (!result.isEmpty()) {
                return result;
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No expired skills");
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
    }

    @PostMapping("/team/addToTeam/{staff_id}")
    public void updateManagerTeam(@PathVariable(value = "staff_id") String staffId,
                                  @RequestBody UserDetails userDetails) {

        if (identityService.isAdmin(userDetails)) {
            applicationService.addStaffToTeam(userDetails.getId(), staffId);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    @PostMapping("/createSkill")
    public void createSkill(@RequestBody CreateSkillCommand createSkillCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(createSkillCommand.getId(), createSkillCommand.getToken(), createSkillCommand.getUsername());

        if (identityService.isAdmin(userDetails)) {
            applicationService.createSkill(createSkillCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    @PutMapping("/editSkill")
    public void editSkill(@RequestBody EditSkillCommand editSkillCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(editSkillCommand.getId(), editSkillCommand.getToken(), editSkillCommand.getUsername());

        if (identityService.isAdmin(userDetails)) {
            applicationService.editSkill(editSkillCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    @DeleteMapping("/deleteSkill")
    public void deleteSkill(@RequestBody DeleteSkillCommand deleteSkillCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(deleteSkillCommand.getId(), deleteSkillCommand.getToken(), deleteSkillCommand.getUsername());

        if (identityService.isAdmin(userDetails)) {
            applicationService.deleteSkill(deleteSkillCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    @PostMapping("/findAllStaffSkillsByCategory/{category_id}")
    public StaffSkillDTOList getSkillsByCategoryId(@PathVariable(name = "category_id") String categoryId,
                                                   @RequestBody UserDetails userDetails) {
        if (identityService.isAdmin(userDetails)) {
            StaffSkillDTOList result = queryHandler.findSkillsByCategory(categoryId);
            if (!result.getStaffSkills().isEmpty()) {
                return result;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");

    }

    @PostMapping("/createCategory")
    public void createCategory(@RequestBody CreateCategoryCommand createSkillCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(createSkillCommand.getId(), createSkillCommand.getToken(), createSkillCommand.getUsername());

        if (identityService.isAdmin(userDetails)) {
            applicationService.createCategory(createSkillCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    // edit category
    @PutMapping("/editCategory")
    public void editCategory(@RequestBody EditCategoryCommand editCategoryCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(editCategoryCommand.getId(), editCategoryCommand.getToken(), editCategoryCommand.getUsername());

        if (identityService.isAdmin(userDetails)) {
            applicationService.editCategory(editCategoryCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }

    // delete category
    @DeleteMapping("/deleteCategory")
    public void deleteCategory(@RequestBody DeleteCategoryCommand deleteCategoryCommand) {
        UserDetails userDetails = UserDetails.userDetailsOf(deleteCategoryCommand.getId(), deleteCategoryCommand.getToken(), deleteCategoryCommand.getUsername());

        if (identityService.isAdmin(userDetails)) {
            applicationService.deleteCategory(deleteCategoryCommand);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorised user");
        }
    }
}
