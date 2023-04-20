package com.itdoggz.decred.jpa.repository;

import com.itdoggz.decred.jpa.model.DecredItem;
import com.itdoggz.decred.jpa.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecredItemRepository extends JpaRepository<DecredItem, Integer> {

    List<DecredItem> findByOperationType(OperationType operationType);

}
