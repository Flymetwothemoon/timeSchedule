package com.example.module_health.fragment;
import static android.os.Environment.getExternalStoragePublicDirectory;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.module_health.R;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button mButton;
    private PreviewView mPreviewView;
    private View mView;
    //开个线程池
    private Executor executor = Executors.newSingleThreadExecutor();
    public PhotoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhotoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotoFragment newInstance(String param1, String param2) {
        PhotoFragment fragment = new PhotoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(mView==null){
            mView = inflater.inflate(R.layout.fragment_photo, container, false);
        }
        init();
        return mView;
    }
    private void init() {
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
        }
        startCamera();

    }
    public void startCamera(){
        mButton = mView.findViewById(R.id.button_1);
        mPreviewView = mView.findViewById(R.id.previewView);
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture
                = ProcessCameraProvider.getInstance(getContext());
        cameraProviderFuture.addListener(() -> {
            try {
                // 获取CameraProvider
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();

                // 选择相机
                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
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
                cameraProvider.bindToLifecycle((LifecycleOwner)this, cameraSelector, preview, imageCapture);

                // 设置拍照按钮的点击事件
                 mButton.setOnClickListener(view -> {
                    // 创建文件以保存图像
                    File file = new File(getContext().getExternalMediaDirs()[0], "image.jpg");
                    //File file = new File(Environment.DIRECTORY_PICTURES, "image.jpg");
                    // 创建图像保存选项
                    ImageCapture.OutputFileOptions outputFileOptions =
                            new ImageCapture.OutputFileOptions.Builder(file).build();

                    // 拍照并保存图像
                    imageCapture.takePicture(outputFileOptions, executor, new ImageCapture.OnImageSavedCallback() {
                        @Override
                        public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                            getActivity().
                            runOnUiThread(() -> Toast.makeText(getContext(), "Image saved successfully"+getContext().getExternalMediaDirs()[0], Toast.LENGTH_SHORT).show());
                            Log.d("picture",String.valueOf(getContext().getExternalMediaDirs()[0]));
                        }

                        @Override
                        public void onError(@NonNull ImageCaptureException exception) {
                            getActivity().
                            runOnUiThread(() -> Toast.makeText(getContext(), "Error saving image", Toast.LENGTH_SHORT).show());
                        }
                    });
                });

            } catch (ExecutionException | InterruptedException e) {
                // 处理异常
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(getContext()));
    }


    }

