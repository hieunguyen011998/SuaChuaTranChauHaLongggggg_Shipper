package com.example.suachuatranchauhalongg_shipper.Model.Register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ModelRegisterShipper {
    ModelResponeToPresenterListener callback;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    public  ModelRegisterShipper(ModelResponeToPresenterListener callback)
    {
        this.callback = callback;
    }
    public void handleRegister(String email,String pass, String rePass)
    {
        if(email.equals("") || pass.equals("") || rePass.equals(""))
        {
            callback.onRegisterEmprty();
        }
        else if (!email.equals("") && ! pass.equals(rePass))
            {
            callback.onRegisterPasswordDifficult();
        }
        else if(!email.equals("") && pass.equals(rePass))
        {
            auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        callback.onRegisterSuccess();
                    }
                    else if(!task.isSuccessful())
                    {
                        callback.onRegisterFaile();
                    }
                }
            });


        }


    }
}
