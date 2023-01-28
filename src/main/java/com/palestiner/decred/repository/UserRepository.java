package com.palestiner.decred.repository;

import com.palestiner.decred.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
