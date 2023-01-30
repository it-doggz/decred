package com.palestiner.decred.repository;

import com.palestiner.decred.model.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, Long> {

    @Query(nativeQuery = true, value = "select name from payment_category pc where pc.name = :paymentCategoryName")
    Optional<PaymentCategory> findByName(@Param("paymentCategoryName") String paymentCategoryName);
}
