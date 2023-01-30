package com.palestiner.decred.repository;

import com.palestiner.decred.model.PaymentCategory;
import com.palestiner.decred.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, Long> {

    @Query(nativeQuery = true, value = "select name from payment_category pc where pc.name = :name")
    Optional<PaymentCategory> findByName(@Param("name") String name);
}
