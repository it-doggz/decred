package com.palestiner.decred.repository;

import com.palestiner.decred.model.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, Long> {

}
