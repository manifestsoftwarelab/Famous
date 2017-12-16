package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 29-10-2017.
 */

public class SupplierPOJO {
    private String supplierName;
    private String supplierEmail;
    private String supplierId;
    private String supplierPhone;
    private String supplierAddress;

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierNumberOfProduct() {
        return supplierNumberOfProduct;
    }

    public void setSupplierNumberOfProduct(String supplierNumberOfProduct) {
        this.supplierNumberOfProduct = supplierNumberOfProduct;
    }

    private String supplierNumberOfProduct;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierDescription() {
        return supplierDescription;
    }

    public void setSupplierDescription(String supplierDescription) {
        this.supplierDescription = supplierDescription;
    }

    public String getSupplierDefaultMarkup() {
        return supplierDefaultMarkup;
    }

    public void setSupplierDefaultMarkup(String supplierDefaultMarkup) {
        this.supplierDefaultMarkup = supplierDefaultMarkup;
    }

    public String getSupplierNoOfProduct() {
        return supplierNoOfProduct;
    }

    public void setSupplierNoOfProduct(String supplierNoOfProduct) {
        this.supplierNoOfProduct = supplierNoOfProduct;
    }

    private String supplierDescription;

    public SupplierPOJO() {

    }

    public SupplierPOJO(String supplierName, String supplierDescription, String supplierDefaultMarkup, String supplierNoOfProduct) {
        this.supplierName = supplierName;
        this.supplierDescription = supplierDescription;
        this.supplierDefaultMarkup = supplierDefaultMarkup;
        this.supplierNoOfProduct = supplierNoOfProduct;
    }

    private String supplierDefaultMarkup;
    private String supplierNoOfProduct;
}
