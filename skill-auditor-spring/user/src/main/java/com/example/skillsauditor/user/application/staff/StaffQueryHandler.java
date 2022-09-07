package com.example.skillsauditor.user.application.staff;

import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.domain.common.staff.convertors.StaffJpaToStaffConvertor;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StaffQueryHandler implements INFStaffQueryHandler {

    private INFStaffRepository repository;

    @Override
    public List<StaffDTO> findAllStaffWithExpiredSkills() {
        Iterable<StaffJpa> result = repository.findAllStaffWithExpiredSkills();

        if(result == null){
            return new ArrayList<>();
        }
        else{
            return StaffJpaToStaffConvertor.convertStaffJpaListToStaffListDTO(result);
        }
    }
}
