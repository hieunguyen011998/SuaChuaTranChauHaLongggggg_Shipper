package com.example.suachuatranchauhalongg_shipper.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.suachuatranchauhalongg_shipper.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VoucherAdapter2 {
    Calendar calen;
    String dateWrite;
    Button dialog_btnUpdate,dialog_btnCancel,dialog_btnHiden;
    EditText dialog_edtGiaTriApDung,dialog_edtPromotion;
    Dialog dialog;
    ImageView dialog_imgVoucher,dialog_imgFolder,dialog_imgCamera;
    Context context;
    private void addControls()
    {
        calen = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateWrite = "" + simpleDateFormat.format(calen.getTime());
        dialog_btnUpdate = (Button) dialog.findViewById(R.id.dialogUpdateVoucher_btnUpdateVoucher);
        dialog_btnCancel = (Button) dialog.findViewById(R.id.dialogUpdateVoucher_btnCancel);
        dialog_btnHiden = (Button) dialog.findViewById(R.id.dialogUpdateVoucher_btnHiden);
        dialog_edtGiaTriApDung = (EditText) dialog.findViewById(R.id.dialogUpdateVoucher_edtGiaTriApDung);
        dialog_edtPromotion = (EditText) dialog.findViewById(R.id.dialogUpdateVoucher_edtPromotion);
        dialog_imgVoucher = (ImageView) dialog.findViewById(R.id.dialogUpdateVoucher_imgVoucher);
        dialog_imgCamera = (ImageView) dialog.findViewById(R.id.dialogUpdateVoucher_imgCamera);
        dialog_imgFolder = (ImageView) dialog.findViewById(R.id.dialogUpdateVoucher_imgFolder);
    }
    private void addEvents()
    {

        dialog_btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.custome_dialog_add_voucher);
                addControls();
                final String giaTriApDung = dialog_edtGiaTriApDung.getText().toString().trim();
                final String promotion = dialog_edtPromotion.getText().toString().trim();
                if(giaTriApDung.equals("")||promotion.equals(""))
                {
                    Toast.makeText(context, "Bạn phải nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });
    }
}
