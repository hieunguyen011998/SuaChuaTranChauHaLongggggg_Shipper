package com.example.suachuatranchauhalongg_shipper.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suachuatranchauhalongg_shipper.Activity.ActivityOrderDetail_Shipper;
import com.example.suachuatranchauhalongg_shipper.Activity.OrderShipping_Shipper;
import com.example.suachuatranchauhalongg_shipper.Object.Order;
import com.example.suachuatranchauhalongg_shipper.R;

import java.util.List;

public class OrderShippingAdapter extends RecyclerView.Adapter<OrderShippingAdapter.ViewHolder> {
    private List<Order> listOrder;
    private Context context;
    public OrderShippingAdapter(List<Order> listOrder,Context context ) {
        this.listOrder = listOrder;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ordershipping,parent,false);
        return new OrderShippingAdapter.ViewHolder(view);
    }
    OrderShipping_Shipper orderShipping_shipper;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final Order order = listOrder.get(position);
        holder.txtMaOrder.setText(order.getIdOrder());
        holder.txtPriceInOrder.setText("Thanh toán : "+ order.getPrice());
        if(order.getStatus()==2)
        {
            holder.frameStatusConfirmed.setVisibility(View.VISIBLE);
            holder.frameStatusSetUpDrink.setVisibility(View.GONE);
        }
        else if(order.getStatus()==3)
        {
            holder.frameStatusConfirmed.setVisibility(View.GONE);
            holder.frameStatusSetUpDrink.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.frameStatusConfirmed.setVisibility(View.GONE);
            holder.frameStatusSetUpDrink.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   orderShipping_shipper = new OrderShipping_Shipper();
               // orderShipping_shipper.addOnClick("" + position);
                Intent intent = new Intent(context, ActivityOrderDetail_Shipper.class);
                intent.putExtra("IDOrderDetail",order.getIdOrderDetail());
                intent.putExtra("IDOrder",order.getIdOrder());
                intent.putExtra("idCustomer",order.getIdCustomer());
                context.startActivity(intent);
               // Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDrinkInOrder;
        FrameLayout frameStatusConfirmed,frameStatusSetUpDrink;
        TextView txtMaOrder,txtNameDrinkInOrder,txtPriceInOrder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDrinkInOrder = (ImageView) itemView.findViewById(R.id.item_ordershipping_imageOder);
            frameStatusConfirmed = (FrameLayout) itemView.findViewById(R.id.item_ordershipping_frameStatusConfirmed);
            frameStatusSetUpDrink = (FrameLayout) itemView.findViewById(R.id.item_ordershipping_frameStatusSetUpDrink);
            txtMaOrder = (TextView) itemView.findViewById(R.id.item_ordershipping_txtIDOrder);
            txtPriceInOrder = (TextView) itemView.findViewById(R.id.item_ordershipping_txtPriceOrder);
        }
    }
}
