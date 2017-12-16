package com.example.pb221.vendaq.product.productmodel;

import java.util.List;

/**
 * Created by Manifest on 12/9/2017.
 */

public class ProductPOJONew {

    String Pid;
    List<OutletsPOJONew> outletsItems;
    List<TaxPOJONew> taxItems;
    List<VarientsPOJONew> varientsItems;
    String Name;
    String brandid;
    String brand;
    String handle;
    String description;
    String tags;
    String Standard;
    String isSellable;
    String SKU;
    String supplierCode;
    String supplier;
    String Supplyprice;
    String userid;

    public String getIsSellable() {
        return isSellable;
    }

    public void setIsSellable(String isSellable) {
        this.isSellable = isSellable;
    }

    public String getIsInventory() {
        return IsInventory;
    }

    public void setIsInventory(String isInventory) {
        IsInventory = isInventory;
    }

    String IsInventory;
    String Markup;
    String Count;
    String CreatedDate;

    public String getMarkup() {
        return Markup;
    }

    public void setMarkup(String markup) {
        Markup = markup;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }


    public List<OutletsPOJONew> getOutletsItems() {
        return outletsItems;
    }

    public void setOutletsItems(List<OutletsPOJONew> outletsItems) {
        this.outletsItems = outletsItems;
    }

    public List<TaxPOJONew> getTaxItems() {
        return taxItems;
    }

    public void setTaxItems(List<TaxPOJONew> taxItems) {
        this.taxItems = taxItems;
    }

    public List<VarientsPOJONew> getVarientsItems() {
        return varientsItems;
    }

    public void setVarientsItems(List<VarientsPOJONew> varientsItems) {
        this.varientsItems = varientsItems;
    }


    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String standard) {
        Standard = standard;
    }


    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplyprice() {
        return Supplyprice;
    }

    public void setSupplyprice(String supplyprice) {
        Supplyprice = supplyprice;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }





}
