package com.example.skillsauditor.user.infrastructure.staffSkill;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudStaffSkillRepository extends CrudRepository<StaffSkillJpa, String> {
}
