package com.example.skillsauditor.user.infrastructure.staff;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="staff_skills")
@Table(name="staff_skills")
@Setter
@Getter
@ToString
public class StaffSkillJpaValueObject {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "skills_sequence",
            sequenceName = "skills_sequence_id",
            allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="skills_sequence")
    private long id;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "skill_id")
    private String skillId;

    @Column(name = "strength_of_skill")
    private String strengthOfSkill;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;


    public StaffSkillJpaValueObject(){

    }

    public StaffSkillJpaValueObject(long id, String staff_id, String skill_id, String strength_of_skill, LocalDate expiry_date) {
        this.id = id;
        this.staffId = staff_id;
        this.skillId = skill_id;
        this.strengthOfSkill = strength_of_skill;
        this.expiryDate = expiry_date;
    }

    public static StaffSkillJpaValueObject staffSkillJpaOf(Long id, String staffId, String skillId, String strengthOfSkill, LocalDate expiryDate) {
        return new StaffSkillJpaValueObject(id, staffId, skillId, strengthOfSkill, expiryDate);
    }
}
