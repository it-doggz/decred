package com.palestiner.decred.jpa;

import com.palestiner.decred.model.PaymentCategory;
import com.palestiner.decred.model.User;
import com.palestiner.decred.repository.PaymentCategoryRepository;
import com.palestiner.decred.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PaymentCategoryEntityRepositoryTest {

    private final String PAYMENT_CATEGORY_NAME = "TESTNAME";

    @Autowired
    private PaymentCategoryRepository paymentCategoryRepository;

    @Test
    public void findByNameIsEmptyTest() {
        Optional<PaymentCategory> paymentCategory = paymentCategoryRepository.findByName(PAYMENT_CATEGORY_NAME);
        assertThat(paymentCategory).isEmpty();
    }

}
