package com.example.skillsauditor.user.infrastructure.manager;

import com.example.skillsauditor.user.infrastructure.manager.interfaces.CrudManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManagerRepository implements INFManagerRepository {

    private CrudManagerRepository repository;


}
