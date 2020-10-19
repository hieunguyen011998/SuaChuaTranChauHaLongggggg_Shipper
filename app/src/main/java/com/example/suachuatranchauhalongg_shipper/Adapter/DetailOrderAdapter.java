package com.example.suachuatranchauhalongg_shipper.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suachuatranchauhalongg_shipper.Object.OrderDetail;
import com.example.suachuatranchauhalongg_shipper.R;
import com.example.suachuatranchauhalongg_shipper.Object.ListenerIDOrder;

import java.util.List;

public class DetailOrderAdapter extends RecyclerView.Adapter<DetailOrderAdapter.ViewHolder>  {
    List<OrderDetail> listOrderDetail ;
    Context context;
    private ListenerIDOrder send ;
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
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        send = new ListenerIDOrder();
        OrderDetail orderDetail = listOrderDetail.get(position);
      //  holder.imgDrink.setImageResource(orderDetail.getImgUriDrink());
        holder.txtNameDrink.setText("Mã đơn hàng : "+ send.getIDOrder());
        //holder.txtMountDrink.setText("Số lượng : "+ orderDetail.getMount());
      //  int totalPrice = orderDetail.getPrice()* orderDetail.getMount();
       // holder.txtTotalPriceDrink.setText("Giá : " + totalPrice);

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
