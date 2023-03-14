package com.palestiner.decred.jpa;

import com.palestiner.decred.converters.OperationTypeConverter;
import com.palestiner.decred.model.DecredItem;
import com.palestiner.decred.model.OperationType;
import com.palestiner.decred.model.User;
import com.palestiner.decred.repository.DecredItemRepository;
import com.palestiner.decred.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DecredItemEntityRepositoryTest {

    Boolean operationType = OperationType.DEBET.getValue();

    @Autowired
    private DecredItemRepository decredItemRepository;

    @Test
    public void findAllByOperationTypeIsEmptyTest() {
        List<DecredItem> decredItemList = decredItemRepository
                .findAllByOperationType(operationType);
        assertThat(decredItemList).isEmpty();
    }
}
