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
import android.widget.Toast;

import com.example.suachuatranchauhalongg_shipper.Adapter.DetailOrderAdapter;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.Object.OrderDetail;
import com.example.suachuatranchauhalongg_shipper.Object.Shipper;
import com.example.suachuatranchauhalongg_shipper.R;
import com.example.suachuatranchauhalongg_shipper.Object.ListenerIDOrder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityOrderDetail_Shipper extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerViewDrinkOfOrderDetail;
    DetailOrderAdapter detailOrderAdapter;
    ArrayList<OrderDetail> orderDetailArrayList;
    TextView txtMaOrder,txtMount,txtIDBill,txtStatusThanhToan,txtName,txtPhone,txtAddress,txtThanhToan,txtPhiVanChuyen,txtKhuyenMai,txtTotalThanhToan;
    ImageView imgPhone,imgMessage;
    Button btnNhanDonHang;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    Intent intent,intentCallPhone,intentMessage;
    String sđt = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail__shipper);
        initReferenceObject();
        sendDataForDetailOrderAdapter();
        addControls();
        getAllDataInOrder();
        getListDrinkDetail("");
        addEvents();
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
          databaseReference.child("ListOrder");
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
    private void getAllDataInOrder()
    {
        //Lấy ra thông tin đơn hàng
        databaseReference.child("ListOrder").child(intent.getStringExtra("IDOrder").toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Order order = dataSnapshot.getValue(Order.class);
                txtMaOrder.setText(order.getIdOrder().toString());
                txtThanhToan.setText("Thanh toán : " + order.getPrice());
                txtKhuyenMai.setText("Khuyến mãi : " + order.getPromotion());
                txtPhiVanChuyen.setText("Phí vận chuyển : " + order.getPriceShip());
                txtThanhToan.setText("Tổng thanh toán : " + order.getTotalPrice());
                //Lấy ra thông tin khách hàng của đơn hàng
                databaseReference.child("ListCustomer").child(order.getIdCustomer().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                databaseReference.child("ListOrder").child(intent.getStringExtra("IDOrder").toString()).child("ListOrderDetail").addValueEventListener(new ValueEventListener() {
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
        recyclerViewDrinkOfOrderDetail = (RecyclerView) findViewById(R.id.ActivityOrderDetailShipper_recyclerDrink);
        txtStatusThanhToan = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtStatusThanhToan);
        txtMaOrder = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtMaOrder);
        txtName = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtNameCustomer);
        txtPhone = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtPhoneCustomer);
        txtAddress = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtAddressCustomer);
        imgPhone = (ImageView) findViewById(R.id.ActivityOrderDetailShipper_imgCallPhone);
        imgMessage = (ImageView) findViewById(R.id.ActivityOrderDetailShipper_imgMessage);
        btnNhanDonHang = (Button) findViewById(R.id.ActivityOrderDetailShipper_btnNhanDonHang);
        txtMount = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtMountDrinkDetail);
        txtThanhToan = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtThanhToan);
        txtKhuyenMai = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtKhuyenMai);
        txtPhiVanChuyen = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtPhiVanChuyen);
        txtTotalThanhToan = (TextView) findViewById(R.id.ActivityOrderDetailShipper_txtTongThanhToan);
    }
    private void addEvents()
    {
        imgMessage.setOnClickListener(this);
        imgPhone.setOnClickListener(this);
        btnNhanDonHang.setOnClickListener(this);
    }
    public void sendDataForDetailOrderAdapter()
    {
        ListenerIDOrder send  = new ListenerIDOrder();
        send.setIDOrder(intent.getStringExtra("IDOrder").toString());
        send.setIDOrderDetail(intent.getStringExtra("IDOrderDetail").toString());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ActivityOrderDetailShipper_imgCallPhone :
                redirectActivityCallPhone("0967508481");
                break;
            case R.id.ActivityOrderDetailShipper_imgMessage :
                redirectActivityMessage("0967508481");
                break;
            case R.id.ActivityOrderDetailShipper_btnNhanDonHang :
                nhanDonHang();
                break;
        }

    }

    private void nhanDonHang() {
        databaseReference.child("ListOrder").child(intent.getStringExtra("idCustomer").toString()).
                child(intent.getStringExtra("IDOrder").toString()).child("idShipper").setValue(firebaseUser.getUid().toString());
        //lấy ra thông tin shipper
        databaseReference.child("ListShipper").child(firebaseUser.getUid().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Shipper shipper = dataSnapshot.getValue(Shipper.class);
                databaseReference.child("ListOrder").child(intent.getStringExtra("idCustomer").toString()).
                        child(intent.getStringExtra("IDOrder").toString()).
                        child("Shipper").child(firebaseUser.getUid().toString()).setValue(shipper);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        Intent intent = new Intent(this,ActivityOrderOfCustomer.class);
//        startActivity(intent);
        Toast.makeText(this, "Bạn đã nhận đơn hàng thành công", Toast.LENGTH_SHORT).show();
    }

    private void redirectActivityMessage(String phoneCustomerInOrder) {
        intentMessage = new Intent();
        intentMessage.setAction(Intent.ACTION_SENDTO);
        intentMessage.putExtra("sms_body","Chào bạn.....");
        intentMessage.setData(Uri.parse("sms:" + phoneCustomerInOrder));
        startActivity(intentMessage);
    }

    private void redirectActivityCallPhone(String phoneCustomerInOrder) {
        intentCallPhone  = new Intent();
        intentCallPhone.setAction(Intent.ACTION_VIEW);
        intentCallPhone.setData(Uri.parse("tel:" + phoneCustomerInOrder));
        startActivity(intentCallPhone);
    }

//    private String getPhoneCustomerInOrder() {
//        databaseReference.child("ListOrder").child(intent.getStringExtra("IDOrder").toString()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Order order = dataSnapshot.getValue(Order.class);
//                databaseReference.child("ListCustomer").child(order.getIdCustomer().toString()).addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        return sđt;
//    }

}
