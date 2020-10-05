package com.example.suachuatranchauhalongg_shipper.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = listOrder.get(position);
        holder.txtMaOrder.setText(order.getMaOrder());
        holder.txtPriceInOrder.setText("Thanh toán : "+ order.getPrice());
        if(order.getStatus()==1)
        {
           // holder.frameStatus.setBackgroundColor(R.);
        }
        else if(order.getStatus()==2)
        {
           // holder.frameStatus.setBackgroundColor();
        }

    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDrinkInOrder;
        FrameLayout frameStatus;
        TextView txtMaOrder,txtNameDrinkInOrder,txtPriceInOrder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDrinkInOrder = (ImageView) itemView.findViewById(R.id.item_ordershipping_imageOder);
            frameStatus = (FrameLayout) itemView.findViewById(R.id.item_ordershipping_frameStatus);
            txtMaOrder = (TextView) itemView.findViewById(R.id.item_ordershipping_txtIDOrder);
            txtPriceInOrder = (TextView) itemView.findViewById(R.id.item_ordershipping_txtPriceOrder);
        }
    }
}
