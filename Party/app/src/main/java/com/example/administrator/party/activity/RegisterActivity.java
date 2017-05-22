package com.example.administrator.party.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.party.BaseActivity;
import com.example.administrator.party.R;
import com.example.administrator.party.http.WebServiceGet;
import com.example.administrator.party.http.WebServicePost;
import com.example.administrator.party.pages.FirstPage;

/**
 * Created by Administrator on 2017/5/17.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    //注册按钮
    private Button signbtn;
    EditText Name, Pass, rePass;
    String reginfo;
    //创建提交等待框
    private ProgressDialog regdialog;

    //返回主线程提交数据
    private static Handler reghandler = new Handler() ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        signbtn = (Button)findViewById(R.id.btnSign);
        Name = (EditText)findViewById(R.id.etSgAccount);
        Pass = (EditText)findViewById(R.id.etSgPassword);
        rePass = (EditText)findViewById(R.id.etSgRePassword);

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

                if (checkRegister() == true)
                {
                    //提示框
                    regdialog = new ProgressDialog(this);
                    regdialog.setMessage("正在上传,请稍后...");
                    regdialog.setCancelable(false);
                    regdialog.show();
                    //创建子线程，分别进行Get和Post传输
                    new Thread(new MyRegThread()).start();
                    break;
                }
                else
                {
                    break;
                }
        }
    }
    public class MyRegThread implements Runnable{
        @Override
        public void run()
        {
            System.out.println(Name.getText().toString());
            System.out.println(Pass.getText().toString());
            reginfo = WebServicePost.executeHttpPost(Name.getText().toString(),Pass.getText().toString());
            reghandler.post(new Runnable() {
                @Override
                public void run() {
                    //infotv.setText(info);
                    Toast.makeText(RegisterActivity.this,reginfo,Toast.LENGTH_SHORT).show();
                    System.out.print(reginfo);
                    regdialog.dismiss();
                }
            });
        }
    }

    public Boolean checkRegister()
    {
        if (Name.getText().toString().isEmpty())
        {
            Toast.makeText(RegisterActivity.this,"登录用户不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Pass.getText().toString().isEmpty())
        {
            Toast.makeText(RegisterActivity.this,"登录密码不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (rePass.getText().toString().isEmpty())
        {
            Toast.makeText(RegisterActivity.this,"登录密码不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!Pass.getText().toString().equals(rePass.getText().toString()))
        {
            System.out.println(Pass.getText().toString());
            System.out.println(rePass.getText().toString());
            Toast.makeText(RegisterActivity.this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
