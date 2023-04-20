package com.itdoggz.decred.jpa.repository;

import com.itdoggz.decred.jpa.model.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, Long> {

    Optional<PaymentCategory> findByName(String name);

}
