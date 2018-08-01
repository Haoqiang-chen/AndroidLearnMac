package com.example.chenhaoqiang.test.camera;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.chenhaoqiang.test.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    private Button btnPhoto, btnVideo;
    private CameraEngine cameraEngine;
    private CameraPreview cameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*按钮的时间监听*/
        btnPhoto = findViewById(R.id.button_photo);
        btnVideo = findViewById(R.id.botton_video);
        btnPhoto.setOnClickListener(takePtoto);
        /*获取相机的实例、创建预览View并将此View加入到当前Activity中*/
        cameraEngine = new CameraEngine();
        Log.e("camera", "getInstance");
        cameraPreview = new CameraPreview(this, cameraEngine.getCameraInstance());
        FrameLayout preview = findViewById(R.id.camera_preview);
        preview.addView(cameraPreview);
        //requestAllPremission(); //在这里申请权限导致获取不到camera的实例
        Log.e("SecondActivity", "create");


    }

    /*申请权限*/
    public void requestAllPremission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }
    /*拍照事件监听*/
    private View.OnClickListener takePtoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cameraEngine.myTakePicture(null, null, pictureCallback);
        }
    };

    /*相机拍照方法中触发的回调*/
    private Camera.PictureCallback pictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            File pictureFile = SaveFile.getOutputMediaFile(SaveFile.MEDIA_TYPE_IMAGE, SecondActivity.this);
            if (pictureFile == null){
                Log.e("pictureFile", "Error creating media file, check storage permissions: ");
                return;
            }

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                Log.e("PictureFile", "File not found: " + e.getMessage());
            } catch (IOException e) {
                Log.e("PictureFile", "Error accessing file: " + e.getMessage());
            }
        }
    };

    @Override
    protected void onPause(){
        super.onPause();
        cameraEngine.releaseCamera();
    }

}
