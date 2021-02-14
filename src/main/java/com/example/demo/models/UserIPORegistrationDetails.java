package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created By : arshia on 05/02/21
 **/
@Entity
@Table(name = "USER_IPO_REGISTRATION_DETAILS")
public class UserIPORegistrationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USER_ID")
    private BigInteger userId;

    @Column(name = "IPO_ID")
    private BigInteger ipoId;

    @Column(name = "CUT_OFF_PRICE")
    private BigInteger cutOffPrice;

    @Column(name = "LOTS")
    private BigInteger lots;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdTime;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE")
    private Date updatedTime;

    @Column(name = "IS_CANCELLED")
    private boolean isCancelled;


    @ManyToOne(targetEntity = IPODetails.class)
    @JoinColumn(
            name = "IPO_ID",
            referencedColumnName = "ID",
            insertable = false,
            updatable = false
    )
    private IPODetails iPODetails;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "USER_ID",
            referencedColumnName = "ID",
            insertable = false,
            updatable = false
    )
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getIpoId() {
        return ipoId;
    }

    public void setIpoId(BigInteger ipoId) {
        this.ipoId = ipoId;
    }

    public BigInteger getCutOffPrice() {
        return cutOffPrice;
    }

    public void setCutOffPrice(BigInteger cutOffPrice) {
        this.cutOffPrice = cutOffPrice;
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

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public BigInteger getLots() {
        return lots;
    }

    public void setLots(BigInteger lots) {
        this.lots = lots;
    }

    public IPODetails getiPODetails() {
        return iPODetails;
    }

    public void setiPODetails(IPODetails iPODetails) {
        this.iPODetails = iPODetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

