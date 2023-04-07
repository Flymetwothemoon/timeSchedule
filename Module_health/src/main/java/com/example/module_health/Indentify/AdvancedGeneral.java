package com.example.module_health.Indentify;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.baidu.aip.util.Base64Util;
import com.example.module_health.Indentify.Gson.ResultDTO;
import com.example.module_health.Indentify.Gson.usual;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URLEncoder;

public class AdvancedGeneral {
    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static void advancedGeneral(String file, TextView IdentifyText, Activity activity) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 请求url

                        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general";
                        String filePath = file;
                        byte[] imgData = new byte[0];
                        try {
                            imgData = FileUtil.readFileByBytes(filePath);
                            String imgStr = Base64Util.encode(imgData);
                            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
                            String param = "image=" + imgParam;

                            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
                            String accessToken = "24.4492b9fffd1271aa2e022ad739621720.2592000.1681729575.282335-31012302";

                            String result = HttpUtil.post(url, accessToken, param);

                            System.out.println(result);
                            Gson gson = new Gson();
                            usual usual = gson.fromJson(result, com.example.module_health.Indentify.Gson.usual.class);
                            String id = usual.result.get(0).keyword;
                            String root = usual.result.get(0).root;
                            ResultDTO resultDTO = gson.fromJson(result,ResultDTO.class);
                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    IdentifyText.setText(id+"\n"+root);
                                }
                            });
                            Log.d("path1",result);

                        } catch (IOException e) {
                            Log.d("path1","io");
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d("path1","ex");

                        }
            }
        });
        thread.start();

    }

    public static void main(String[] args) {

    }
}
