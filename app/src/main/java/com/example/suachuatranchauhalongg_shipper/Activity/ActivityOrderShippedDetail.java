package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suachuatranchauhalongg_shipper.Adapter.DetailOrderAdapter;
import com.example.suachuatranchauhalongg_shipper.Object.ListenerIDOrder;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.Object.OrderDetail;
import com.example.suachuatranchauhalongg_shipper.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityOrderShippedDetail extends AppCompatActivity {
    RecyclerView recyclerViewDrinkOfOrderDetail;
    DetailOrderAdapter detailOrderAdapter;
    ArrayList<OrderDetail> orderDetailArrayList;
    TextView txtIDBill,txtStatusThanhToan,txtName,txtPhone,txtAddress;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    Intent intent,intentCallPhone,intentMessage;
    String sđt = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_shipped_detail);
        initReferenceObject();
        sendDataForDetailOrderAdapter();
        addControls();
        getAllDataInOrder();
    }
    private void initReferenceObject()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        intent = getIntent();
    }
    private void getListDrinkDetail(String idOrderDetail) {
        orderDetailArrayList = new ArrayList<>();
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
//        orderDetailArrayList.add(new OrderDetail("DHDT01","DH01","DR01",2));
        detailOrderAdapter = new DetailOrderAdapter(orderDetailArrayList,this);
        recyclerViewDrinkOfOrderDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewDrinkOfOrderDetail.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDrinkOfOrderDetail.setAdapter(detailOrderAdapter);
    }
    private void getAllDataInOrder()
    {
        databaseReference.child("ListShipper").child(firebaseUser.getUid().toString()).child("ListOrder").child(intent.getStringExtra("IDOrder").toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     Order order = dataSnapshot.getValue(Order.class);
                     txtIDBill.setText(order.getIdOrder().toString());

                databaseReference.child("ListCustomer").child(order.getIdCustomer().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                getListDrinkDetail(order.getIdOrderDetail().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void addControls()
    {
        recyclerViewDrinkOfOrderDetail = (RecyclerView) findViewById(R.id.ActivityOrderShippedDetail_recyclerDrink);
        txtIDBill = (TextView) findViewById(R.id.ActivityOrderShippedDetail_txtBill);
        txtStatusThanhToan = (TextView) findViewById(R.id.ActivityOrderShippedDetail_txtThanhToan);
        txtName = (TextView) findViewById(R.id.ActivityOrderShippedDetail_txtNameCustomer);
        txtPhone = (TextView) findViewById(R.id.ActivityOrderShippedDetail_txtPhoneCustomer);
        txtAddress = (TextView) findViewById(R.id.ActivityOrderShippedDetail_txtAddressCustomer);
    }
    public void sendDataForDetailOrderAdapter()
    {
        ListenerIDOrder send  = new ListenerIDOrder();
        send.setIDOrder(intent.getStringExtra("IDOrder").toString());
        send.setIDOrderDetail(intent.getStringExtra("IDOrderDetail").toString());
    }

//    private void redirectActivityMessage(String phoneCustomerInOrder) {
//        intentMessage = new Intent();
//        intentMessage.setAction(Intent.ACTION_SENDTO);
//        intentMessage.putExtra("sms_body","Chào bạn.....");
//        intentMessage.setData(Uri.parse("sms:" + phoneCustomerInOrder));
//        startActivity(intentMessage);
//    }
//
//    private void redirectActivityCallPhone(String phoneCustomerInOrder) {
//        intentCallPhone  = new Intent();
//        intentCallPhone.setAction(Intent.ACTION_VIEW);
//        intentCallPhone.setData(Uri.parse("tel:" + phoneCustomerInOrder));
//        startActivity(intentCallPhone);
//    }
}
