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

public class LoveDrinkAdapter extends RecyclerView.Adapter<LoveDrinkAdapter.ViewHolder> {
    private List<Drink> listDrink;
    private Context context;
    public LoveDrinkAdapter(List<Drink> listDrink,Context context ) {
        this.listDrink = listDrink;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lovedrink,parent,false);
        return new LoveDrinkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listDrink.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDrink,imgDelete;
        TextView txtNameDrink,txtPriceDrink;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDelete = (ImageView) itemView.findViewById(R.id.itemLoveDrink_imgDelete);
            imgDrink = (ImageView) itemView.findViewById(R.id.itemLoveDrink_imgDrink);
            txtNameDrink = (TextView) itemView.findViewById(R.id.itemLoveDrink_txtNameDrink);
            txtPriceDrink = (TextView) itemView.findViewById(R.id.itemLoveDrink_txtPriceDink);

        }
    }
}
