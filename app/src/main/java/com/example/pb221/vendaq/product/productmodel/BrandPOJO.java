package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 27-10-2017.
 */

public class BrandPOJO {public String getBrandName() {
    return BrandName;
}

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    private String BrandName;

    public String getBrandId() {
        return BrandId;
    }

    public void setBrandId(String brandId) {
        BrandId = brandId;
    }

    private String BrandId;
    private String BrandDescription;
    private String NumberOfProducts;


    public String getBrandDescription() {
        return BrandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        BrandDescription = brandDescription;
    }

    public String getNumberOfProducts() {
        return NumberOfProducts;
    }

    public void setNumberOfProducts(String numberOfProducts) {
        NumberOfProducts = numberOfProducts;
    }
}
