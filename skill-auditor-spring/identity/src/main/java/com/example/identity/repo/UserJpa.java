package com.example.identity.repo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
public class UserJpa {

    @Id
    @Column(name="id")
    private String userUUID;

    @NotNull
    @Column(name = "username")
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="job_role_id")
    private JobRoleJpa jobRole;

    public String toString(){
        return String.format("%s, %s, %s, %s %s" , userUUID, userName, password, jobRole);
    }
}
