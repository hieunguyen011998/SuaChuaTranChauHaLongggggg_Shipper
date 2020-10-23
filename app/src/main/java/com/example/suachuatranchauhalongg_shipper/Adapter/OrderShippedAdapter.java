package com.example.suachuatranchauhalongg_shipper.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suachuatranchauhalongg_shipper.Activity.ActivityOrderDetail_Shipper;
import com.example.suachuatranchauhalongg_shipper.Activity.ActivityOrderShippedDetail;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class OrderShippedAdapter extends RecyclerView.Adapter<OrderShippedAdapter.ViewHolder> {
    private List<Order> listOrder;
    private Context context;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    public OrderShippedAdapter(List<Order> listOrder,Context context ) {
        this.listOrder = listOrder;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ordershipped,parent,false);
        return new OrderShippedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        initReference();
        final Order order = listOrder.get(position);
//        databaseReference.child(firebaseUser.getUid().toString()).child("ListOrderOfShipper").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        holder.txtMaOrder.setText(order.getIdOrder());
        holder.txtPriceInOrder.setText("Thanh toán : "+ order.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   orderShipping_shipper = new OrderShipping_Shipper();
                // orderShipping_shipper.addOnClick("" + position);
                Intent intent = new Intent(context, ActivityOrderShippedDetail.class);
                intent.putExtra("IDOrderDetail",order.getIdOrderDetail());
                intent.putExtra("IDOrder",order.getIdOrder());
                context.startActivity(intent);
                // Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void initReference()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getInstance().getCurrentUser();
    }
    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMaOrder,txtPriceInOrder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaOrder = (TextView) itemView.findViewById(R.id.item_ordershipped_txtIDOrder);
            txtPriceInOrder = (TextView) itemView.findViewById(R.id.item_ordershipped_txtPriceOrder);
        }
    }
}
