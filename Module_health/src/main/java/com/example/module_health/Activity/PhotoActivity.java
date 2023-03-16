package com.example.module_health.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.core.VideoCapture;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.module_health.R;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class PhotoActivity extends AppCompatActivity {
    private Button mButton;
    private PreviewView mPreviewView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_photo);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 如果没有这两个权限，请请求用户授权
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        } else {
            startCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==2){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // 用户已授予相机和存储权限
                startCamera();
            } else {
                // 用户拒绝授予相机和存储权限
                Toast.makeText(this,"没有授予权限",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startCamera() {
        mButton = findViewById(R.id.button_1);
        mPreviewView = findViewById(R.id.previewView);

        //是用来获取 ProcessCameraProvider 实例的方法，
        // ProcessCameraProvider 是一个用于管理相机的类，可以使用它来创建 Camera 对象，
        // 实现预览、拍照、录制视频等功能。
        //所以cameraProviderFuture是一个集合类型的
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture
                = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(() -> {
            try {
                //ProcessCameraProvider 是用于创建和管理 Camera 实例的核心类。
                // 它提供了一种方便的方式来管理相机生命周期并处理相关操作
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();

                // 选择后置相机
                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                        .build();

                //选择前置相机
                CameraSelector cameraSelector1 = new CameraSelector.Builder().
                        requireLensFacing(CameraSelector.LENS_FACING_FRONT)
                        .build();

                // 配置预览
                Preview preview = new Preview.Builder()
                        .setTargetAspectRatio(AspectRatio.RATIO_4_3).
//                        setTargetRotation(mPreviewView.getDisplay().getRotation())
        build();
                // 绑定预览到PreviewView
                preview.setSurfaceProvider(mPreviewView.getSurfaceProvider());

                // 配置图像捕获
                ImageCapture imageCapture = new ImageCapture.Builder()
                        .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                        .setTargetAspectRatio(AspectRatio.RATIO_16_9)
                        // setTargetRotation(mPreviewView.getDisplay().getRotation()),弄方向的
                        .build();


                // 绑定用例到相机
                cameraProvider.bindToLifecycle((LifecycleOwner) this, cameraSelector, preview, imageCapture);

                // 设置拍照按钮的点击事件
                mButton.setOnClickListener(view -> {
                    // 创建文件以保存图像
                    File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    // 创建一个子目录
                    File outputDirectory = new File(storageDir, "MyApp");
                    // 如果目录不存在，则创建它
                    if (!outputDirectory.exists()) {
                        outputDirectory.mkdirs();
                    }
                    File photoFile = new File(outputDirectory, "photo.jpg");

// 创建一个保存照片的输出配置
                    ImageCapture.OutputFileOptions outputOptions = new ImageCapture.OutputFileOptions.Builder(photoFile).build();

// 拍照
                    imageCapture.takePicture(outputOptions, ContextCompat.getMainExecutor(this), new ImageCapture.OnImageSavedCallback() {
                        @Override
                        public void onImageSaved(@NonNull ImageCapture.OutputFileResults output) {
                            // 照片已保存到本地相册
                            Uri savedUri = output.getSavedUri() != null ? output.getSavedUri() : Uri.fromFile(photoFile);
                            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                            mediaScanIntent.setData(savedUri);
                            sendBroadcast(mediaScanIntent);
                            Toast.makeText(PhotoActivity.this, "拍照成功", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(@NonNull ImageCaptureException exception) {
                            Log.d("service4545", String.valueOf(exception));
                        }


                    });
                });

            } catch (ExecutionException | InterruptedException e) {
                // 处理异常
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(this));
    }



}