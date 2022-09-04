package com.example.skillsauditor.user.application.manager.interfaces;

import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;

public interface INFManagerJpaToManagerConvertor {
    Manager convert(ManagerJpa managerJpa);
}
