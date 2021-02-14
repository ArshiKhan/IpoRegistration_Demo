package com.example.demo.dto;

import java.math.BigInteger;

/**
 * Created By : arshia on 05/02/21
 **/
public class UserIPORegistrationDto {

    private String contactNumber;
    private String ipoName;
    private BigInteger cutOffPrice;
    private BigInteger lotsApplied;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getIpoName() {
        return ipoName;
    }

    public void setIpoName(String ipoName) {
        this.ipoName = ipoName;
    }

    public BigInteger getCutOffPrice() {
        return cutOffPrice;
    }

    public void setCutOffPrice(BigInteger cutOffPrice) {
        this.cutOffPrice = cutOffPrice;
    }

    public BigInteger getLotsApplied() {
        return lotsApplied;
    }

    public void setLotsApplied(BigInteger lotsApplied) {
        this.lotsApplied = lotsApplied;
    }
}
