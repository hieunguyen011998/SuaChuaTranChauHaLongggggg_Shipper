package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
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
    EditText edtEmail,edtPhone,edtName,edtAddress,edtBienSoXe,edtGiayPhepLaiXe,edtMauXe;
    ImageView imgFaceUserCurrent,imgFolderGetImage,imgCameraGetImage;
    RadioGroup rdgSex;
    RadioButton rdbMen,rdbGirl;
    Button btnUpdate;
    int REQUEST_CODE = 1;
    int READ_REQUEST_CODE = 2;
    String sexUserCurrent;
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
        edtBienSoXe = (EditText) findViewById(R.id.ActivitySetInformationForUserRegister_edtBienSoXe);
        edtGiayPhepLaiXe = (EditText) findViewById(R.id.ActivitySetInformationForUserRegister_edtGiayPhepLaiXe);
        edtMauXe = (EditText) findViewById(R.id.ActivitySetInformationForUserRegister_edtMauXe);

    }
    private void getImageFolder() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, READ_REQUEST_CODE);
    }
    private void getImageCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgFaceUserCurrent.setImageBitmap(bitmap);
        }
        if(requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK && data != null)
        {
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            imgFace.setImageBitmap(bitmap);
            Uri uri = null;
            uri = data.getData();
            Log.i("AAAA", "Uri: " + uri.toString());
            imgFaceUserCurrent.setImageURI(uri);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public String getSexUserCurrent()
    {
        //final String dataAccountType ;
        rdgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId)
                {
                    case R.id.ActivitySetInformationForUserRegister_rdbMen:
                        sexUserCurrent = rdbMen.getText().toString();
                        break;
                    case R.id.ActivitySetInformationForUserRegister_rdbGirl:
                        sexUserCurrent = rdbGirl.getText().toString();
                        break;

                }

            }
        });
        return sexUserCurrent;

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
                String bienSoXe = edtBienSoXe.getText().toString();
                String mauXe = edtMauXe.getText().toString();
                String giayPhepLaiXe = edtGiayPhepLaiXe.getText().toString();
                String getSexUserCurrent = getSexUserCurrent();
                ImageView imgFace = null;
                //Báo cho lớp Presenter biết là shipper đã tương tác click vào nút Login
                //Truyền tham số phone,password từ view cho lớp presenter
               presenterSetInformationForUserCurrent.receivedHandleSetInformation(email,name,phone,getSexUserCurrent,bienSoXe,giayPhepLaiXe,mauXe,address,bitmapFace,imgFace);
            }
        });
        imgCameraGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageCamera();
            }
        });
        imgFolderGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFolder();
            }
        });
    }

    @Override
    public void onSetInformationUserRegisterEmprty() {

    }

    @Override
    public void onSetInformationUserRegisterSuccess() {

    }

    @Override
    public void onSetInformationUserRegisterFaile() {

    }
}
