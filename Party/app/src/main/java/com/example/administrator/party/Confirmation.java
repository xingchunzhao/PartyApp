package com.example.administrator.party;

import android.view.View;

import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Administrator on 2017/3/31.
 *  登录验证
 *  @param name 姓名
 *  @param password 密码
 *  @param result 验证结果
 */

public class Confirmation{

    private boolean result = false;
    private String login_username = null;
    private String login_password = null;

   //发送请求
    public static boolean SendGETRequset(String path, Map<String,String>csvt, String ecoding) throws Exception
    {
        StringBuilder url = new StringBuilder(path);
        url.append('?');
        for(Map.Entry<String, String> map : csvt.entrySet()){
            url.append(map.getKey()).append("=");
            url.append(URLEncoder.encode(map.getValue(), ecoding));
            url.append("&");
        }
        url.deleteCharAt(url.length()-1);
        System.out.println(url);
        HttpsURLConnection conn = (HttpsURLConnection)new URL(url.toString()).openConnection();
        conn.setConnectTimeout(100000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode() == 200)
        {
            return true;
        }
        return false;
    }

    //返回结果
    public static boolean saveResult(String login_username, String login_password)
    {
        String path = "http://<span style="color: #ff0000;"><strong>127.0.0.1</strong></span>:8080/Register/ManageServlet";
        Map<String,String> csvt = new HashMap<String, String>();
        csvt.put("name",login_username);
        csvt.put("password",login_password);
        try {
            return SendGETRequset(path,csvt,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}


