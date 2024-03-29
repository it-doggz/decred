package com.itdoggz.decred.ui.data.entity;

import com.itdoggz.decred.ui.data.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.hilla.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "application_user")
public class User extends AbstractEntity {

    @Nonnull
    private String username;
    @Nonnull
    private String name;
    @JsonIgnore
    private String hashedPassword;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @Nonnull
    private Set<Role> roles;
    @Lob
    @Column(length = 1000000)
    private byte @Nonnull [] profilePicture;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public byte @Nonnull [] getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(byte @Nonnull [] profilePicture) {
        this.profilePicture = profilePicture;
    }

}
