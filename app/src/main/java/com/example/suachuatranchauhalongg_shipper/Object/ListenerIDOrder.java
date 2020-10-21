package com.example.suachuatranchauhalongg_shipper.Object;

public class ListenerIDOrder {
    private static String IDOrder ;
    private static String IDOrderDetail ;
    public ListenerIDOrder()
    {

    }

    public ListenerIDOrder(String IDOrder,String IDOrderDetail ) {
        this.IDOrder = IDOrder;
        this.IDOrderDetail = IDOrderDetail;
    }

    public String getIDOrder() {
        return IDOrder;
    }

    public void setIDOrder(String IDOrder) {
        this.IDOrder = IDOrder;
    }

    public  String getIDOrderDetail() {
        return IDOrderDetail;
    }

    public  void setIDOrderDetail(String IDOrderDetail) {
        ListenerIDOrder.IDOrderDetail = IDOrderDetail;
    }
}
