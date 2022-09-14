package com.example.identity.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INFUserRepository extends CrudRepository<AppUserJpa, Long> {

    @Query("FROM app_user u WHERE u.username=:username AND u.password=:password")
    Optional<AppUserJpa> findUserByUsernameAndPassword(String username, String password);

    @Query("FROM app_user u WHERE u.username=:username")
    Optional<AppUserJpa> findUserByUsername(String username);
}
