package com.numeroeins.uniflea;

import android.graphics.Bitmap;

/**
 * Created by numeroeins on 10/11/17.
 */

public class Product {

    private int productImage;
    private String productName;
    private String productPrice;
    private String location;
    private boolean isLike;


    public Product(int productImage, String productName, String productPrice, String location, boolean isLike) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.location = location;
        this.isLike = isLike;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
