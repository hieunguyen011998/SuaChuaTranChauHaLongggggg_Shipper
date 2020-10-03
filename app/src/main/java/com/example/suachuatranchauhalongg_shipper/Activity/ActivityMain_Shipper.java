package com.example.suachuatranchauhalongg_shipper.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suachuatranchauhalongg_shipper.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityMain_Shipper extends AppCompatActivity {
    TextView txtNameUserCurrent;
    ImageView imageNotification;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__shipper);
        setNameUserCurrent();
        addControls();
        initDataFormAdmin();
        addEvents();
    }
    public void setNameUserCurrent()
    {
        firebaseUser = firebaseAuth.getInstance().getCurrentUser();

    }
    public void addControls()
    {
          toolbar = (Toolbar) findViewById(R.id.ActivityMainShipper_toolbar);
          setSupportActionBar(toolbar);
          txtNameUserCurrent = (TextView) findViewById(R.id.ActivityMainShipper_txtNameUserCurrent);
          imageNotification = (ImageView) findViewById(R.id.ActivityMainShipper_imgNotification);
          drawerLayout = (DrawerLayout) findViewById(R.id.ActivityMainShipper_drawerLayout);
          navigationView = (NavigationView) findViewById(R.id.ActivityMainShipper_navigationView);
    }
    public void addEvents()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                Intent intent = null;
                int check =0;
                //  Toast.makeText(TrangChuActivity.this, "" + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                final int menuItemID = menuItem.getItemId();
                switch (menuItemID)
                {
                    case R.id.itemNavigation_informationShipper :
                        check = 1;
                        break;
                    case R.id.itemNavigation_orderShipCurrent:
                        check = 2;
                        break;
                    case R.id.itemNavigation_orderShipped :
                        check = 3;
                        break;
                    case R.id.itemNavigation_logout:
                        check = 4;
                        break;
                }
                if(check == 1)
                {
                    intent= new Intent(ActivityMain_Shipper.this,ActivityInformation_Shipper.class);
                    intent.putExtra("key_itemMenu",check);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_intent_trai_sang_phai,R.anim.anim_intent_exit);
                }
                else if(check == 2)
                {
                    intent= new Intent(ActivityMain_Shipper.this,OrderShipping_Shipper.class);
                    intent.putExtra("key_itemMenu",check);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_intent_trai_sang_phai,R.anim.anim_intent_exit);
                }
                else if(check == 3)
                {
                    intent= new Intent(ActivityMain_Shipper.this,OrderShipped_Shipper.class);
                    intent.putExtra("key_itemMenu",check);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_intent_trai_sang_phai,R.anim.anim_intent_exit);
                }
                else if(check == 4)
                {
                    DialogLogout();
                   // overridePendingTransition(R.anim.anim_intent_trai_sang_phai,R.anim.anim_intent_exit);
                }
                return true;
            }
        });
    }
    public void DialogLogout()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        alert.setIcon(R.drawable.ic_report_black_24dp);
        alert.setMessage("Bạn có chắc muốn đăng xuất không ? ");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 Intent intent = new Intent(ActivityMain_Shipper.this,Login_Shipper.class);
                 startActivity(intent);
            }
        });
        alert.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog a = alert.create();
        a.show();
    }
    private void initDataFormAdmin() {
          actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
          drawerLayout.addDrawerListener(actionBarDrawerToggle);
          actionBarDrawerToggle.syncState();
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
