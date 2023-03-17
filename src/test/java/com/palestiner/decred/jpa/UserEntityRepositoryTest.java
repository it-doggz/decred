package com.palestiner.decred.jpa;

import com.palestiner.decred.model.User;
import com.palestiner.decred.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UserEntityRepositoryTest {

    private final String USER_NAME = "Big dick";

    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql("classpath:init.sql")
    public void findByNameIsNotEmptyTest() {
        List<User> userList = userRepository.findByName(USER_NAME);
        assertThat(userList).isNotEmpty();
    }

    @Test
    public void findByNameIsEmptyTest() {
        List<User> user = userRepository.findByName(USER_NAME);
        assertThat(user).isEmpty();
    }
}
