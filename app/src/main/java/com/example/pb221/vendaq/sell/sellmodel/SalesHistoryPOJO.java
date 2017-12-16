package com.example.pb221.vendaq.sell.sellmodel;

/**
 * Created by pb221 on 04-11-2017.
 */

public class SalesHistoryPOJO {
    private String date;
    private String reciept;

    public SalesHistoryPOJO(String date, String reciept, String sold_by, String customer, String note, String saleotal, String status) {
        this.date = date;
        this.reciept = reciept;
        this.sold_by = sold_by;
        this.customer = customer;
        this.note = note;
        this.saleotal = saleotal;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReciept() {
        return reciept;
    }

    public void setReciept(String reciept) {
        this.reciept = reciept;
    }

    public String getSold_by() {
        return sold_by;
    }

    public void setSold_by(String sold_by) {
        this.sold_by = sold_by;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSaleotal() {
        return saleotal;
    }

    public void setSaleotal(String saleotal) {
        this.saleotal = saleotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String sold_by;
    private String customer;
    private String note;
    private String saleotal;
    private String status;
}
