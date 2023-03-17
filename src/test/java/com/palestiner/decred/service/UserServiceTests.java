package com.palestiner.decred.service;
import com.palestiner.decred.model.User;
import com.palestiner.decred.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTests {

    private static final int USER_ID = 1;

    private static final int EMPTY_SIZE = 0;

    private static final String USER_NAME = "Big Dick";

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void createUser() {
        user = new User(USER_ID, USER_NAME);
    }

    @DisplayName("JUnit test for getUserById method")
    @Test
    public void testGetUserById() {

        given(this.userRepository.findById(USER_ID))
                .willReturn(Optional.of(user));
        Optional<User> optionalUser = userService.getUserById(user.getUserId());
        assertFalse(optionalUser.isEmpty());
        optionalUser.ifPresent(user -> assertThat(user.getUserId()).isEqualTo(USER_ID));
    }

    @DisplayName("JUnit test for getUsersByName method")
    @Test
    public void testGetUsersByName() {
        User usr = new User(1, "Fucking whore");
        User usr1 = new User(2, "Fucking whore");

        List<User> userList = List.of(usr, usr1);
        doReturn(userList).when(userRepository).findByName("Fucking whore");
        List<User> users = userService.getUserByName("Fucking whore");

        assertThat(users).isEqualTo(userList);
    }

    @DisplayName("JUnit test for addUser method")
    @Test
    public void test_When_AddUser_Then_ReturnUserObject() {
        given(userRepository.findByName(user.getUserName()))
                .willReturn(List.of());
        assertThat(user).isNotNull();

        given(userRepository.save(user)).willReturn(user);

        User savedUser = userService.addUser(user);
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("JUnit test for findAllUsers for not empty list method")
    @Test
    public void testFindAllUsers_NotEmptyList() {

        User usr = new User(2, "Fucking whore");

        given(userRepository.findAll())
                .willReturn(List.of(user, usr));

        List<User> userList = userService.findAllUsers();
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for findAllUsers for empty list method")
    @Test
    public void testFindAllUsers_EmptyList() {

        given(userRepository.findAll())
                .willReturn(Collections.emptyList());

        List<User> userList = userService.findAllUsers();
        assertThat(userList).isEmpty();
        assertThat(EMPTY_SIZE).isEqualTo(EMPTY_SIZE);
    }

    @DisplayName("JUnit test for updateUser method")
    @Test
    public void testUpdateUser() {
        given(userRepository.save(user)).willReturn(user);

        user.setUserName("Fucking whore");

        User updatedUser = userService.updateUser(user);

        assertThat(updatedUser.getUserName()).isEqualTo("Fucking whore");
    }

    @DisplayName("JUnit test for deleteUser method")
    @Test
    public void testDeleteUser() {
        willDoNothing().given(userRepository).delete(user);

        userService.removeUser(user);

        verify(userRepository, times(1)).delete(user);
    }

    @DisplayName("JUnit test for deleteUserById method")
    @Test
    public void testDeleteUserById() {
        willDoNothing().given(userRepository).deleteById(USER_ID);

        userService.removeUser(USER_ID);

        verify(userRepository, times(1)).deleteById(USER_ID);
    }

    @DisplayName("JUnit test for deleteAllUsers method")
    @Test
    public void testDeleteAllUsers() {
        willDoNothing().given(userRepository).deleteAll();

        userService.removeAllUsers();

        verify(userRepository, times(1)).deleteAll();
    }
}
