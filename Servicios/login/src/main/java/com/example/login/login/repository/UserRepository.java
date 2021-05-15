package com.example.login.login.repository;

import com.example.login.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public static final String FIND_USER_BY_NAME = "SELECT * FROM usertb u WHERE u.username = ?1";

    @Query(value = FIND_USER_BY_NAME, nativeQuery = true)
    Optional<User> findUserByName(String userName);

}
