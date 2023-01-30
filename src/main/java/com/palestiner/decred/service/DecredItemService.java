package com.palestiner.decred.service;

import com.palestiner.decred.model.DecredItem;
import com.palestiner.decred.model.PaymentCategory;
import java.util.List;
import java.util.Optional;

public interface DecredItemService {

    DecredItem addItem(DecredItem decredItem);

    List<DecredItem> getAllItems();

    List<DecredItem> getAllItems(String operationType);

    void removeAllItems();

    void removeItem(DecredItem decredItem);

    void removeItem(Integer decredItemId);

    DecredItem update(DecredItem decredItem);

    Optional<DecredItem> getItemById(Integer decredItemId);

}
