package com.example.demo.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created By : arshia on 06/02/21
 **/
public class IpoDetailsDto {

    private String name;
    private BigInteger lowerBandPrice;
    private BigInteger upperBandPrice;

    private Date expiryDate;

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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
