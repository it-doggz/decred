package com.palestiner.decred.repository;

import com.palestiner.decred.model.DecredItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DecredItemRepository extends JpaRepository<DecredItem, Integer> {

    @Query(nativeQuery = true, value = "select * from decred_items di where di.operation_type = :operationType")
    List<DecredItem> findAllByOperationType(@Param("operationType") String operationType);
}
