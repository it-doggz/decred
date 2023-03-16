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
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PaymentCategoryEntityRepositoryTest {

    private final String PAYMENT_CATEGORY_NAME = "products";

    @Autowired
    private PaymentCategoryRepository paymentCategoryRepository;

    @Test
    @Sql("classpath:init.sql")
    public void findByNameIsNotEmptyTest() {
        Optional<PaymentCategory> paymentCategoryOptional = paymentCategoryRepository.findByName(PAYMENT_CATEGORY_NAME);
        assertFalse(paymentCategoryOptional.isEmpty());
        paymentCategoryOptional.ifPresent(paymentCategory -> assertThat(paymentCategory.getName()).isEqualTo(PAYMENT_CATEGORY_NAME));
    }

    @Test
    public void findByNameIsEmptyTest() {
        Optional<PaymentCategory> paymentCategory = paymentCategoryRepository.findByName(PAYMENT_CATEGORY_NAME);
        assertThat(paymentCategory).isEmpty();
    }
}
