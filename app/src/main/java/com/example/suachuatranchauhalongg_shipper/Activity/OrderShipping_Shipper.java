package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.suachuatranchauhalongg_shipper.Adapter.OrderShippingAdapter;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OrderShipping_Shipper extends AppCompatActivity {
    ArrayList<Order> arrayListOrder;
    OrderShippingAdapter orderShippingAdapter;
    RecyclerView recyclerViewOrder;
    Calendar calen;
    String dateOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_shipping__shipper);
        addControls();
        initData();
        addEvents();
    }

    private void addEvents() {
        recyclerViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
//    public void addOnClick(String k)
//    {
//        Toast.makeText(this, "" + k , Toast.LENGTH_SHORT).show();
//    }
    private void initData()
    {
        calen = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        dateOrder = "" + simpleDateFormat.format(calen.getTime());
        arrayListOrder = new ArrayList<>();
        arrayListOrder.add(new Order("DH01","DR01","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH02","DR02","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH03","DR03","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH04","DR04","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH05","DR05","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH06","DR06","KH01",2,
                35000,0,25000,95000,dateOrder,2,false));
        arrayListOrder.add(new Order("DH07","DR07","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH08","DR08","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH09","DR09","KH01",2,
                35000,0,25000,95000,dateOrder,2,true));
        arrayListOrder.add(new Order("DH010","DR010","KH01",2,
                35000,0,25000,95000,dateOrder,2,false));
        orderShippingAdapter = new OrderShippingAdapter(arrayListOrder,this);
        recyclerViewOrder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewOrder.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOrder.setAdapter(orderShippingAdapter);
    }
    private void addControls() {
        recyclerViewOrder = (RecyclerView) findViewById(R.id.ActivityShippingShipper_recycleViewOrder);
    }
}
