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
import com.example.suachuatranchauhalongg_shipper.R;
import com.example.suachuatranchauhalongg_shipper.View.Login.ViewLoginListener;
//Thực thi implement ViewLoginListener để nhận kết quả từ lớp presenter
public class Login_Shipper extends AppCompatActivity implements View.OnClickListener,ViewLoginListener {
    private EditText edtEmail,edtPass;
    private Button btnLogin;
    private TextView txtForgotPass,txtRedirectRegister;
    private PresenterLoginShipper presenterLoginShipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__shipper);
        initObject();
        addControls();
        addEvents();
    }
    public void initObject()
    {
        presenterLoginShipper = new PresenterLoginShipper(this);
    }
    public void addControls()
    {
        edtEmail = (EditText) findViewById(R.id.ActivityLoginShipper_edtEmail);
        edtPass = (EditText) findViewById(R.id.ActivityLoginShipper_edtPass);
        btnLogin = (Button) findViewById(R.id.ActivityLoginShipper_btnLogin);
        txtRedirectRegister = (TextView) findViewById(R.id.ActivityLoginShipper_txtRedirectRegister);
        txtForgotPass = (TextView) findViewById(R.id.ActivityLoginShipper_txtForgotPass);
    }
    public void addEvents()
    {
        //Khi shipper bấm Login
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onLoginEmprty() {
        Toast.makeText(this, "Hãy nhập email và mật khẩu", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        Intent intentRedirectActivityMainShipper = new Intent(Login_Shipper.this,ActivityMain_Shipper.class);
        startActivity(intentRedirectActivityMainShipper);

    }

    @Override
    public void onLoginFaile() {
        Toast.makeText(this, "Email và mật khẩu không đúng", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ActivityLoginShipper_btnLogin :
                String email = edtEmail.getText().toString();
                String password = edtPass.getText().toString();
                //Báo cho lớp Presenter biết là shipper đã tương tác click vào nút Login
                //Truyền tham số phone,password từ view cho lớp presenter
                presenterLoginShipper.receivedHandleLogin(email,password);
                break;
            case R.id.ActivityLoginShipper_txtRedirectRegister :
                break;
        }
    }
}
