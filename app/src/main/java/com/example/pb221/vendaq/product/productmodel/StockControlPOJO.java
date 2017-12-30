package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 29-10-2017.
 */

public class StockControlPOJO {

    String StockId;
    String StockName;
    String UserId;
    String StockType;
    String Date;
    String DeliveryDate;
    String Number;
    String Outlet;
    String Source ;
    String Status;
    String Items;
    String TotalCost;
    String SKU;
    String Handle;
    String SupplierCode;

    public StockControlPOJO(String stockId, String stockName, String userId, String stockType, String date, String deliveryDate, String number, String outlet, String source, String status, String items, String totalCost, String SKU, String handle, String supplierCode) {
        StockId = stockId;
        StockName = stockName;
        UserId = userId;
        StockType = stockType;
        Date = date;
        DeliveryDate = deliveryDate;
        Number = number;
        Outlet = outlet;
        Source = source;
        Status = status;
        Items = items;
        TotalCost = totalCost;
        this.SKU = SKU;
        Handle = handle;
        SupplierCode = supplierCode;
    }

    public String getStockId() {

        return StockId;
    }

    public void setStockId(String stockId) {
        StockId = stockId;
    }

    public String getStockName() {
        return StockName;
    }

    public void setStockName(String stockName) {
        StockName = stockName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getStockType() {
        return StockType;
    }

    public void setStockType(String stockType) {
        StockType = stockType;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getOutlet() {
        return Outlet;
    }

    public void setOutlet(String outlet) {
        Outlet = outlet;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getItems() {
        return Items;
    }

    public void setItems(String items) {
        Items = items;
    }

    public String getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(String totalCost) {
        TotalCost = totalCost;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getHandle() {
        return Handle;
    }

    public void setHandle(String handle) {
        Handle = handle;
    }

    public String getSupplierCode() {
        return SupplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        SupplierCode = supplierCode;
    }
}
