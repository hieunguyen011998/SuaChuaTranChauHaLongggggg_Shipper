package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.suachuatranchauhalongg_shipper.Adapter.OrderShippedAdapter;
import com.example.suachuatranchauhalongg_shipper.Adapter.OrderShippingAdapter;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OrderShipped_Shipper extends AppCompatActivity {
    RecyclerView recyclerViewOrderShipped;
    ArrayList<Order> arrayListOrder;
    OrderShippedAdapter orderShippedAdapter;
    Calendar calen;
    String dateOrder;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
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
    private void initReferenceObject()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getInstance().getCurrentUser();
    }
    private void addEvents() {
    }
    //ListOrder->usercurrent->idOrder->order(ListOrderDetail)(Shipper)(Customer)
    private void initData()
    {
        calen = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        dateOrder = "" + simpleDateFormat.format(calen.getTime());
        arrayListOrder = new ArrayList<>();
        databaseReference.child("ListOrder").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    for(DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren())
                    {
                        Order order = dataSnapshot2.getValue(Order.class);
                        if(order.getStatus()==5 && order.getIdShiper().toString().equals(firebaseUser.getUid().toString()))
                        {
                            arrayListOrder.add(order);
                        }
                    }
                }
                orderShippedAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        orderShippedAdapter = new OrderShippedAdapter(arrayListOrder,this);
        recyclerViewOrderShipped.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewOrderShipped.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOrderShipped.setAdapter(orderShippedAdapter);
    }

}
