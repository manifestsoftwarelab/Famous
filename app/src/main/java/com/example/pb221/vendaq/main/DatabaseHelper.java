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
import com.example.pb221.vendaq.product.productmodel.SupplierPOJO;
import com.example.pb221.vendaq.product.productmodel.ProductTagsPOJO;
import com.example.pb221.vendaq.product.productmodel.ProductTypePOJO;
import com.example.pb221.vendaq.main.utils.Utils;

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
                + COLUMN_BRAND_ID + " TEXT, "
                + COLUMN_BRAND_NAME + " TEXT, "
                + COLUMN_BRAND_DESCRIPTION + " TEXT, "
                + COLUMN_BRAND_NUMBER_OF_PRODUCT + " TEXT )";


        Log.d("onCreate ", "onCreate: " + CREATE_PRODUCT_LIST);
        db.execSQL(CREATE_PRODUCT_LIST);




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

        List<SupplierPOJO> supplierList =  new ArrayList<>();
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

        List<ProductTypePOJO> productTypeList =  new ArrayList<>();
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

                typePOJO = new ProductTypePOJO(TypeId,TypeName,NumberOfProduct);

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


        List<ProductTagsPOJO> tagList =  new ArrayList<>();
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

                tagPOJO = new ProductTagsPOJO(TagId,TagName,NumberOfProduct);

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
    }


    public List<BrandPOJO> getAllBrandsTableDetails(String id) {

        List<BrandPOJO> brandList =  new ArrayList<>();
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
}
