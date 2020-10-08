package com.example.suachuatranchauhalongg_shipper.Presenter.SetInformationForUserCurrent;

import android.graphics.Bitmap;

import com.example.suachuatranchauhalongg_shipper.Model.Login.ModelLoginShipper;
import com.example.suachuatranchauhalongg_shipper.Model.Login.ModelResponeToPresenterListener;
import com.example.suachuatranchauhalongg_shipper.Model.SetInformationForUserCurrent.ModelResponeToPresenterListenerSetInformation;
import com.example.suachuatranchauhalongg_shipper.Model.SetInformationForUserCurrent.ModelSetInformationUserCurrent;
import com.example.suachuatranchauhalongg_shipper.View.Login.ViewLoginListener;
import com.example.suachuatranchauhalongg_shipper.View.SetInformationForUserCurrent.ViewSetInformationListener;

public class PresenterSetInformationForUserCurrent implements ModelResponeToPresenterListenerSetInformation {
    //Khai báo interface ViewLoginListener để báo lại kết quả nhận từ model cho lớp Activity
    private ViewSetInformationListener callback;
    private ModelSetInformationUserCurrent modelSetInformationUserCurrent = new ModelSetInformationUserCurrent(this);;
    public PresenterSetInformationForUserCurrent(ViewSetInformationListener callback)
    {
        this.callback = callback;
    }
    //Lắng nghe được thông báo được gửi từ Activity
    public void receivedHandleSetInformation(String email, String name, String phone, String address, String imgFace, Bitmap bitmap)
    {
        //Báo cho lớp Model biết shipper có click vào nút Login
      //  modelSetInformationUserCurrent.handleSetInformation(email,name,phone,address,bitmap);
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
    //Nhận kết quả xử lý logic từ lớp Model rồi đẩy kết quả vào interface ViewLoginListener

}
