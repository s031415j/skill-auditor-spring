package com.example.identity.repo;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INFUserRepository extends CrudRepository<UserJpa, Long> {

    @Query("FROM app_user u WHERE u.userName=:username AND u.password=:password")
    Optional<UserJpa> findUserByUsernameAndPassword(String username, String password);

    @Query("FROM app_user u WHERE u.userName=:username")
    Optional<UserJpa> findUserByUserName(String username);
}
