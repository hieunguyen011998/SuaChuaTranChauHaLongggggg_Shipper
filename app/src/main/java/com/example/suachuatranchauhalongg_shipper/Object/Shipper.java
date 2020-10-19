package com.example.suachuatranchauhalongg_shipper.Object;

import java.util.Date;

public class Shipper {
    private String idShipper;
    private String nameShipper;
    private boolean sexShipper;
    private String birthOfDayShipper;
    private String addressShipper;
    public Shipper()
    {

    }

    public Shipper(String idShipper, String nameShipper, boolean sexShipper, String birthOfDayShipper, String addressShipper) {
        this.idShipper = idShipper;
        this.nameShipper = nameShipper;
        this.sexShipper = sexShipper;
        this.birthOfDayShipper = birthOfDayShipper;
        this.addressShipper = addressShipper;
    }

    public String getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(String idShipper) {
        this.idShipper = idShipper;
    }

    public String getNameShipper() {
        return nameShipper;
    }

    public void setNameShipper(String nameShipper) {
        this.nameShipper = nameShipper;
    }

    public boolean isSexShipper() {
        return sexShipper;
    }

    public void setSexShipper(boolean sexShipper) {
        this.sexShipper = sexShipper;
    }

    public String getBirthOfDayShipper() {
        return birthOfDayShipper;
    }

    public void setBirthOfDayShipper(String birthOfDayShipper) {
        this.birthOfDayShipper = birthOfDayShipper;
    }

    public String getAddressShipper() {
        return addressShipper;
    }

    public void setAddressShipper(String addressShipper) {
        this.addressShipper = addressShipper;
    }
}
