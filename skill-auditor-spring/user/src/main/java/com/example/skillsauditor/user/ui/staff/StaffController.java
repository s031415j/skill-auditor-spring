package com.example.skillsauditor.user.ui.staff;

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
@Controller
public class StaffController {

    private INFStaffQueryHandler queryHandler;

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
}
