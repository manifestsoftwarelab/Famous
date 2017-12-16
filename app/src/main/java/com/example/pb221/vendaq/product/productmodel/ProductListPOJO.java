package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 26-10-2017.
 */

public class ProductListPOJO {
    private  String productName;
    private  String createdDate;
    private  String productTags;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getProductTags() {
        return productTags;
    }

    public void setProductTags(String productTags) {
        this.productTags = productTags;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }

    public String getProductVarients() {
        return productVarients;
    }

    public void setProductVarients(String productVarients) {
        this.productVarients = productVarients;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    private  String productBrand;

    public ProductListPOJO(String productName, String createdDate, String productTags, String productBrand, String productSupplier, String productVarients, double productPrice, int productCount) {
        this.productName = productName;
        this.createdDate = createdDate;
        this.productTags = productTags;
        this.productBrand = productBrand;
        this.productSupplier = productSupplier;
        this.productVarients = productVarients;
        this.productPrice = productPrice;
        this.productCount = productCount;
    }

    private  String productSupplier;
    private  String productVarients;
    private  double productPrice;
    private  int productCount;
}
