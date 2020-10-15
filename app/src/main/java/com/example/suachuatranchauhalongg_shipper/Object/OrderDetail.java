package com.example.suachuatranchauhalongg_shipper.Object;

public class OrderDetail {
    private int idDrink;
    private String maOrder;
    private String nameDrink;
    private int mount ;
    private int imgUriDrink;
    private int price;

    public OrderDetail(int idDrink, String maOrder, String nameDrink, int imgUriDrink, int price,int mount) {
        this.idDrink = idDrink;
        this.maOrder = maOrder;
        this.nameDrink = nameDrink;
        this.imgUriDrink = imgUriDrink;
        this.price = price;
        this.mount = mount;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
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

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }
}
