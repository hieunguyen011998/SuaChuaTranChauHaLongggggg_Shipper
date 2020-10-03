package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.suachuatranchauhalongg_shipper.R;

public class OrderShipped_Shipper extends AppCompatActivity {
    RecyclerView recyclerViewOrderShipped;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_shipped__shipper);
        addControls();
        addEvents();
    }
    public void addControls()
    {
        recyclerViewOrderShipped = (RecyclerView) findViewById(R.id.ActivityShippedShipper_recycleViewOrder);
    }
    public void addEvents()
    {

    }
}
