package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by Manifest on 12/9/2017.
 */

public class VarientsPOJONew {
    String VariantName;
    String VariantCount;
    String SupplierCode;

    public VarientsPOJONew(String variantName, String variantCount, String supplierCode, String supplierPrice, String retailPrice) {
        VariantName = variantName;
        VariantCount = variantCount;
        SupplierCode = supplierCode;
        SupplierPrice = supplierPrice;
        RetailPrice = retailPrice;
    }

    public String getVariantName() {
        return VariantName;
    }

    public void setVariantName(String variantName) {
        VariantName = variantName;
    }

    public String getVariantCount() {
        return VariantCount;
    }

    public void setVariantCount(String variantCount) {
        VariantCount = variantCount;
    }

    public String getSupplierCode() {
        return SupplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        SupplierCode = supplierCode;
    }

    public String getSupplierPrice() {
        return SupplierPrice;
    }

    public void setSupplierPrice(String supplierPrice) {
        SupplierPrice = supplierPrice;
    }

    public String getRetailPrice() {
        return RetailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        RetailPrice = retailPrice;
    }

    String SupplierPrice;
    String RetailPrice;
}
