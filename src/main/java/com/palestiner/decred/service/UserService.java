package com.palestiner.decred.service;

import com.palestiner.decred.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);

    List<User> findAllUsers();

    void removeAllUsers();

    void removeUser(User user);

    void removeUser(Integer userId);

    User updateUser(User user);

    Optional<User> getUser(String userName);

    Optional<User> getUser(Integer userId);

}
