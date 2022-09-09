package com.example.skillsauditor.user.infrastructure.manager;

import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.infrastructure.manager.interfaces.CrudManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ManagerRepository implements INFManagerRepository {

    private CrudManagerRepository repository;

    @Override
    public Iterable<ManagerJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ManagerJpa> findById(String managerId) {
        return repository.findById(managerId);
    }

    @Override
    public void save(ManagerJpa managerJpa) {
        repository.save(managerJpa);
    }
}
