package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 28-10-2017.
 */

public class PriceBooksPOJO {
    public String getPriceBookId() {
        return priceBookId;
    }

    public void setPriceBookId(String priceBookId) {
        this.priceBookId = priceBookId;
    }

    public String getPriceBookName() {
        return priceBookName;
    }

    public void setPriceBookName(String priceBookName) {
        this.priceBookName = priceBookName;
    }

    public String getPriceBookCustomerGroup() {
        return priceBookCustomerGroup;
    }

    public void setPriceBookCustomerGroup(String priceBookCustomerGroup) {
        this.priceBookCustomerGroup = priceBookCustomerGroup;
    }

    public String getPriceBookOutlet() {
        return priceBookOutlet;
    }

    public void setPriceBookOutlet(String priceBookOutlet) {
        this.priceBookOutlet = priceBookOutlet;
    }

    public String getPriceBookValidFromDate() {
        return priceBookValidFromDate;
    }

    public void setPriceBookValidFromDate(String priceBookValidFromDate) {
        this.priceBookValidFromDate = priceBookValidFromDate;
    }

    public String getPriceBookValidToDate() {
        return priceBookValidToDate;
    }

    public void setPriceBookValidToDate(String priceBookValidToDate) {
        this.priceBookValidToDate = priceBookValidToDate;
    }

    public String getPriceBookCreateDate() {
        return priceBookCreateDate;
    }

    public void setPriceBookCreateDate(String priceBookCreateDate) {
        this.priceBookCreateDate = priceBookCreateDate;
    }

    private String priceBookId;
    private String priceBookName;
    private String priceBookCustomerGroup;
    private String priceBookOutlet;
    private String priceBookValidFromDate;
    private String priceBookValidToDate;
    private String priceBookCreateDate;


    public PriceBooksPOJO(String priceBookId, String priceBookName, String priceBookCustomerGroup, String priceBookOutlet, String priceBookValidFromDate, String priceBookValidToDate, String priceBookCreateDate) {
        this.priceBookId = priceBookId;
        this.priceBookName = priceBookName;
        this.priceBookCustomerGroup = priceBookCustomerGroup;
        this.priceBookOutlet = priceBookOutlet;
        this.priceBookValidFromDate = priceBookValidFromDate;
        this.priceBookValidToDate = priceBookValidToDate;
        this.priceBookCreateDate = priceBookCreateDate;
    }
}
