package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 29-10-2017.
 */

public class ProductTagsPOJO {
    private String tagId;
    private String tagName;

    public String getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(String numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    private String numberOfProduct;

    public ProductTagsPOJO(String tagId, String tagName, String numberOfProduct) {
        this.tagName = tagName;
        this.tagId = tagId;
        this.numberOfProduct = numberOfProduct;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
