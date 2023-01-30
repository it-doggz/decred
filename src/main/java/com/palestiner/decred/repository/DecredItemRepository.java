package com.palestiner.decred.repository;

import com.palestiner.decred.model.DecredItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DecredItemRepository extends JpaRepository<DecredItem, Integer> {

}
