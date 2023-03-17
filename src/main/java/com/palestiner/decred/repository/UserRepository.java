package com.palestiner.decred.repository;

import com.palestiner.decred.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "select * from decred_user u where u.user_name = :userName")
    List<User> findByName(@Param("userName") String userName);

}