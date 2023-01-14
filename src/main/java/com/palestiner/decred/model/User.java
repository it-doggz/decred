package com.palestiner.decred.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Objects;

/*** USER FOR CURRENT QUESTIONS FORM (EXAMPLE: HUSBAND, WIFE, SON)
 *
 */
@Entity
@Table(name = "user")
@DynamicUpdate
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Integer userId = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "user_id", nullable = false)
    private List<DecredItem> decredItems;

    @Column(name = "user_name")
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<DecredItem> getDecredItems() {
        return decredItems;
    }

    public void setDecredItems(List<DecredItem> decredItems) {
        this.decredItems = decredItems;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(decredItems, user.decredItems) && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, decredItems, userName);
    }
}