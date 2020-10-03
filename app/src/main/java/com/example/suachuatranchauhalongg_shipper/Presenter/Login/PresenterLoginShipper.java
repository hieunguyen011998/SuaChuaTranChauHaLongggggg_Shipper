package com.example.suachuatranchauhalongg_shipper.Presenter.Login;

import com.example.suachuatranchauhalongg_shipper.Model.Login.ModelLoginShipper;
import com.example.suachuatranchauhalongg_shipper.Model.Login.ModelResponeToPresenterListener;
import com.example.suachuatranchauhalongg_shipper.View.Login.ViewLoginListener;
//Thực thi interface ModelResponeToPresenterListener để nhận kết quả từ lớp Model
public class PresenterLoginShipper implements ModelResponeToPresenterListener {
    //Khai báo interface ViewLoginListener để báo lại kết quả nhận từ model cho lớp Activity
    private ViewLoginListener callback;
    private ModelLoginShipper modelLoginShipper = new ModelLoginShipper(this);;
    public PresenterLoginShipper(ViewLoginListener callback)
    {
        this.callback = callback;
    }
    //Lắng nghe được thông báo được gửi từ Activity
    public void receivedHandleLogin(String email, String password)
    {
        //Báo cho lớp Model biết shipper có click vào nút Login
        modelLoginShipper.handleLogin(email,password);
    }
    //Nhận kết quả xử lý logic từ lớp Model rồi đẩy kết quả vào interface ViewLoginListener
    @Override
    public void onLoginEmprty() {
        callback.onLoginEmprty();
    }

    @Override
    public void onLoginSuccess() {
        callback.onLoginSuccess();
    }

    @Override
    public void onLoginFaile() {
        callback.onLoginFaile();

    }
}
