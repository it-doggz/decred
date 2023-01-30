package com.palestiner.decred.impl;

import com.palestiner.decred.model.User;
import com.palestiner.decred.repository.UserRepository;
import com.palestiner.decred.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void removeUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUser(String userName) {
        return userRepository.findByName(userName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }


}
