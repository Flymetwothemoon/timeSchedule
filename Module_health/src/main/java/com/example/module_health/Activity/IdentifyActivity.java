package com.example.module_health.Activity;

import static com.example.module_health.Indentify.AdvancedGeneral.advancedGeneral;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_health.Indentify.AdvancedGeneral;
import com.example.module_health.R;

public class IdentifyActivity extends AppCompatActivity {
private ImageView IdentifyPhoto;
private TextView IdentifyText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_identify);
        init();
        getNewPicture();
    }
    private void init(){
        IdentifyPhoto = findViewById(R.id.IdentifyPhoto);
        IdentifyText = findViewById(R.id.IdentifyText);
    }
    private void getNewPicture(){
        String[] projection = { MediaStore.Images.Media.DATA };
        String sortOrder = MediaStore.Images.Media.DATE_ADDED + " DESC";
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection,
                null,
                null,
                sortOrder);
        if (cursor != null && cursor.moveToFirst()) {
            String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            Log.d("path1",imagePath);
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            IdentifyPhoto.setImageBitmap(bitmap);
            advancedGeneral(imagePath,IdentifyText,this);
            // 在这里处理获取到的最新的一张照片
            cursor.close();
        }

    }
}