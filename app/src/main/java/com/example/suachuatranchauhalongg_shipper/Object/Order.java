package com.example.suachuatranchauhalongg_shipper.Object;

public class Order {
    private String maOrder;
    private String nameDrink;
    private int imgUriDrink;
    private int price;
    private int status;

    public Order(String maOrder, String nameDrink, int imgUriDrink, int price, int status) {
        this.maOrder = maOrder;
        this.nameDrink = nameDrink;
        this.imgUriDrink = imgUriDrink;
        this.price = price;
        this.status = status;
    }

    public String getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(String maOrder) {
        this.maOrder = maOrder;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public int getImgUriDrink() {
        return imgUriDrink;
    }

    public void setImgUriDrink(int imgUriDrink) {
        this.imgUriDrink = imgUriDrink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
