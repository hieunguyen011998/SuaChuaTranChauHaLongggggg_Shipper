package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suachuatranchauhalongg_shipper.Adapter.DetailOrderAdapter;
import com.example.suachuatranchauhalongg_shipper.Object.OrderDetail;
import com.example.suachuatranchauhalongg_shipper.R;
import com.example.suachuatranchauhalongg_shipper.Object.ListenerIDOrder;

import java.util.ArrayList;

public class ActivityOrderDetail_Shipper extends AppCompatActivity {
    RecyclerView recyclerViewDrinkOfOrderDetail;
    DetailOrderAdapter detailOrderAdapter;
    ArrayList<OrderDetail> orderDetailArrayList;
    TextView txtIDBill,txtStatusThanhToan,txtName,txtPhone,txtAddress;
    ImageView imgPhone,imgMessage;
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
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        detailOrderAdapter = new DetailOrderAdapter(orderDetailArrayList,this);
        recyclerViewDrinkOfOrderDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewDrinkOfOrderDetail.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDrinkOfOrderDetail.setAdapter(detailOrderAdapter);
    }

    private void addControls()
    {
        recyclerViewDrinkOfOrderDetail = (RecyclerView) findViewById(R.id.ActivityOrderDetailShipper_recyclerDrink);
        txtIDBill = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtBill);
    }
    private void addEvents()
    {
        Intent intent = getIntent();
        ListenerIDOrder send  = new ListenerIDOrder();
        send.setIDOrder(intent.getStringExtra("IDBill").toString());
        Toast.makeText(this, "" + intent.getStringExtra("IDBill").toString(), Toast.LENGTH_SHORT).show();
       // sendID.idDrink(intent.getStringExtra("IDBill").toString()) ;
    }
}
