package com.example.administrator.party.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.party.BaseActivity;
import com.example.administrator.party.R;

/**
 * Created by Administrator on 2017/5/17.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    //注册按钮
    private Button signbtn;
    EditText Name, Pass, rePass;

    //提交注册等待
    private ProgressDialog redialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        signbtn = (Button)findViewById(R.id.btnSign);

        signbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSign:
                Toast.makeText(getApplicationContext(),"点击了注册提交按钮",Toast.LENGTH_SHORT).show();
                //检测网络，无法检测wifi
                if(!checkNetwork())
                {
                    Toast toast = Toast.makeText(RegisterActivity.this,"网络连接",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    //Toast.makeText(getApplicationContext(),"网络正在连接",Toast.LENGTH_SHORT).show();
                    break;
                }

                //提示框
                redialog = new ProgressDialog(this);
                redialog.setMessage("正在上传,请稍后...");
                redialog.setCancelable(false);
                redialog.show();
                //创建子线程，分别进行Get和Post传输
                //new Thread(new LoginActivity.MyThread()).start();
                break;

        }
    }
}
