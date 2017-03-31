package com.example.administrator.party;

/**
 * Created by Administrator on 2017/3/31.
 * 用户类
 * 输入用户名和密码 ，从本地文件userinfo.json中读取users。
 */

import org.json.JSONException;
import org.json.JSONObject;

import android.hardware.Sensor;
import android.util.Log;

public class User {

    private String mID;
    private String mPwd;

    private static final String masterPassword = "FORYOU"; //AES加密算法的种子
    private static final String JSON_ID = "user_id";
    private static final String JSON_PWD = "user_pwd";
    private static final String TAG = "User";

    public User(String id, String pwd)
    {
        this.mID = id;
        this.mPwd = pwd;
    }
}
