package com.palestiner.decred.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DecredItem() {
    }

    public DecredItem(Integer id,
                      Integer paymentVal,
                      User user,
                      Integer paymentCategoryId,
                      OperationType operationType,
                      LocalDateTime creationRecordDateTime) {
        this.id = id;
        this.paymentVal = paymentVal;
        this.user = user;
        this.paymentCategoryId = paymentCategoryId;
        this.operationType = operationType;
        this.creationRecordDateTime = creationRecordDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecredItem that = (DecredItem) o;
        return Objects.equals(id, that.id) && Objects.equals(paymentVal, that.paymentVal) && Objects.equals(user, that.user) && Objects.equals(paymentCategoryId, that.paymentCategoryId) && operationType == that.operationType && Objects.equals(creationRecordDateTime, that.creationRecordDateTime);
    }

    @Override
    public int hashCode() {
      return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "DecredItem{" +
                "id=" + id +
                ", paymentVal=" + paymentVal +
                ", user=" + user +
                ", paymentCategoryId=" + paymentCategoryId +
                ", operationType=" + operationType +
                ", creationRecordDateTime=" + creationRecordDateTime +
                '}';
    }
}