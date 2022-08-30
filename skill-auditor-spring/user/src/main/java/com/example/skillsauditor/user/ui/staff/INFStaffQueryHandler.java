package com.example.skillsauditor.user.ui.staff;

import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;

import java.util.Optional;
import java.util.UUID;

public interface INFStaffQueryHandler {

    //remove later
    Iterable<StaffJpa> findAllStaff();

    Optional<StaffDTO> findStaffById(UUID staffId);

}
