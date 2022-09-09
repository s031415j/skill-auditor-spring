package com.example.skillsauditor.user.infrastructure.staff;

import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.infrastructure.staff.interfaces.CrudStaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class StaffRepository implements INFStaffRepository {

    private CrudStaffRepository repository;

    @Override
    public Iterable<StaffJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<StaffJpa> findById(String id) {
        return repository.findById(id);
    }

    public StaffJpa save(StaffJpa staff){
        return repository.save(staff);
    }

    @Override
    public Iterable<StaffJpa> findAllStaffWithExpiredSkills() {
        return repository.findAllWithExpiredSkills();
    }
}
