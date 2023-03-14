package com.palestiner.decred.jpa;

import com.palestiner.decred.model.User;
import com.palestiner.decred.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UserEntityRepositoryTest {

    private final String USER_NAME = "TESTNAME";

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByNameIsEmptyTest() {
        Optional<User> user = userRepository.findByName(USER_NAME);
        assertThat(user).isEmpty();
    }
}
