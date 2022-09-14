package com.example.skillsauditor.user.infrastructure.manager;

import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name="team")
@Table(name="team")
@Setter
@Getter
@ToString
public class ManagerTeamJpa {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "team_sequence",
            sequenceName = "team_sequence_id",
            allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="team_sequence")
    private long id;

    @Column(name = "manager_id")
    private String manager;

    @Column(name = "fullname_first_name")
    private String fullNameFirstname;

    @Column(name="fullname_surname")
    private String fullNameSurname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private StaffJpa staff;

    public ManagerTeamJpa(){}

    public ManagerTeamJpa(long id, String manager_id, String fullname_first_name, String fullname_surname, StaffJpa staffJpa) {
        this.id = id;
        this.manager = manager_id;
        this.fullNameFirstname = fullname_first_name;
        this.fullNameSurname = fullname_surname;
        this.staff = staffJpa;

    }

}
