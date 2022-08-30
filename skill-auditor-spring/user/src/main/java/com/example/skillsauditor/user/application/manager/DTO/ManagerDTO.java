package com.example.skillsauditor.user.application.manager.DTO;

import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.domain.common.staff.Staff;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class ManagerDTO{

    private String managerId;
    private List<Staff> team;

}
