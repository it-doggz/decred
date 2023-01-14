package com.palestiner.decred.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

/*** DEBET-CREDIT ITEM MODEL CLASS
 *
 */
@Entity
@Table(name = "decred_items")
@DynamicUpdate
public class DecredItem {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id = null;

    @Column(name = "payment_val")
    private Integer paymentVal = null;

    @Column(name = "user_id")
    private Integer userId = null;

    @Column(name = "payment_category_id")
    private Integer paymentCategoryId = null;

    @Column(name = "operation_type")
    private OperationType operationType = OperationType.CREDIT;

    @Column(name = "creation_datetime")
    private LocalDateTime creationRecordDateTime;

    @Enumerated(EnumType.STRING)
    public OperationType getOperationType() {
        return operationType;
    }

    @Enumerated(EnumType.STRING)
    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaymentCategoryId() {
        return paymentCategoryId;
    }

    public void setPaymentCategoryId(Integer paymentCategoryId) {
        this.paymentCategoryId = paymentCategoryId;
    }

    public Integer getPaymentVal() {
        return paymentVal;
    }

    public void setPaymentVal(Integer paymentVal) {
        this.paymentVal = paymentVal;
    }

    public LocalDateTime getCreationRecordDateTime() {
        return creationRecordDateTime;
    }

    public void setCreationRecordDateTime(LocalDateTime creationRecordDateTime) {
        this.creationRecordDateTime = creationRecordDateTime;
    }

    public DecredItem() {
    }

    public DecredItem(Integer id,
                      LocalDateTime creationRecordDateTime,
                      OperationType operationType,
                      Integer paymentVal,
                      Integer userId,
                      Integer paymentCategoryId) {
        this.id = id;
        this.creationRecordDateTime = creationRecordDateTime;
        this.operationType = operationType;
        this.paymentVal = paymentVal;
        this.userId = userId;
        this.paymentCategoryId = paymentCategoryId;
    }

    @Override
    public String toString() {
        return "DecredItem{" +
                ", id=" + id +
                ", creationRecordDateTime=" + creationRecordDateTime +
                "operationType=" + operationType +
                ", paymentVal=" + paymentVal +
                ", userId=" + userId +
                ", paymentCategoryId=" + paymentCategoryId +
                '}';
    }
}