package com.example.skillsauditor.user.application.manager.interfaces;

import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;

import java.util.Optional;

public interface INFManagerRepository {

    Iterable<ManagerJpa> findAll();
    Optional<ManagerJpa> findById(String managerId);
    void save(ManagerJpa managerJpa);
}
