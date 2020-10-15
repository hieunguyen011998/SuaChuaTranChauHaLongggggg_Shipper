package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suachuatranchauhalongg_shipper.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityInformation_Shipper extends AppCompatActivity {
    CircleImageView imgFaceShipperCurrent;
    EditText edtPhone,edtAddress,edtNameCar,edtColorCar,edtLicensePlateCar,edtDrivingLicenseCar;
    TextView txtName,txtTottalBillShipped;
    RadioGroup rdgSex;
    RadioButton rdbGirl,rdbMen;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information__shipper);
        addControls();
        addEvents();

    }

    private void addEvents() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityInformation_Shipper.this, "" + getSexShipper(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    String getSex = "";
    public String getSexShipper()
    {
        //final String dataAccountType ;
        rdgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId)
                {
                    case R.id.ActivityInformationShipper_rdbGirl:
                        getSex = rdbGirl.getText().toString();
                        break;
                    case R.id.ActivityInformationShipper_rdbMen:
                        getSex = rdbMen.getText().toString();
                        break;
                }

            }
        });
        return getSex;

    }
    private void addControls() {
        imgFaceShipperCurrent = (CircleImageView) findViewById(R.id.ActivityInformationShipper_imgFace);
        txtName = (TextView) findViewById(R.id.ActivityInformationShipper_txtName);
        txtTottalBillShipped = (TextView) findViewById(R.id.ActivityInformationShipper_txtTottalBillShipped);
        edtPhone = (EditText) findViewById(R.id.ActivityInformationShipper_edtPhone);
        edtAddress = (EditText) findViewById(R.id.ActivityInformationShipper_edtAddress);
        edtNameCar = (EditText) findViewById(R.id.ActivityInformationShipper_edtTenXe);
        edtColorCar = (EditText) findViewById(R.id.ActivityInformationShipper_edtMauXe);
        edtLicensePlateCar = (EditText) findViewById(R.id.ActivityInformationShipper_edtBienSoXe);
        edtDrivingLicenseCar = (EditText) findViewById(R.id.ActivityInformationShipper_edtGiayPhepLaiXe);
        rdgSex = (RadioGroup) findViewById(R.id.ActivityInformationShipper_rdgSex);
        rdbGirl = (RadioButton) findViewById(R.id.ActivityInformationShipper_rdbGirl);
        rdbMen = (RadioButton) findViewById(R.id.ActivityInformationShipper_rdbMen);
        btnUpdate = (Button) findViewById(R.id.ActivityInformationShipper_btnUpdate);
    }
}
