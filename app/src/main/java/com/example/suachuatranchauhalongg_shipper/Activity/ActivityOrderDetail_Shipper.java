package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.suachuatranchauhalongg_shipper.Adapter.DetailOrderAdapter;
import com.example.suachuatranchauhalongg_shipper.Adapter.OrderShippingAdapter;
import com.example.suachuatranchauhalongg_shipper.Object.OrderDetail;
import com.example.suachuatranchauhalongg_shipper.R;

import java.util.ArrayList;

public class ActivityOrderDetail_Shipper extends AppCompatActivity {
    RecyclerView recyclerViewDrinkOfOrderDetail;
    DetailOrderAdapter detailOrderAdapter;
    ArrayList<OrderDetail> orderDetailArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail__shipper);
        addControls();
        initData();
        addEvents();
    }

    private void initData() {
        orderDetailArrayList = new ArrayList<>();
        orderDetailArrayList.add(new OrderDetail(1,"1","Sữa chua xoài",R.drawable.face,25000,2));
        orderDetailArrayList.add(new OrderDetail(1,"1","Sữa chua xoài",R.drawable.face,25000,1));
        orderDetailArrayList.add(new OrderDetail(1,"1","Sữa chua xoài",R.drawable.face,25000,2));
        orderDetailArrayList.add(new OrderDetail(1,"1","Sữa chua xoài",R.drawable.face,25000,1));
        orderDetailArrayList.add(new OrderDetail(1,"1","Sữa chua xoài",R.drawable.face,25000,4));
        orderDetailArrayList.add(new OrderDetail(1,"1","Sữa chua xoài",R.drawable.face,25000,5));
        orderDetailArrayList.add(new OrderDetail(1,"1","Sữa chua xoài",R.drawable.face,25000,2));
        detailOrderAdapter = new DetailOrderAdapter(orderDetailArrayList,this);
        recyclerViewDrinkOfOrderDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewDrinkOfOrderDetail.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDrinkOfOrderDetail.setAdapter(detailOrderAdapter);
    }

    private void addControls()
    {
        recyclerViewDrinkOfOrderDetail = (RecyclerView) findViewById(R.id.ActivityOrderDetailShipper_recyclerDrink);
    }
    private void addEvents()
    {

    }
}
