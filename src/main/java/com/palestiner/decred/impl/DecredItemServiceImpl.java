package com.palestiner.decred.impl;

import com.palestiner.decred.model.DecredItem;
import com.palestiner.decred.repository.DecredItemRepository;
import com.palestiner.decred.service.DecredItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DecredItemServiceImpl implements DecredItemService {

    @Autowired
    DecredItemRepository decredItemRepository;

    @Override
    public DecredItem addItem(DecredItem decredItem) {
        return decredItemRepository.saveAndFlush(decredItem);
    }

    @Override
    public DecredItem update(DecredItem decredItem) {
        return decredItemRepository.saveAndFlush(decredItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DecredItem> getAllItems() {
        return decredItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DecredItem> getAllItems(String operationType) {

        return decredItemRepository.findAllByOperationType(operationType);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DecredItem> getItemById(Integer decredItemId) {

        return decredItemRepository.findById(decredItemId);
    }

    @Override
    public void removeAllItems() {
        decredItemRepository.deleteAll();
    }

    @Override
    public void removeItem(DecredItem decredItem) {
        decredItemRepository.delete(decredItem);
    }

    @Override
    public void removeItem(Integer decredItemId) {
        decredItemRepository.deleteById(decredItemId);
    }

}
