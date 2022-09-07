package com.example.skillsauditor.user.infrastructure.staff;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class StaffSkillJpa {

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


    public StaffSkillJpa(){

    }

    public static StaffSkillJpa staffSkillJpaOf(long id, String staffId, String skillId, String strengthOfSkill, LocalDate expiryDate) {
        return new StaffSkillJpa(id, staffId, skillId, strengthOfSkill, expiryDate);
    }
}
