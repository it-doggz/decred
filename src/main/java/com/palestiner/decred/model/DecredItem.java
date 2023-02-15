package com.palestiner.decred.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.palestiner.decred.converters.OperationTypeConverter;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id = null;

    @Column(name = "payment_val")
    private Integer paymentVal = null;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @Column(name = "operation_type")
    @Convert(converter = OperationTypeConverter.class)
    private OperationType operationType = OperationType.CREDIT;

    @Column(name = "creation_datetime")
    private LocalDateTime creationRecordDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_category_id", nullable = true)
    private PaymentCategory paymentCategory;

    public PaymentCategory getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(PaymentCategory paymentCategory) {
        this.paymentCategory = paymentCategory;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DecredItem(
            Integer paymentVal,
            User user,
            PaymentCategory paymentCategory,
            OperationType operationType,
            LocalDateTime creationRecordDateTime
    ) {
        this.paymentVal = paymentVal;
        this.user = user;
        this.paymentCategory = paymentCategory;
        this.operationType = operationType;
        this.creationRecordDateTime = creationRecordDateTime;
    }

    @Override
    public String toString() {
        return "DecredItem{" +
                "id=" + id +
                ", paymentVal=" + paymentVal +
                ", user=" + user +
                ", operationType=" + operationType +
                ", creationRecordDateTime=" + creationRecordDateTime +
                ", paymentCategory=" + paymentCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DecredItem that)) return false;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(paymentVal, that.paymentVal)) return false;
        if (!Objects.equals(user, that.user)) return false;
        if (operationType != that.operationType) return false;
        if (!Objects.equals(creationRecordDateTime, that.creationRecordDateTime))
            return false;
        return Objects.equals(paymentCategory, that.paymentCategory);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (paymentVal != null ? paymentVal.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        result = 31 * result + (creationRecordDateTime != null ? creationRecordDateTime.hashCode() : 0);
        result = 31 * result + (paymentCategory != null ? paymentCategory.hashCode() : 0);
        return result;
    }
}