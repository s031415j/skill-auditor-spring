package com.example.skillsauditor.user.infrastructure.staffSkill;

import com.example.skillsauditor.user.domain.common.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillJpa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;

@Entity(name="staff_skill")
@Table(name="staff_skill")
@ToString
@Getter
@Setter
public class StaffSkillJpa implements INFStaffSkillJpa {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "skill_id")
    private String skillId;

    @Column(name = "strength_of_skill")
    private StrengthOfSkill strengthOfSkill;

    @Column(name = "expiry_date")
    private Date expiryDate;


    public StaffSkillJpa(String id, String staffId, String skillId, StrengthOfSkill strengthOfSkill, Date expiryDate) {
        this.id = id;
        this.staffId = staffId;
        this.skillId = skillId;
        this.strengthOfSkill = strengthOfSkill;
        this.expiryDate = expiryDate;
    }

    protected StaffSkillJpa() {

    }

    public static StaffSkillJpa staffSkillOf(String id, String staffId, String skillId, StrengthOfSkill strengthOfSkill, Date expiryDate) {
        return new StaffSkillJpa(id, staffId, skillId, strengthOfSkill, expiryDate);
    }

}
