package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suachuatranchauhalongg_shipper.Presenter.Login.PresenterLoginShipper;
import com.example.suachuatranchauhalongg_shipper.Presenter.Register.PresenterRegisterShipper;
import com.example.suachuatranchauhalongg_shipper.R;
import com.example.suachuatranchauhalongg_shipper.View.Login.ViewLoginListener;
import com.example.suachuatranchauhalongg_shipper.View.Register.ViewRegisterListener;

public class Register_Shipper extends AppCompatActivity implements View.OnClickListener, ViewRegisterListener {
    private EditText edtEmail,edtPass,edtRePass;
    private Button btnRegister;
    private TextView txtRedirectLogin;
    PresenterLoginShipper presenterLoginShipper;
    PresenterRegisterShipper presenterRegisterShipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__shipper);
        initObject();
        addControls();
        addEvents();
    }
    public void initObject()
    {
        presenterRegisterShipper = new PresenterRegisterShipper(this);

    }
    public void addControls()
    {
        edtEmail = (EditText) findViewById(R.id.ActivityRegisterShipper_edtEmail);
        edtPass = (EditText) findViewById(R.id.ActivityRegisterShipper_edtPass);
        edtRePass = (EditText) findViewById(R.id.ActivityRegisterShipper_edtRePass);
        btnRegister = (Button) findViewById(R.id.ActivityRegisterShipper_btnRegister);
        txtRedirectLogin = (TextView) findViewById(R.id.ActivityRegisterShipper_txtRedirectLogin);
    }
    public void addEvents()
    {
        btnRegister.setOnClickListener(this);
        txtRedirectLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ActivityRegisterShipper_btnRegister :
                String email = edtEmail.getText().toString().trim();
                String pass  = edtPass.getText().toString().trim();
                String rePass = edtRePass.getText().toString().trim();
                presenterRegisterShipper.receivedHandleRegister(email,pass,rePass);
               // Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ActivityRegisterShipper_txtRedirectLogin :
               // Toast.makeText(this, "Redirect Login", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onRegisterEmprty() {
        Toast.makeText(this, "Hãy nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess() {
        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Register_Shipper.this,ActivityMain_Shipper.class);
        startActivity(intent);
    }

    @Override
    public void onRegisterFaile() {
        Toast.makeText(this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterPasswordDifficult() {
        Toast.makeText(this, "Nhập lại mật khẩu phải giống nhau", Toast.LENGTH_SHORT).show();
    }
}
