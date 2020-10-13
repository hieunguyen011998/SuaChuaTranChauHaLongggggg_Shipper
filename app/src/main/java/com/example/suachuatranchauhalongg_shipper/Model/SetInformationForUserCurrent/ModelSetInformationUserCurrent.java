package com.example.suachuatranchauhalongg_shipper.Model.SetInformationForUserCurrent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.suachuatranchauhalongg_shipper.Model.Login.ModelResponeToPresenterListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class ModelSetInformationUserCurrent {
    ModelResponeToPresenterListenerSetInformation callback;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    StorageReference mStorageRef;
    ProgressDialog progressDialog;
    FirebaseUser user;
    public ModelSetInformationUserCurrent(ModelResponeToPresenterListenerSetInformation callback)
    {
        this.callback = callback;
    }
    public void handleSetInformation(String email, String name, String phone, String getSexUserCurrent,
                                     String bienSoXe, String giayPhepLaiXe, String mauXe, String address, Bitmap bitmapFace, ImageView imgFace)
    {
        if(email.equals("") || name.equals("") || phone.equals("")
                || getSexUserCurrent==null || bienSoXe.equals("") ||
                giayPhepLaiXe.equals("") ||mauXe.equals("") || address.equals("") )
        {
            callback.onSetInformationUserRegisterEmprty();
        }
        else
        {
            setDataForUser(email,name,phone,getSexUserCurrent,bienSoXe,giayPhepLaiXe,mauXe,address,bitmapFace,imgFace);
        }
    }
    private void setDataForUser(String email,String name,String phone,
                                String getSexUserCurrent,String bienSoXe,String giayPhepLaiXe,
                                String mauXe,String address,Bitmap bitmapFace,ImageView imgFace){
        String userCurrentID;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        user = firebaseAuth.getCurrentUser();
        email = user.getEmail();
        userCurrentID = user.getUid();
        progressDialog.setMessage("Đang cập nhật.........");
        progressDialog.show();
        StorageReference mountainsRef = mStorageRef.child("User").child(user.getUid()+".png");

// Create a reference to 'images/mountains.jpg'
        StorageReference mountainImagesRef = mStorageRef.child("images/" +user.getUid()+ ".png\"");

// While the file names are the same, the references point to different files
        mountainsRef.getName().equals(mountainImagesRef.getName());    // true
        mountainsRef.getPath().equals(mountainImagesRef.getPath());    // false

        // Get the data from an ImageView as bytes
        imgFace.setDrawingCacheEnabled(true);
        imgFace.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) imgFace.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = mountainsRef.putBytes(data);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                // Toast.makeText(CapNhatDangKiActivity.this, "Lỗi :  "+exception.toString(), Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                String photoURL = downloadUrl.toString();
                Log.d("aa",downloadUrl.toString());
                mb = new member(name,testAccountType,email,phone,address,userCurrentID,photoURL,status,"user");
                databaseReference.child("DanhSachUser").child(user.getUid()).setValue(mb, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        if(databaseError == null)
                        {
//                            Toast.makeText(CapNhatDangKiActivity.this, "Cập nhật thành công !", Toast.LENGTH_SHORT).show();
//                            finish();
//                            Intent intent = new Intent(CapNhatDangKiActivity.this,TrangChuActivity.class);
//                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(intent);
                            //Toast.makeText(CapNhatDangKiActivity.this, "" + user.getEmail(), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //Toast.makeText(CapNhatDangKiActivity.this, "Cập nhật không thành công !", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
    }
}
