package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.suachuatranchauhalongg_shipper.Adapter.OrderShippedAdapter;
import com.example.suachuatranchauhalongg_shipper.Adapter.OrderShippingAdapter;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OrderShipped_Shipper extends AppCompatActivity {
    RecyclerView recyclerViewOrderShipped;
    ArrayList<Order> arrayListOrder;
    OrderShippedAdapter orderShippedAdapter;
    Calendar calen;
    String dateOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_shipped__shipper);
        addControls();
        initData();
        addEvents();
    }
    public void addControls()
    {
        recyclerViewOrderShipped = (RecyclerView) findViewById(R.id.ActivityShippedShipper_recycleViewOrder);
    }
    private void addEvents() {
    }
    private void initData()
    {
        calen = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        dateOrder = "" + simpleDateFormat.format(calen.getTime());
        arrayListOrder = new ArrayList<>();
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        arrayListOrder.add(new Order("DH01","Sữa chua xoài",R.drawable.backgroudshipper,2,
                35000,dateOrder,1,"Nguyễn Văn Hiếu","0967508481","Pháp Vân - Tứ Hiệp"));
        orderShippedAdapter = new OrderShippedAdapter(arrayListOrder,this);
        recyclerViewOrderShipped.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewOrderShipped.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOrderShipped.setAdapter(orderShippedAdapter);
    }

}
