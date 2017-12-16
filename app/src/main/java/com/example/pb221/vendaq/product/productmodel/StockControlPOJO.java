package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 29-10-2017.
 */

public class StockControlPOJO {

    private  String stockItemName;
    private  String stockItemType;

    public String getStockItemName() {
        return stockItemName;
    }

    public void setStockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
    }

    public String getStockItemType() {
        return stockItemType;
    }

    public void setStockItemType(String stockItemType) {
        this.stockItemType = stockItemType;
    }

    public String getStockItemDate() {
        return stockItemDate;
    }

    public void setStockItemDate(String stockItemDate) {
        this.stockItemDate = stockItemDate;
    }

    public String getStockItemDileveryDue() {
        return stockItemDileveryDue;
    }

    public void setStockItemDileveryDue(String stockItemDileveryDue) {
        this.stockItemDileveryDue = stockItemDileveryDue;
    }

    public String getStockItemNumber() {
        return stockItemNumber;
    }

    public void setStockItemNumber(String stockItemNumber) {
        this.stockItemNumber = stockItemNumber;
    }

    public String getStockItemOutlet() {
        return stockItemOutlet;
    }

    public void setStockItemOutlet(String stockItemOutlet) {
        this.stockItemOutlet = stockItemOutlet;
    }

    public String getStockItemSource() {
        return stockItemSource;
    }

    public void setStockItemSource(String stockItemSource) {
        this.stockItemSource = stockItemSource;
    }

    public String getStockItemStatus() {
        return stockItemStatus;
    }

    public void setStockItemStatus(String stockItemStatus) {
        this.stockItemStatus = stockItemStatus;
    }

    public String getStockItemItems() {
        return stockItemItems;
    }

    public void setStockItemItems(String stockItemItems) {
        this.stockItemItems = stockItemItems;
    }

    public String getStockItemTotalCost() {
        return stockItemTotalCost;
    }

    public void setStockItemTotalCost(String stockItemTotalCost) {
        this.stockItemTotalCost = stockItemTotalCost;
    }

    private  String stockItemDate;
    private  String stockItemDileveryDue;
    private  String stockItemNumber;
    private  String stockItemOutlet;

    public StockControlPOJO(String stockItemName, String stockItemType, String stockItemDate, String stockItemDileveryDue, String stockItemNumber, String stockItemOutlet, String stockItemSource, String stockItemStatus, String stockItemItems, String stockItemTotalCost) {
        this.stockItemName = stockItemName;
        this.stockItemType = stockItemType;
        this.stockItemDate = stockItemDate;
        this.stockItemDileveryDue = stockItemDileveryDue;
        this.stockItemNumber = stockItemNumber;
        this.stockItemOutlet = stockItemOutlet;
        this.stockItemSource = stockItemSource;
        this.stockItemStatus = stockItemStatus;
        this.stockItemItems = stockItemItems;
        this.stockItemTotalCost = stockItemTotalCost;
    }

    private  String stockItemSource;
    private  String stockItemStatus;
    private  String stockItemItems;
    private  String stockItemTotalCost;
}
