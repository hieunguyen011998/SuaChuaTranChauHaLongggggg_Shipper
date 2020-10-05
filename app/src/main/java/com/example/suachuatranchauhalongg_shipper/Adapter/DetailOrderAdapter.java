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
import com.example.suachuatranchauhalongg_shipper.R;

import java.util.List;

public class DetailOrderAdapter extends RecyclerView.Adapter<DetailOrderAdapter.ViewHolder> {
    List<Order> listOrder ;
    Context context;
    public DetailOrderAdapter(List<Order> listOrder,Context context)
    {
        this.listOrder = listOrder;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_orderdetail,parent,false);
        return new DetailOrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = listOrder.get(position);
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDrink;
        TextView txtPriceDrink,txtNameDrink,txtMountDrink;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDrink = (ImageView) itemView.findViewById(R.id.itemOrderDetail_imgOrder);
            txtNameDrink = (TextView) itemView.findViewById(R.id.itemOrderDetail_txtNameDrink);
            txtPriceDrink = (TextView) itemView.findViewById(R.id.itemOrderDetail_txtPriceDrink);
            txtMountDrink = (TextView) itemView.findViewById(R.id.itemOrderDetail_txtMountDrink);
        }
    }
}
