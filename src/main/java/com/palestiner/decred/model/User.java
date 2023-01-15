package com.palestiner.decred.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<DecredItem> decredItems;

    public User() {
    }

    public User(Integer userId, String userName, Set<DecredItem> decredItems) {
        this.userId = userId;
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

    public Set<DecredItem> getDecredItems() {
        return decredItems;
    }

    public void setDecredItems(Set<DecredItem> decredItems) {
        this.decredItems = decredItems;
    }

}