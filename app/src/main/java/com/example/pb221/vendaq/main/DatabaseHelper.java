package com.example.pb221.vendaq.main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.pb221.vendaq.main.utils.Utils.*;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_BRAND_DESCRIPTION;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_BRAND_ID;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_BRAND_NAME;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_BRAND_NUMBER_OF_PRODUCT;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_BRANDS_DETAILS;

import com.example.pb221.vendaq.product.productmodel.BrandPOJO;
import com.example.pb221.vendaq.product.productmodel.OutletsPOJONew;
import com.example.pb221.vendaq.product.productmodel.ProductPOJONew;
import com.example.pb221.vendaq.product.productmodel.StockControlPOJO;
import com.example.pb221.vendaq.product.productmodel.SupplierPOJO;
import com.example.pb221.vendaq.product.productmodel.ProductTagsPOJO;
import com.example.pb221.vendaq.product.productmodel.ProductTypePOJO;
import com.example.pb221.vendaq.main.utils.Utils;
import com.example.pb221.vendaq.product.productmodel.TaxPOJONew;
import com.example.pb221.vendaq.product.productmodel.VarientsPOJONew;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manifest on 12/9/2017.
 */


public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, Utils.DATABASE_PATH + Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

        String CREATE_SUPPLIER_DETAILS = "CREATE TABLE " + TABLE_SUPPLIER_DETAILS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SUPPLIER_ID + " TEXT, "
                + COLUMN_SUPPLIER_NAME + " TEXT, "
                + COLUMN_SUPPLIER_EMAIL + " TEXT, "
                + COLUMN_SUPPLIER_PHONE + " TEXT, "
                + COLUMN_SUPPLIER_ADDRESS + " TEXT, "
                + COLUMN_SUPPLIER_DEFAULT_MARKUP + " TEXT, "
                + COLUMN_SUPPLIER_DESCRIPTION + " TEXT, "
                + COLUMN_SUPPLIER_NUMBER_OF_PRODUCT + " TEXT )";


        Log.d("onCreate ", "onCreate: " + CREATE_SUPPLIER_DETAILS);
        db.execSQL(CREATE_SUPPLIER_DETAILS);


        String CREATE_TAGS = "CREATE TABLE " + TABLE_TAGS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TAG_ID + " TEXT, "
                + COLUMN_TAG_NAME + " TEXT, "
                + COLUMN_SUPPLIER_NUMBER_OF_PRODUCT + " TEXT )";


        Log.d("onCreate ", "onCreate: " + CREATE_TAGS);
        db.execSQL(CREATE_TAGS);


        String CREATE_PRODUCT_TYPE = "CREATE TABLE " + TABLE_PRODUCT_TYPE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TYPE_ID + " TEXT, "
                + COLUMN_TYPE_NAME + " TEXT, "
                + COLUMN_SUPPLIER_NUMBER_OF_PRODUCT + " TEXT )";


        Log.d("onCreate ", "onCreate: " + CREATE_PRODUCT_TYPE);
        db.execSQL(CREATE_PRODUCT_TYPE);


        String CREATE_BRANDS_DETAILS = "CREATE TABLE " + TABLE_BRANDS_DETAILS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BRAND_ID + " TEXT, "
                + COLUMN_BRAND_NAME + " TEXT, "
                + COLUMN_BRAND_DESCRIPTION + " TEXT, "
                + COLUMN_BRAND_NUMBER_OF_PRODUCT + " TEXT )";


        Log.d("onCreate ", "onCreate: " + CREATE_BRANDS_DETAILS);
        db.execSQL(CREATE_BRANDS_DETAILS);

        String CREATE_PRODUCT_LIST = "CREATE TABLE " + TABLE_PRODUCT_LIST + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_ID + " TEXT, "
                + COLUMN_PRODUCT_NAME + " TEXT, "
                + COLUMN_PRODUCT_BRAND_ID + " TEXT, "
                + COLUMN_PRODUCT_BRAND_NAME + " TEXT, "
                + COLUMN_HANDLE + " TEXT, "
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_TAGS + " TEXT, "
                + COLUMN_ISSELLABLE + " TEXT, "
                + COLUMN_SKU + " TEXT, "
                + COLUMN_PRODUCT_SUPPLIER_CODE + " TEXT, "
                + COLUMN_PRODUCT_SUPPLIER_NAME + " TEXT, "
                + COLUMN_SUPPLY_PRICE + " TEXT, "
                + COLUMN_USER_ID + " TEXT, "
                + COLUMN_IS_INVENTORY + " TEXT, "
                + COLUMN_MARKUP + " TEXT, "
                + COLUMN_COUNT + " TEXT, "
                + COLUMN_CREATED_DATE + " TEXT )";


        Log.d("onCreate ", "onCreate: " + CREATE_PRODUCT_LIST);
        db.execSQL(CREATE_PRODUCT_LIST);


        String CREATE_OUTLETS_DETAILS = "CREATE TABLE " + TABLE_OUTLETS_DETAILS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_ID + " TEXT, "
                + COLUMN_OUTLET_NAME + " TEXT, "
                + COLUMN_CURRENT_INVENTORY + " TEXT, "
                + COLUMN_REORDER_POINT + " TEXT, "
                + COLUMN_REORDER_QUANTITY + " TEXT )";

        Log.d("onCreate ", "onCreate: " + CREATE_OUTLETS_DETAILS);
        db.execSQL(CREATE_OUTLETS_DETAILS);


        String CREATE_TAX_DETAILS = "CREATE TABLE " + TABLE_TAX_DETAILS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_ID + " TEXT, "
                + COLUMN_TAX_OUTLET + " TEXT, "
                + COLUMN_TAX + " TEXT )";

        Log.d("onCreate ", "onCreate: " + CREATE_TAX_DETAILS);
        db.execSQL(CREATE_TAX_DETAILS);


        String CREATE_VARIENTS_DETAILS = "CREATE TABLE " + TABLE_VARIENTS_DETAILS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_ID + " TEXT, "
                + COLUMN_VARIENT_NAME + " TEXT, "
                + COLUMN_VARIENT_COUNT + " TEXT, "
                + COLUMN_SUPPLIER_CODE + " TEXT, "
                + COLUMN_SUPPLIER_PRICE + " TEXT, "
                + COLUMN_RETAIL_PRICE + " TEXT )";

        Log.d("onCreate ", "onCreate: " + CREATE_VARIENTS_DETAILS);
        db.execSQL(CREATE_VARIENTS_DETAILS);



        String CREATE_STOCK_LIST = "CREATE TABLE " + TABLE_STOCK_LIST + " ("
                + COLUMN_STOCK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_STOCK_NAME + " TEXT, "
                + COLUMN_STOCK_USER_ID + " TEXT, "
                + COLUMN_STOCK_TYPE + " TEXT, "
                + COLUMN_STOCK_DATE + " TEXT, "
                + COLUMN_STOCK_DELIVERY_DATE + " TEXT, "
                + COLUMN_STOCK_NUMBER + " TEXT, "
                + COLUMN_STOCK_OUTLET + " TEXT, "
                + COLUMN_STOCK_SOURCE + " TEXT, "
                + COLUMN_STOCK_STATUS + " TEXT, "
                + COLUMN_STOCK_ITEMS + " TEXT, "
                + COLUMN_STOCK_TOTALCOST + " TEXT, "
                + COLUMN_STOCK_SKU + " TEXT, "
                + COLUMN_STOCK_HANDLE + " TEXT, "
                + COLUMN_STOCK_SUPPLIERCODE  + " TEXT )";

        Log.d("onCreate ", "onCreate: " + CREATE_STOCK_LIST);
        db.execSQL(CREATE_STOCK_LIST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertIntoSupplier(String SupplierId, String SupplierName, String SupplierEmail, String SupplierPhone, String Supplieraddress, String DefaultMarkup, String Description, String NumberOfProducts) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();

        valuess.put(COLUMN_SUPPLIER_ID, SupplierId);
        valuess.put(COLUMN_SUPPLIER_NAME, SupplierName);
        valuess.put(COLUMN_SUPPLIER_EMAIL, SupplierEmail);
        valuess.put(COLUMN_SUPPLIER_PHONE, SupplierPhone);
        valuess.put(COLUMN_SUPPLIER_ADDRESS, Supplieraddress);
        valuess.put(COLUMN_SUPPLIER_DEFAULT_MARKUP, DefaultMarkup);
        valuess.put(COLUMN_SUPPLIER_DESCRIPTION, Description);
        valuess.put(COLUMN_SUPPLIER_NUMBER_OF_PRODUCT, NumberOfProducts);

        db.insert(TABLE_SUPPLIER_DETAILS, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }

    public List getAllTableDetails(String id) {

        List<SupplierPOJO> supplierList = new ArrayList<>();
        SupplierPOJO suplierPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT  * FROM " + TABLE_SUPPLIER_DETAILS + " WHERE PRODUCT_ID = '" + id + "'";
        String query = "SELECT  * FROM " + TABLE_SUPPLIER_DETAILS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                suplierPOJO = new SupplierPOJO();

                String SupplierId = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_ID));
                String SupplierName = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_NAME));
                String SupplierEmail = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_EMAIL));
                String SupplierPhone = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_PHONE));
                String Supplieraddress = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_ADDRESS));
                String DefaultMarkup = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_DEFAULT_MARKUP));
                String Description = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_DESCRIPTION));
                String NumberOfProducts = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_NUMBER_OF_PRODUCT));

                suplierPOJO.setSupplierId(SupplierId);
                suplierPOJO.setSupplierName(SupplierName);
                suplierPOJO.setSupplierAddress(SupplierEmail);
                suplierPOJO.setSupplierPhone(SupplierPhone);
                suplierPOJO.setSupplierAddress(Supplieraddress);
                suplierPOJO.setSupplierDefaultMarkup(DefaultMarkup);
                suplierPOJO.setSupplierDescription(Description);
                suplierPOJO.setSupplierNumberOfProduct(NumberOfProducts);


                supplierList.add(suplierPOJO);

                cursor.moveToNext();

            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return supplierList;
    }

    public void insertIntoProductType(String TypeId, String TypeName, String NumberOfProduct) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();

        valuess.put(COLUMN_TYPE_ID, TypeId);
        valuess.put(COLUMN_TYPE_NAME, TypeName);
        valuess.put(COLUMN_SUPPLIER_NUMBER_OF_PRODUCT, NumberOfProduct);


        db.insert(TABLE_PRODUCT_TYPE, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }

    public List<ProductTypePOJO> getAllProductType() {

        List<ProductTypePOJO> productTypeList = new ArrayList<>();
        ProductTypePOJO typePOJO;
        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT  * FROM " + TABLE_SUPPLIER_DETAILS + " WHERE PRODUCT_ID = '" + id + "'";
        String query = "SELECT  * FROM " + TABLE_PRODUCT_TYPE;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {


                String TypeId = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE_ID));
                String TypeName = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE_NAME));
                String NumberOfProduct = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_NUMBER_OF_PRODUCT));

                typePOJO = new ProductTypePOJO(TypeId, TypeName, NumberOfProduct);

                productTypeList.add(typePOJO);

                cursor.moveToNext();

            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return productTypeList;
    }

    public void insertIntoTags(String TagId, String TagName, String NumberOfProduct) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();

        valuess.put(COLUMN_TAG_ID, TagId);
        valuess.put(COLUMN_TAG_NAME, TagName);
        valuess.put(COLUMN_SUPPLIER_NUMBER_OF_PRODUCT, NumberOfProduct);


        db.insert(TABLE_TAGS, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }

    public List<ProductTagsPOJO> getAllTags(String id) {


        List<ProductTagsPOJO> tagList = new ArrayList<>();
        ProductTagsPOJO tagPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT  * FROM " + TABLE_SUPPLIER_DETAILS + " WHERE PRODUCT_ID = '" + id + "'";
        String query = "SELECT  * FROM " + TABLE_TAGS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {


                String TagId = cursor.getString(cursor.getColumnIndex(COLUMN_TAG_ID));
                String TagName = cursor.getString(cursor.getColumnIndex(COLUMN_TAG_NAME));
                String NumberOfProduct = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_NUMBER_OF_PRODUCT));

                tagPOJO = new ProductTagsPOJO(TagId, TagName, NumberOfProduct);

                tagList.add(tagPOJO);

                cursor.moveToNext();

            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return tagList;
    }


    public void insertIntoBrand(String BrandId, String BrandName, String BrandDescription, String NumberOfProducts) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();

        valuess.put(COLUMN_BRAND_ID, BrandId);
        valuess.put(COLUMN_BRAND_NAME, BrandName);
        valuess.put(COLUMN_BRAND_DESCRIPTION, BrandDescription);
        valuess.put(COLUMN_BRAND_NUMBER_OF_PRODUCT, NumberOfProducts);

        db.insert(TABLE_BRANDS_DETAILS, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
        db.close();
    }

    public void deleteFromBrand()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_BRANDS_DETAILS;
        db.execSQL(query);
    }

    public List<BrandPOJO> getAllBrandsTableDetails(String id) {

        List<BrandPOJO> brandList = new ArrayList<>();
        BrandPOJO brandPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT  * FROM " + TABLE_SUPPLIER_DETAILS + " WHERE PRODUCT_ID = '" + id + "'";
        String query = "SELECT  * FROM " + TABLE_BRANDS_DETAILS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                brandPOJO = new BrandPOJO();

                String BrandId = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND_ID));
                String BrandName = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND_NAME));
                String BrandDes = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND_DESCRIPTION));
                String BrandNoOfProduct = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND_NUMBER_OF_PRODUCT));

                brandPOJO.setBrandId(BrandId);
                brandPOJO.setBrandName(BrandName);
                brandPOJO.setBrandDescription(BrandDes);
                brandPOJO.setNumberOfProducts(BrandNoOfProduct);


                brandList.add(brandPOJO);

                cursor.moveToNext();

            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return brandList;
    }


    public void insertIntoProductList(String pid, String Name, String brandid, String brand, String handle, String description,
                                      String tags, String isSellable, String SKU, String supplierCode, String supplier, String Supplyprice,
                                      String userid, String IsInventory, String Markup, String Count, String CreatedDate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();


        valuess.put(COLUMN_PRODUCT_ID, pid);
        valuess.put(COLUMN_PRODUCT_NAME, Name);
        valuess.put(COLUMN_PRODUCT_BRAND_ID, brandid);
        valuess.put(COLUMN_PRODUCT_BRAND_NAME, brand);
        valuess.put(COLUMN_HANDLE, handle);
        valuess.put(COLUMN_DESCRIPTION, description);
        valuess.put(COLUMN_TAGS, tags);
        valuess.put(COLUMN_ISSELLABLE, isSellable);
        valuess.put(COLUMN_SKU, SKU);
        valuess.put(COLUMN_PRODUCT_SUPPLIER_CODE, supplierCode);
        valuess.put(COLUMN_PRODUCT_SUPPLIER_NAME, supplier);
        valuess.put(COLUMN_SUPPLY_PRICE, Supplyprice);
        valuess.put(COLUMN_USER_ID, userid);
        valuess.put(COLUMN_IS_INVENTORY, IsInventory);
        valuess.put(COLUMN_MARKUP, Markup);
        valuess.put(COLUMN_COUNT, Count);
        valuess.put(COLUMN_CREATED_DATE, CreatedDate);


        db.insert(TABLE_PRODUCT_LIST, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }


    public List<ProductPOJONew> getAllProductListDetails() {

        List<ProductPOJONew> productList = new ArrayList<>();
        ProductPOJONew productPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE_PRODUCT_LIST;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {


                String productId = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_ID));
                String productName = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME));
                String productBrandId = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_BRAND_ID));
                String productBrandName = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_BRAND_NAME));
                String productHandle = cursor.getString(cursor.getColumnIndex(COLUMN_HANDLE));
                String productDescription = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                String productTags = cursor.getString(cursor.getColumnIndex(COLUMN_TAGS));
                String productIsSellable = cursor.getString(cursor.getColumnIndex(COLUMN_ISSELLABLE));
                String productSKU = cursor.getString(cursor.getColumnIndex(COLUMN_SKU));
                String productSupplierCode = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_SUPPLIER_CODE));
                String productSupplierName = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_SUPPLIER_NAME));
                String productSupplyPrice = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLY_PRICE));
                String productUserId = cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID));
                String productIsInventory = cursor.getString(cursor.getColumnIndex(COLUMN_IS_INVENTORY));
                String productIsMarkUp = cursor.getString(cursor.getColumnIndex(COLUMN_MARKUP));
                String productCount = cursor.getString(cursor.getColumnIndex(COLUMN_COUNT));
                String productCreatedDate = cursor.getString(cursor.getColumnIndex(COLUMN_CREATED_DATE));

                List<OutletsPOJONew> outletlist = getAllOutletsInProductList(productId);
                List<VarientsPOJONew> varientlist = getAllVarientsInProductList(productId);
                List<TaxPOJONew> taxList = getAllTaxInProductList(productId);


                productPOJO = new ProductPOJONew(productId, outletlist, taxList, varientlist, productName,
                        productBrandId, productBrandName, productHandle, productDescription,
                        productTags, "", productIsSellable, productSKU, productSupplierCode,
                        productSupplierName, productSupplyPrice, productUserId, productIsInventory,
                        productIsMarkUp, productCount, productCreatedDate);


                productList.add(productPOJO);

                cursor.moveToNext();

            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return productList;
    }


    public void insertIntoOutlets(String pid, String OutletName, String CurrentInventory, String ReOrderPoint, String ReOrderQuantity) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();
        valuess.put(COLUMN_PRODUCT_ID, pid);
        valuess.put(COLUMN_OUTLET_NAME, OutletName);
        valuess.put(COLUMN_CURRENT_INVENTORY, CurrentInventory);
        valuess.put(COLUMN_REORDER_POINT, ReOrderPoint);
        valuess.put(COLUMN_REORDER_QUANTITY, ReOrderQuantity);

        db.insert(TABLE_OUTLETS_DETAILS, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }


    public void insertIntoTax(String pid, String Outlet, String Tax) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();
        valuess.put(COLUMN_PRODUCT_ID, pid);

        valuess.put(COLUMN_TAX_OUTLET, Outlet);
        valuess.put(COLUMN_TAX, Tax);

        db.insert(TABLE_TAX_DETAILS, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }


    public void insertIntoVarient(String pid, String VariantName, String VariantCount, String SupplierCode, String SupplierPrice, String RetailPrice) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();

        valuess.put(COLUMN_VARIENT_NAME, VariantName);
        valuess.put(COLUMN_PRODUCT_ID, pid);
        valuess.put(COLUMN_VARIENT_COUNT, VariantCount);
        valuess.put(COLUMN_SUPPLIER_CODE, SupplierCode);
        valuess.put(COLUMN_SUPPLIER_PRICE, SupplierPrice);
        valuess.put(COLUMN_RETAIL_PRICE, RetailPrice);

        db.insert(TABLE_VARIENTS_DETAILS, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }


    public List<OutletsPOJONew> getAllOutletsInProductList(String id) {

        List<OutletsPOJONew> outletList = new ArrayList<>();

        OutletsPOJONew outletPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
        String query;
        if (id != "") {
             query = "SELECT  * FROM " + TABLE_OUTLETS_DETAILS + " where Pid = '" + id + "'";
        }
        else
        {
            query = "SELECT  * FROM " + TABLE_OUTLETS_DETAILS;
        }
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {


                String outletName = cursor.getString(cursor.getColumnIndex(COLUMN_OUTLET_NAME));
                String currentInventory = cursor.getString(cursor.getColumnIndex(COLUMN_CURRENT_INVENTORY));
                String reorderPoint = cursor.getString(cursor.getColumnIndex(COLUMN_REORDER_POINT));
                String reorderQuantity = cursor.getString(cursor.getColumnIndex(COLUMN_REORDER_QUANTITY));

                outletPOJO = new OutletsPOJONew(outletName, currentInventory, reorderPoint, reorderQuantity);

                outletList.add(outletPOJO);

                cursor.moveToNext();

            }

        } else {
        }
        return outletList;
    }

    public List<TaxPOJONew> getAllTaxInProductList(String id) {

        List<TaxPOJONew> taxList = new ArrayList<>();

        TaxPOJONew taxPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE_TAX_DETAILS + " where Pid = '" + id + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {


                String taxOutlets = cursor.getString(cursor.getColumnIndex(COLUMN_TAX_OUTLET));
                String tax = cursor.getString(cursor.getColumnIndex(COLUMN_TAX));

                taxPOJO = new TaxPOJONew(taxOutlets, tax);

                taxList.add(taxPOJO);

                cursor.moveToNext();

            }

        } else {
        }
        return taxList;
    }

    public List<VarientsPOJONew> getAllVarientsInProductList(String id) {

        List<VarientsPOJONew> varientList = new ArrayList<>();

        VarientsPOJONew varientPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE_VARIENTS_DETAILS + " where Pid = '" + id + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {


                String varientName = cursor.getString(cursor.getColumnIndex(COLUMN_VARIENT_NAME));
                String varientCount = cursor.getString(cursor.getColumnIndex(COLUMN_VARIENT_COUNT));
                String supplierCode = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_CODE));
                String supplierPrice = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_PRICE));
                String retailPrice = cursor.getString(cursor.getColumnIndex(COLUMN_RETAIL_PRICE));

                varientPOJO = new VarientsPOJONew(varientName, varientCount, supplierCode, supplierPrice, retailPrice);

                varientList.add(varientPOJO);

                cursor.moveToNext();

            }

        } else {
        }
        return varientList;
    }

    public void insertIntoStockControl(String StockId, String StockName, String UserId, String StockType, String Date, String DeliveryDate, String Number, String Outlet, String Source , String Status, String Items, String TotalCost, String SKU, String Handle, String SupplierCode) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();

        valuess.put(COLUMN_STOCK_ID, StockId);
        valuess.put(COLUMN_STOCK_NAME, StockName);
        valuess.put(COLUMN_STOCK_USER_ID, UserId);
        valuess.put(COLUMN_STOCK_TYPE , StockType);
        valuess.put(COLUMN_STOCK_DATE, Date);
        valuess.put(COLUMN_STOCK_DELIVERY_DATE, DeliveryDate);
        valuess.put(COLUMN_STOCK_NUMBER, Number);
        valuess.put(COLUMN_STOCK_OUTLET, Outlet);
        valuess.put(COLUMN_STOCK_SOURCE, Source);
        valuess.put(COLUMN_STOCK_STATUS, Status);
        valuess.put(COLUMN_STOCK_ITEMS, Items);
        valuess.put(COLUMN_STOCK_TOTALCOST, TotalCost);
        valuess.put(COLUMN_STOCK_SKU, SKU);
        valuess.put(COLUMN_STOCK_HANDLE, Handle);
        valuess.put(COLUMN_STOCK_SUPPLIERCODE, SupplierCode);

        db.insert(TABLE_STOCK_LIST, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }

    public List getAllStockDetails(String id) {

        List<StockControlPOJO> stockList = new ArrayList<>();
        StockControlPOJO stockPOJO;
        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT  * FROM " + TABLE_SUPPLIER_DETAILS + " WHERE PRODUCT_ID = '" + id + "'";
        String query = "SELECT  * FROM " + TABLE_STOCK_LIST;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                String StockId = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_ID));;
                String StockName = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_NAME));;
                String UserId = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_USER_ID));;
                String StockType = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_TYPE));;
                String Date = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_DATE));;
                String DeliveryDate = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_DELIVERY_DATE));;
                String Number = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_NUMBER));;
                String Outlet = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_OUTLET));;
                String Source = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_SOURCE));;
                String Status = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_STATUS));;
                String Items = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_ITEMS));;
                String TotalCost = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_TOTALCOST));;
                String SKU = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_SKU));;
                String Handle = cursor.getString(cursor.getColumnIndex(COLUMN_STOCK_HANDLE));;
                String SupplierCode = cursor.getString(cursor.getColumnIndex(COLUMN_SUPPLIER_CODE));;

                stockPOJO = new StockControlPOJO(StockId,StockName,UserId,StockType,Date,DeliveryDate,Number,Outlet,Source,Status,Items,TotalCost,SKU,Handle,SupplierCode);

                stockList.add(stockPOJO);

                cursor.moveToNext();

            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return stockList;
    }

    public void deleteFromStockControl()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_STOCK_LIST;
        db.execSQL(query);
    }
    public void deleteFromTable(String table)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + table;
        db.execSQL(query);
    }
}
