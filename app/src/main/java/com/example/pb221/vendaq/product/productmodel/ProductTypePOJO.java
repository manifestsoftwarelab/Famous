package com.example.pb221.vendaq.product.productmodel;

/**
 * Created by pb221 on 29-10-2017.
 */

public class ProductTypePOJO {
   private String productTypeId;
   private String productTypeName;
   private String productNoOfProduct;

   public ProductTypePOJO(String productTypeId, String productTypeName, String productNoOfProduct) {
      this.productTypeId = productTypeId;
      this.productTypeName = productTypeName;
      this.productNoOfProduct = productNoOfProduct;
   }

   public String getProductTypeId() {
      return productTypeId;
   }

   public void setProductTypeId(String productTypeId) {
      this.productTypeId = productTypeId;
   }

   public String getProductTypeName() {
      return productTypeName;
   }

   public void setProductTypeName(String productTypeName) {
      this.productTypeName = productTypeName;
   }

   public String getProductNoOfProduct() {
      return productNoOfProduct;
   }

   public void setProductNoOfProduct(String productNoOfProduct) {
      this.productNoOfProduct = productNoOfProduct;
   }
}
