package com.example.myapplication.activity;

import android.Manifest;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.jakewharton.rxbinding2.view.RxView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
/*
 * @Author: Luke
 * @Date: 2019-07-27 16:06
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class RxPermissionDemoActivity extends AppCompatActivity {
    private static final String TAG = "RxPermissionsSample";

    private Camera camera;
    private SurfaceView surfaceView;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.setLogging(true);

        setContentView(R.layout.act_main);
        surfaceView = findViewById(R.id.surfaceView);

        disposable = RxView.clicks(findViewById(R.id.enableCamera))
                // Ask for permissions when button is clicked
                .compose(rxPermissions.ensureEach(Manifest.permission.CAMERA))
                .subscribe(permission -> {
                            Log.i(TAG, "Permission result " + permission);
                            if (permission.granted) {
                                // 用户已经同意了该权限
                                releaseCamera();
                                camera = Camera.open(0);
                                try {
                                    camera.setPreviewDisplay(surfaceView.getHolder());
                                    camera.startPreview();
                                } catch (IOException e) {
                                    Log.e(TAG, "Error while trying to display the camera preview", e);
                                }
                            } else if (permission.shouldShowRequestPermissionRationale) {
                                // 用户拒绝了该权限，并且没有选中【不在询问】，那么下次启动的时候仍旧询问
                                Toast.makeText(RxPermissionDemoActivity.this,
                                        "Denied permission without ask never again",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                // 用户拒绝了该权限，并且选中了【不再询问】
                                Toast.makeText(RxPermissionDemoActivity.this,
                                        "Permission denied, can't enable the camera",
                                        Toast.LENGTH_SHORT).show();
                            }
                        },
                        t -> Log.e(TAG, "onError", t),
                        () -> Log.i(TAG, "OnComplete"));
    }

    @Override
    protected void onDestroy() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseCamera();
    }

    private void releaseCamera() {
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }

}
