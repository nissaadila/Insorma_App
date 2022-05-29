package com.example.insorma;

public class ProductInsorma {
    int idProduct;
    int image;
    String productName;
    Float rating;
    Integer price;

    public ProductInsorma(int _idProduct, int _image, String _productName, Float _rating, Integer _price) {
        idProduct = _idProduct;
        image = _image;
        productName = _productName;
        rating = _rating;
        price = _price;
    }


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}




