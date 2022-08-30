package com.example.skillsauditor.user.infrastructure.staff;

import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class StaffRepository implements INFStaffRepository {

    private CrudStaffRepository repository;

    public Iterable<StaffJpa> findAllStaff(){
        return repository.findAll();
    }

    public Optional<StaffJpa> findStaffById(UUID id){
        return repository.findById(id.toString());
    }

    public StaffJpa save(StaffJpa staff){
        return repository.save(staff);
    }
}
