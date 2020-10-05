package com.example.suachuatranchauhalongg_shipper.Object;

public class Order {
    private String maOrder;
    private String nameDrink;
    private int imgUriDrink;
    private int mount;
    private int price;
    private String dateOrder;
    private int status;
    private String nameCustomer;
    private String phoneCustomer;
    private String addressCustomer;

    public Order(String maOrder, String nameDrink, int imgUriDrink,int mount, int price,String dateOrder, int status,String nameCustomer,String phoneCustomer,String addressCustomer) {
        this.maOrder = maOrder;
        this.nameDrink = nameDrink;
        this.imgUriDrink = imgUriDrink;
        this.mount = mount;
        this.price = price;
        this.dateOrder = dateOrder;
        this.status = status;
        this.nameCustomer = nameCustomer;
        this.phoneCustomer = phoneCustomer;
        this.addressCustomer = addressCustomer;
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

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
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

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }
}
