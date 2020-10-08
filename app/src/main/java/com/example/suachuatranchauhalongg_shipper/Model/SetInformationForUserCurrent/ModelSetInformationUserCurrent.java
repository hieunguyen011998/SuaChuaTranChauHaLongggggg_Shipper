package com.example.suachuatranchauhalongg_shipper.Model.SetInformationForUserCurrent;

import android.graphics.Bitmap;

import com.example.suachuatranchauhalongg_shipper.Model.Login.ModelResponeToPresenterListener;

public class ModelSetInformationUserCurrent {
    ModelResponeToPresenterListenerSetInformation callback;
    public ModelSetInformationUserCurrent(ModelResponeToPresenterListenerSetInformation callback)
    {
        this.callback = callback;
    }
    public void handleSetInformation(String email, String name, String phone, String address, String imgFace, Bitmap bitmap)
    {

    }
}
