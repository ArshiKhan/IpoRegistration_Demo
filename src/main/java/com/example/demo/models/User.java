package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By : arshia on 03/02/21
 **/
@Entity
@Table(name = "USER_MASTER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private BigInteger id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(name = "IS_DELETE")
    private boolean isDeleted;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdTime;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE")
    private Date updatedTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserIPORegistrationDetails> userIPORegistrationDetails = new HashSet<>();

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Set<UserIPORegistrationDetails> getUserIPORegistrationDetails() {
        return userIPORegistrationDetails;
    }

    public void setUserIPORegistrationDetails(Set<UserIPORegistrationDetails> userIPORegistrationDetails) {
        this.userIPORegistrationDetails = userIPORegistrationDetails;
    }
}
