package com.palestiner.decred.service;
import com.palestiner.decred.model.PaymentCategory;
import java.util.List;
import java.util.Optional;

public interface PaymentCategoryService {

    PaymentCategory addNew(PaymentCategory paymentCategory);

    List<PaymentCategory> getAll();

    void removeAll();

    void removePaymentCategory(PaymentCategory paymentCategory);

    void removePaymentCategory(Long paymentCategoryId);

    PaymentCategory update(PaymentCategory paymentCategory);

    Optional<PaymentCategory> getPaymentCategory(String paymentCategoryName);

    Optional<PaymentCategory> getPaymentCategory(Long paymentCategoryId);

}
