package com.example.skillsauditor.user.domain.manager;

import com.example.skillsauditor.user.application.manager.interfaces.INFManagerToManagerJpaConvertor;
import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;
import org.springframework.stereotype.Component;

@Component
public class ManagerToManagerJpaConvertor implements INFManagerToManagerJpaConvertor {

    @Override
    public ManagerJpa convert(Manager manager) {
        return ManagerJpa.managerJpaOf(manager.id().id(), manager.getFullName().getFirstName(), manager.getFullName().getSurname(), manager.getLoginDetails().getUsername(), manager.getLoginDetails().getPassword(), manager.getJobRole().getJobRole(), manager.getAddress().getHouseNameNumber(), manager.getAddress().getStreet(), manager.getAddress().getTown(), manager.getAddress().getPostcode());
    }
}
