package com.palestiner.decred.repository;

import com.palestiner.decred.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "select user_name from decred_user u where u.user_name = :name")
    Optional<User> findByName(@Param("name") String name);

}