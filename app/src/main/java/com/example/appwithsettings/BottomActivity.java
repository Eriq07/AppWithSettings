package com.example.appwithsettings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "BottomActivity";

    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);


        mBottomNavigationView = findViewById(R.id.bottomNavigationView);


        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mBottomNavigationView.setSelectedItemId(R.id.store);

    }

    Account mAccount = new Account();
    Favourite mFavourite = new Favourite();
    Store mStore = new Store();
    Cart mCart = new Cart();
    Camera mCamera = new Camera();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.i(TAG, "onNavigationItemSelected");

        switch (item.getItemId()){
            case R.id.account:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mAccount).commit();
                return true;
            case R.id.favourite:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mFavourite).commit();
                return true;
            case R.id.store:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mStore).commit();
                return true;
            case R.id.cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mCart).commit();
                return true;
            case R.id.camera:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mCamera).commit();
                return true;

        }

        return false;
    }
}