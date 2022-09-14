package com.example.skillsauditor.user.infrastructure.staff.interfaces;

import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudStaffRepository extends CrudRepository<StaffJpa, String> {

    @Query(value = "SELECT * FROM staff JOIN staff_skill ON staff_skill.staff_id = staff.id WHERE staff_skill.expiry_date < CURRENT_DATE",
            nativeQuery = true)
    Iterable<StaffJpa> findAllWithExpiredSkills();

}
