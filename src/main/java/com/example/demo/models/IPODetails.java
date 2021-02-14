package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By : arshia on 05/02/21
 **/
@Entity
@Table(name = "IPO_DETAILS")
public class IPODetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private BigInteger id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOWER_BAND_PRICE")
    private BigInteger lowerBandPrice;

    @Column(name = "UPPER_BAND_PRICE")
    private BigInteger upperBandPrice;

    @Column(name = "EXPIRY_DATE")
    private Date expiry;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdTime;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE")
    private Date updatedTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPODetails", fetch = FetchType.LAZY)
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

    public BigInteger getLowerBandPrice() {
        return lowerBandPrice;
    }

    public void setLowerBandPrice(BigInteger lowerBandPrice) {
        this.lowerBandPrice = lowerBandPrice;
    }

    public BigInteger getUpperBandPrice() {
        return upperBandPrice;
    }

    public void setUpperBandPrice(BigInteger upperBandPrice) {
        this.upperBandPrice = upperBandPrice;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
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
