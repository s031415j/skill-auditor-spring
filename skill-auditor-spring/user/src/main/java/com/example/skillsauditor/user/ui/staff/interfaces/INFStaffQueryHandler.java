package com.example.skillsauditor.user.ui.staff.interfaces;

import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import java.util.List;

public interface INFStaffQueryHandler {
    List<StaffDTO> findAllStaffWithExpiredSkills();
}
