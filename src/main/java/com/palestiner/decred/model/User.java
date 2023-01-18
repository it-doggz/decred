package com.palestiner.decred.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.*;

/*** USER FOR CURRENT QUESTIONS FORM (EXAMPLE: HUSBAND, WIFE, SON)
 *
 */
@Entity
@Table(name = "decred_user")
@DynamicUpdate
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Integer userId = null;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DecredItem> decredItems = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PaymentCategory> paymentCategories = new HashSet<>();

    public User() {
    }

    public User(String userName, List<DecredItem> decredItems) {
        this.userName = userName;
        this.decredItems = decredItems;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<DecredItem> getDecredItems() {
        return decredItems;
    }

    public void setDecredItems(List<DecredItem> decredItems) {
        this.decredItems = decredItems;
    }

    public Set<PaymentCategory> getPaymentCategories() {
        return paymentCategories;
    }

    public void setPaymentCategories(Set<PaymentCategory> paymentCategories) {
        this.paymentCategories = paymentCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!Objects.equals(userId, user.userId)) return false;
        if (!Objects.equals(userName, user.userName)) return false;
        return Objects.equals(decredItems, user.decredItems);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId) + Objects.hashCode(userName) + Objects.hashCode(paymentCategories);
    }
}