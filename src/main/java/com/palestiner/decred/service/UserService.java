package com.palestiner.decred.service;

import com.palestiner.decred.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> findAllUsers();

    void removeAllUsers();

    void removeUser(User user);

    User updateUser(User user);

    User getUserByName(String name);

}
