package com.example.suachuatranchauhalongg_shipper.Object;

public class Drink {
    private int idDrink;
    private String nameDrink;
    private String imgUriDrink;
    private int price;

    public Drink(int idDrink, String nameDrink, String imgUriDrink, int price) {
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

    public String getImgUriDrink() {
        return imgUriDrink;
    }

    public void setImgUriDrink(String imgUriDrink) {
        this.imgUriDrink = imgUriDrink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
