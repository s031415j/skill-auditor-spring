package com.example.skillsauditor.user.application.staff.interfaces;

import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;

import java.util.Optional;
import java.util.UUID;

public interface INFStaffRepository {

    Iterable<StaffJpa> findAll();
    Optional<StaffJpa> findById(String id);
    StaffJpa save(StaffJpa staff);
    Iterable<StaffJpa> findAllStaffWithExpiredSkills();
}
