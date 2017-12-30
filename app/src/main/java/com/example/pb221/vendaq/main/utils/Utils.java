package com.example.pb221.vendaq.main.utils;

import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DELL on 11/26/2017.
 */

public class Utils {

    public static String baseUrl = "http://shareusindia.com/koncept/api/jsons.php";

    public static String loginUrl = baseUrl + "?action=GetAuthenticationData";

    public static String getSuppliers = baseUrl + "?action=GetSuppliers";
    public static String addSuppliers = baseUrl + "?action=AddSuppliers";

    public static String addPriceBook = baseUrl + "?action=AddPriceBook";
    public static String getProducts = baseUrl + "?action=GetProducts";
    public static String getTags = baseUrl + "?action=GetTags";
    public static String getTypes = baseUrl + "?action=GetProductType";
    public static String getBrands = baseUrl + "?action=GetBrands";
    public static String addProducts = baseUrl + "?action=AddProduct";
    public static String stockTransfer = baseUrl + "?action=NewStockTransfer";
    public static String removeStock = baseUrl + "?action=RemoveStock";
    public static String addStock = baseUrl + "?action=stockadd";
    public static String addBrand = baseUrl + "?action=AddBrands";
    public static String getStockControl = baseUrl + "?action=GetStockControl";


    public static String DATABASE_NAME = "VendaHQ.db";
    public static final int DATABASE_VERSION = 1;
    public static String DATABASE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/VendaHQ/";

    public static String COLUMN_ID = "ID";

    public static String TABLE_SUPPLIER_DETAILS = "SUPPLIER_DETAILS";

    public static String COLUMN_SUPPLIER_ID = "SupplierId";
    public static String COLUMN_SUPPLIER_NAME = "SupplierName";
    public static String COLUMN_SUPPLIER_EMAIL = "SupplierEmail";
    public static String COLUMN_SUPPLIER_PHONE = "SupplierPhone";
    public static String COLUMN_SUPPLIER_ADDRESS = "Supplieraddress";
    public static String COLUMN_SUPPLIER_DESCRIPTION = "Description";
    public static String COLUMN_SUPPLIER_NUMBER_OF_PRODUCT = "NumberOfProducts";
    public static String COLUMN_SUPPLIER_DEFAULT_MARKUP = "DefaultMarkup";

    public static String TABLE_TAGS = "TAGS";
    public static String COLUMN_TAG_ID = "TagId";
    public static String COLUMN_TAG_NAME = "TagName";


    public static String TABLE_PRODUCT_TYPE = "PRODUCT_TYPE";
    public static String COLUMN_TYPE_ID = "TypeId";
    public static String COLUMN_TYPE_NAME = "TypeName";

    public static String TABLE_BRANDS_DETAILS = "BRAND_DETAILS";

    public static String COLUMN_BRAND_ID = "BrandId";
    public static String COLUMN_BRAND_NAME = "BrandName";
    public static String COLUMN_BRAND_DESCRIPTION = "BrandDescription";
    public static String COLUMN_BRAND_NUMBER_OF_PRODUCT = "NumberOfProducts";

    public static String TABLE_OUTLETS_DETAILS = "OUTLETS_DETAILS";

    public static String COLUMN_OUTLET_NAME = "OutletName";
    public static String COLUMN_CURRENT_INVENTORY = "CurrentInventory";
    public static String COLUMN_REORDER_POINT = "ReOrderPoint";
    public static String COLUMN_REORDER_QUANTITY = "ReOrderQuantity";


    public static String TABLE_TAX_DETAILS = "TAX_DETAILS";

    public static String COLUMN_TAX_OUTLET = "Outlet";
    public static String COLUMN_TAX= "tAX";


    public static String TABLE_VARIENTS_DETAILS = "VARIENTS_DETAILS";

    public static String COLUMN_VARIENT_NAME = "VariantName";
    public static String COLUMN_VARIENT_COUNT = "VariantCount";
    public static String COLUMN_SUPPLIER_CODE = "SupplierCode";
    public static String COLUMN_SUPPLIER_PRICE = "SupplierPrice";
    public static String COLUMN_RETAIL_PRICE= "RetailPrice";


    public static String TABLE_PRODUCT_LIST = "PRODUCT_LIST";

    public static String COLUMN_PRODUCT_ID = "Pid";
    public static String COLUMN_PRODUCT_NAME = "Name";
    public static String COLUMN_PRODUCT_BRAND_ID = "brandid";
    public static String COLUMN_PRODUCT_BRAND_NAME = "brand";
    public static String COLUMN_HANDLE = "handle";
    public static String COLUMN_DESCRIPTION = "description";
    public static String COLUMN_TAGS = "tags";
    public static String COLUMN_ISSELLABLE = "isSellable";
    public static String COLUMN_SKU = "SKU";
    public static String COLUMN_PRODUCT_SUPPLIER_CODE = "supplierCode";
    public static String COLUMN_PRODUCT_SUPPLIER_NAME = "supplier";
    public static String COLUMN_SUPPLY_PRICE = "Supplyprice";
    public static String COLUMN_USER_ID = "userid";
    public static String COLUMN_IS_INVENTORY = "IsInventory";
    public static String COLUMN_MARKUP = "Markup";
    public static String COLUMN_COUNT = "Count";
    public static String COLUMN_CREATED_DATE = "CreatedDate";

    public static String TABLE_STOCK_LIST = "STOCK_LIST";

    public static String COLUMN_STOCK_ID = "StockId";
    public static String COLUMN_STOCK_NAME = "StockName";
    public static String COLUMN_STOCK_USER_ID = "UserId";
    public static String COLUMN_STOCK_TYPE = "StockType";
    public static String COLUMN_STOCK_DATE = "Date";
    public static String COLUMN_STOCK_DELIVERY_DATE = "DeliveryDate";
    public static String COLUMN_STOCK_NUMBER = "Number";
    public static String COLUMN_STOCK_OUTLET = "Outlet";
    public static String COLUMN_STOCK_SOURCE = "Source";
    public static String COLUMN_STOCK_STATUS = "Status";
    public static String COLUMN_STOCK_ITEMS = "Items";
    public static String COLUMN_STOCK_TOTALCOST = "TotalCost";
    public static String COLUMN_STOCK_SKU = "SKU";
    public static String COLUMN_STOCK_HANDLE = "Handle";
    public static String COLUMN_STOCK_SUPPLIERCODE = "SupplierCode";


    public static void setAllTextView(Context context, ViewGroup parent) {
        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            final View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                setAllTextView(context, (ViewGroup) child);
            }
        }
    }
}