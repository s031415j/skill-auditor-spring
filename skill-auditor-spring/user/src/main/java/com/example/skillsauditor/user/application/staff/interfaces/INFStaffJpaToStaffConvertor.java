package com.example.skillsauditor.user.application.staff.interfaces;

import com.example.skillsauditor.user.domain.common.staff.Staff;
import com.example.skillsauditor.user.domain.common.staff.interfaces.INFStaffJpa;

public interface INFStaffJpaToStaffConvertor {

    Staff convert(INFStaffJpa staffJpa);

}
