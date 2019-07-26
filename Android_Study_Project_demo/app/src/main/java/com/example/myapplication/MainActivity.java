package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermission();
    }

    private void requestPermission() {
        final RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA).subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now
                        Toast.makeText(this,"open camera",Toast.LENGTH_LONG).show();
                    } else {
                        // Oups permission denied
                        Toast.makeText(this,"no camera",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
