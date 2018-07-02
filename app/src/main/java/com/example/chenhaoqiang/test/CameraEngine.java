package com.example.chenhaoqiang.test;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;


public class CameraEngine {
    private Camera camera;



    /** 检查设备是否有摄像头 */
    public boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public Camera getCameraInstance(){
        camera = null;
        try {
            camera = Camera.open(); // attempt to get a Camera instance
            Log.e("camera", "open");
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return camera; // returns null if camera is unavailable
    }

    public void myTakePicture(Camera.ShutterCallback shutter, Camera.PictureCallback raw, Camera.PictureCallback jpeg){
        if (camera == null){
            Log.e("cameraState", "null");
        }
        camera.takePicture(shutter, raw, jpeg);
        camera.startPreview();
    }

    public  void releaseCamera(){
        if (camera != null){
            camera.release();        // release the camera for other applications
            camera = null;
        }
    }
}
