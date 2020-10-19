package com.example.suachuatranchauhalongg_shipper.Object;

public class Drink {
    private int idDrink;
    private String nameDrink;
    private int imgUriDrink;
    private int price;

    public Drink(int idDrink, String nameDrink, int imgUriDrink, int price) {
        this.idDrink = idDrink;
        this.nameDrink = nameDrink;
        this.imgUriDrink = imgUriDrink;
        this.price = price;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
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

}
