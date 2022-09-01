package com.example.skillsauditor.user.application.staff;

import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StaffQueryHandler implements INFStaffQueryHandler {

    private INFStaffRepository staffRepository;

    public Iterable<StaffJpa> findAllStaff() {
        return staffRepository.findAllStaff();
    }

    public Optional<StaffDTO> findStaffById(UUID staff_id) {
        Optional<StaffJpa> result = staffRepository.findStaffById(staff_id);
        if (result.isPresent()) {
            return convertStaffDetailsToDTO(result.get());
        }
        return Optional.empty();
    }

    public Optional<StaffDTO> convertStaffDetailsToDTO(INFStaffJpa staff) {
        StaffDTO staffDTO = new StaffDTO(staff.getId(),
                staff.getFullNameFirstname(), staff.getFullNameSurname(),
                staff.getLoginDetailsUsername(), staff.getLoginDetailsPassword(),
                staff.getJobRole(), staff.getManager(), staff.getAddressHouseNameNumber(), staff.getAddressStreet(),
                staff.getAddressTown(), staff.getAddressPostcode());
        return Optional.of(staffDTO);
    }
}
