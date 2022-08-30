package com.example.identity.repo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "app_user")
@Table(name = "app_user")
@Getter
@Setter
public class AppUserJpa {

    @Id
    @Column(name="id")
    private String userUUID;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "username")
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="job_role_id")
    private JobRoleJpa jobRole;

    public String toString(){
        return String.format("%s, %s, %s, %s %s" , userUUID, userName, password, jobRole);
    }

}
