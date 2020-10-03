package com.example.suachuatranchauhalongg_shipper.Presenter.Register;

import com.example.suachuatranchauhalongg_shipper.Model.Login.ModelLoginShipper;
import com.example.suachuatranchauhalongg_shipper.Model.Register.ModelRegisterShipper;
import com.example.suachuatranchauhalongg_shipper.Model.Register.ModelResponeToPresenterListener;
import com.example.suachuatranchauhalongg_shipper.View.Register.ViewRegisterListener;

public class PresenterRegisterShipper implements ModelResponeToPresenterListener {
    private ViewRegisterListener callback;
    private ModelRegisterShipper modelRegisterShipper = new ModelRegisterShipper(this);
    public PresenterRegisterShipper(ViewRegisterListener callback)
    {
        this.callback = callback;
    }
    public void receivedHandleRegister(String email,String pass, String rePass)
    {
        modelRegisterShipper.handleRegister(email,pass,rePass);
    }

    @Override
    public void onRegisterEmprty() {
        callback.onRegisterEmprty();
    }

    @Override
    public void onRegisterSuccess() {
        callback.onRegisterSuccess();
    }

    @Override
    public void onRegisterFaile() {
        callback.onRegisterFaile();
    }

    @Override
    public void onRegisterPasswordDifficult() {
        callback.onRegisterPasswordDifficult();
    }
}
