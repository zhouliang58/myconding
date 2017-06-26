package com.zl.ood.srp.zhouliang;

/**
 * Created by zhouliang on 2017-06-26.
 */
public class Product {
    private String productID;//产品ID
    private String productDesc;//产品描述

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
