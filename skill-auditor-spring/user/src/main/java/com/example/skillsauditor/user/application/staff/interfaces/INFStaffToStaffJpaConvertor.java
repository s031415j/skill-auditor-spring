package com.example.skillsauditor.user.application.staff.interfaces;

import com.example.skillsauditor.user.domain.common.Staff;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;

public interface INFStaffToStaffJpaConvertor {

    StaffJpa convert(Staff staff);
}
