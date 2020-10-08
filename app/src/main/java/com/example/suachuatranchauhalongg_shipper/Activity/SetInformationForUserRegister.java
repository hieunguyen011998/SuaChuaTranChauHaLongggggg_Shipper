package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.suachuatranchauhalongg_shipper.Presenter.Login.PresenterLoginShipper;
import com.example.suachuatranchauhalongg_shipper.Presenter.SetInformationForUserCurrent.PresenterSetInformationForUserCurrent;
import com.example.suachuatranchauhalongg_shipper.R;
import com.example.suachuatranchauhalongg_shipper.View.SetInformationForUserCurrent.ViewSetInformationListener;

public class SetInformationForUserRegister extends AppCompatActivity implements ViewSetInformationListener {
    EditText edtEmail,edtPhone,edtName,edtAddress;
    ImageView imgFaceUserCurrent,imgFolderGetImage,imgCameraGetImage;
    RadioGroup rdgSex;
    RadioButton rdbMen,rdbGirl;
    Button btnUpdate;
    private PresenterSetInformationForUserCurrent presenterSetInformationForUserCurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_information_for_user_register);
        initData();
        addControls();
        addEvents();
    }
    public void initData()
    {
        presenterSetInformationForUserCurrent = new PresenterSetInformationForUserCurrent(this);
    }
    public void addControls()
    {
        edtEmail = (EditText) findViewById(R.id.ActivitySetInformationForUserRegister_edtEmail);
        edtPhone = (EditText) findViewById(R.id.ActivitySetInformationForUserRegister_edtPhone);
        edtName = (EditText) findViewById(R.id.ActivitySetInformationForUserRegister_edtName);
        edtAddress = (EditText) findViewById(R.id.ActivitySetInformationForUserRegister_edtAddress);
        imgFaceUserCurrent = (ImageView) findViewById(R.id.ActivitySetInformationForUserRegister_imgFaceUserCurrent);
        imgFolderGetImage = (ImageView) findViewById(R.id.ActivitySetInformationForUserRegister_imgFolder);
        imgCameraGetImage = (ImageView) findViewById(R.id.ActivitySetInformationForUserRegister_imgCamera);
        rdgSex = (RadioGroup) findViewById(R.id.ActivitySetInformationForUserRegister_radioGroupSex);
        rdbMen = (RadioButton) findViewById(R.id.ActivitySetInformationForUserRegister_rdbMen);
        rdbGirl = (RadioButton) findViewById(R.id.ActivitySetInformationForUserRegister_rdbGirl);
        btnUpdate = (Button) findViewById(R.id.ActivitySetInformationForUserRegister_btnUpdate);

    }
    public void addEvents()
    {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String name = edtName.getText().toString();
                String phone = edtName.getText().toString();
                String address = edtName.getText().toString();
                Bitmap bitmapFace = ((BitmapDrawable) imgFaceUserCurrent.getDrawable()).getBitmap();
                //Báo cho lớp Presenter biết là shipper đã tương tác click vào nút Login
                //Truyền tham số phone,password từ view cho lớp presenter
               //presenterSetInformationForUserCurrent.receivedHandleSetInformation(email,name,phone,address,bitmapFace.toString());
            }
        });
    }

    @Override
    public void onLoginEmprty() {

    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFaile() {

    }
}
