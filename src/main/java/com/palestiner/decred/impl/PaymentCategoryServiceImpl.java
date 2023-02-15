package com.palestiner.decred.impl;

import com.palestiner.decred.model.PaymentCategory;
import com.palestiner.decred.repository.PaymentCategoryRepository;
import com.palestiner.decred.service.PaymentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentCategoryServiceImpl implements PaymentCategoryService {

    @Autowired
    PaymentCategoryRepository paymentCategoryRepository;

    @Override
    public PaymentCategory addNew(PaymentCategory paymentCategory) {
        return paymentCategoryRepository.saveAndFlush(paymentCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentCategory> getAll() {
        return paymentCategoryRepository.findAll();
    }

    @Override
    public void removeAll() {
        paymentCategoryRepository.deleteAll();
    }

    @Override
    public void removePaymentCategory(PaymentCategory paymentCategory) {
        paymentCategoryRepository.delete(paymentCategory);
    }

    @Override
    public void removePaymentCategory(Long paymentCategoryId) {
        paymentCategoryRepository.deleteById(paymentCategoryId);
    }

    @Override
    public PaymentCategory update(PaymentCategory paymentCategory) {
        return paymentCategoryRepository.saveAndFlush(paymentCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentCategory> getPaymentCategory(String paymentCategoryName) {

        return paymentCategoryRepository.findByName(paymentCategoryName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentCategory> getPaymentCategory(Long paymentCategoryId) {

        return paymentCategoryRepository.findById(paymentCategoryId);
    }
}
