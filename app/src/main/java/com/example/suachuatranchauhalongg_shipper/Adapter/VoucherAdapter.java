package com.example.suachuatranchauhalongg_shipper.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.suachuatranchauhalongg_shipper.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VoucherAdapter {
    Calendar calen;
    String dateWrite;
    Button btnAdd,btnCancel;
    EditText edtGiaTriApDung,edtPromotion;
    Dialog dialog;
    ImageView imgVoucher,imgFolder,imgCamera;
    Context context;
    private void addControls()
    {
        calen = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateWrite = "" + simpleDateFormat.format(calen.getTime());
        btnAdd = (Button) dialog.findViewById(R.id.dialogAddVoucher_btnAddVoucher);
        btnCancel = (Button) dialog.findViewById(R.id.dialogAddVoucher_btnCancel);
        edtGiaTriApDung = (EditText) dialog.findViewById(R.id.dialogAddVoucher_edtGiaTriApDung);
        edtPromotion = (EditText) dialog.findViewById(R.id.dialogAddVoucher_edtPromotion);
        imgVoucher = (ImageView) dialog.findViewById(R.id.dialogAddVoucher_imgVoucher);
        imgCamera = (ImageView) dialog.findViewById(R.id.dialogAddVoucher_imgCamera);
        imgFolder = (ImageView) dialog.findViewById(R.id.dialogAddVoucher_imgFolder);
    }
    private void addEvents()
    {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.custome_dialog_add_voucher);
                addControls();
            }
        });
    }
}
