package com.example.ImageCreationService.repositories;

import com.example.ImageCreationService.entities.NewUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<NewUser,Long> {
    @Query("SELECT users from NewUser users where users.username=?1 AND users.password=?2")
    Optional<NewUser> findMyUser(String username, String password);

    @Query("SELECT users from NewUser users where users.username=?1")
    Optional<NewUser> findByUsername(String username);
}
