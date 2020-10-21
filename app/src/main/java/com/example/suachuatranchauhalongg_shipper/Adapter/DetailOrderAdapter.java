package com.example.suachuatranchauhalongg_shipper.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suachuatranchauhalongg_shipper.Object.Drink;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.Object.OrderDetail;
import com.example.suachuatranchauhalongg_shipper.R;
import com.example.suachuatranchauhalongg_shipper.Object.ListenerIDOrder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class DetailOrderAdapter extends RecyclerView.Adapter<DetailOrderAdapter.ViewHolder>  {
    List<OrderDetail> listOrderDetail ;
    Context context;
    private ListenerIDOrder send ;
    DatabaseReference databaseReference;
    public DetailOrderAdapter(List<OrderDetail> listOrderDetail,Context context)
    {
        this.listOrderDetail = listOrderDetail;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_orderdetail,parent,false);
        return new DetailOrderAdapter.ViewHolder(view);
    }
    String idBill;
    int mount;
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        initReference();
        send = new ListenerIDOrder();
        final OrderDetail orderDetail = listOrderDetail.get(position);
        databaseReference.child("ListOrder").child(send.getIDOrder()).child(send.getIDOrderDetail()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                OrderDetail orderDetail1 = dataSnapshot.getValue(OrderDetail.class);
                holder.txtMountDrink.setText("Số lượng : "+ orderDetail.getMount());
                mount = orderDetail1.getMount();
                databaseReference.child("ListDrink").child(orderDetail1.getIdDrink()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Drink drink = dataSnapshot.getValue(Drink.class);
                        holder.txtNameDrink.setText(drink.getNameDrink());
                        holder.txtTotalPriceDrink.setText("Giá : "+ (mount * drink.getPrice()));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
      //  holder.imgDrink.setImageResource(orderDetail.getImgUriDrink());

        //holder.txtMountDrink.setText("Số lượng : "+ orderDetail.getMount());
      //  int totalPrice = orderDetail.getPrice()* orderDetail.getMount();
       // holder.txtTotalPriceDrink.setText("Giá : " + totalPrice);

    }
    private void initReference()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
    @Override
    public int getItemCount() {
        return listOrderDetail.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDrink;
        TextView txtTotalPriceDrink,txtNameDrink,txtMountDrink;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDrink = (ImageView) itemView.findViewById(R.id.itemOrderDetail_imgOrder);
            txtNameDrink = (TextView) itemView.findViewById(R.id.itemOrderDetail_txtNameDrink);
            txtTotalPriceDrink = (TextView) itemView.findViewById(R.id.itemOrderDetail_txtTotalPriceDrink);
            txtMountDrink = (TextView) itemView.findViewById(R.id.itemOrderDetail_txtMountDrink);
        }
    }
}
