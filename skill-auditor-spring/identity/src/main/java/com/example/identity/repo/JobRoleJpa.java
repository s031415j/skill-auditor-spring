package com.example.identity.repo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity(name = "job_role")
@Table(name = "job_role")
@Getter
@Setter
public class JobRoleJpa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "role")
    private String role;

    public String toString(){
        return role;
    }
}
