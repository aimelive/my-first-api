package com.aimelive.api.myfirstapi.user;

import com.aimelive.api.myfirstapi.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

//    @Query("SELECT u FROM User u WHERE u.email =?1 ")
    Optional<User> findUserByEmail(String email);
}
