package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u Where u.username = :username")
    User getUserByUsername(@Param("username") String username);
}
