package com.example.skillsauditor.user.infrastructure.manager.interfaces;

import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudManagerRepository extends CrudRepository<ManagerJpa, String> {

}
