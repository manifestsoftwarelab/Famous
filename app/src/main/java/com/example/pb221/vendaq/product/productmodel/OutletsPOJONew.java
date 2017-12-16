package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by Manifest on 12/9/2017.
 */

public class OutletsPOJONew {
  String  OutletName;
  String  CurrentInventory;

    public String getOutletName() {
        return OutletName;
    }

    public void setOutletName(String outletName) {
        OutletName = outletName;
    }

    public String getCurrentInventory() {
        return CurrentInventory;
    }

    public void setCurrentInventory(String currentInventory) {
        CurrentInventory = currentInventory;
    }

    public String getReOrderPoint() {
        return ReOrderPoint;
    }

    public void setReOrderPoint(String reOrderPoint) {
        ReOrderPoint = reOrderPoint;
    }

    public String getReOrderQuantity() {
        return ReOrderQuantity;
    }

    public void setReOrderQuantity(String reOrderQuantity) {
        ReOrderQuantity = reOrderQuantity;
    }

    String  ReOrderPoint;
  String  ReOrderQuantity;
}
