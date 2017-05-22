package com.example.administrator.party.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.net.ConnectivityManagerCompat;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.party.BaseActivity;
import com.example.administrator.party.R;
import com.example.administrator.party.http.WebServiceGet;
import com.example.administrator.party.pages.FirstPage;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;



/**
 * Created by Administrator on 2017/5/17.
 * 实现用户的登录功能
 * 第一个是检测网络状态，只能检测流量，无法检测wifi；
 * 第二个是在子线程中，不能更改主线程的页面值，这里用了handle解决。
 * 第三个是这里有get/post两种http请求方式，两个实现类，。
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    //登录按钮
    private Button logbtn;
    //调试文本,注册文本
   private TextView textRePass,textRegister;//, regtv;
    //显示用户名和密码
    EditText username,password;
    //创建等待框
    private ProgressDialog dialog;
    //返回数据
    private String info;
    //返回主线程更新数据
    private static Handler handler = new Handler() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText) findViewById(R.id.login_user);
        password = (EditText)findViewById(R.id.login_password);
        logbtn = (Button)findViewById(R.id.btn_Login);
        textRegister = (TextView)findViewById(R.id.tReg);
        textRePass = (TextView)findViewById(R.id.tRePASS);

        //设置监听
        logbtn.setOnClickListener(this);
        textRegister.setOnClickListener(this);
        textRePass.setOnClickListener(this);
    }

    /*检测网络*/
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_Login:
                Toast.makeText(getApplicationContext(),"点击了登录按钮",Toast.LENGTH_SHORT).show();
                //检测网络，无法检测wifi
                if(!checkNetwork())
                {
                    Toast toast = Toast.makeText(LoginActivity.this,"网络连接",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    //Toast.makeText(getApplicationContext(),"网络正在连接",Toast.LENGTH_SHORT).show();
                    break;
                }

                if (checkUser() == true)
                {
                    //提示框
                    dialog = new ProgressDialog(this);
                    dialog.setTitle("提示框");
                    dialog.setMessage("正在登录,请稍后...");
                    dialog.setCancelable(false);
                    dialog.show();
                    //创建子线程，分别进行Get和Post传输
                    new Thread(new MyThread()).start();
                    //checkUser();
                    break;
                }
                else
                {
                    break;
                }

            case R.id.tReg:
                Toast.makeText(getApplicationContext(),"点击了注册链接",Toast.LENGTH_SHORT).show();
                Intent signup = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(signup);
                break;

            case R.id.tRePASS:
                Toast.makeText(getApplicationContext(),"点击了忘记密码链接",Toast.LENGTH_SHORT).show();
                Intent rePassword = new Intent(LoginActivity.this, RePassActivity.class);
                startActivity(rePassword);
                break;
        }
    }
    //子线程接受数据，主线程修改数据
    public class MyThread implements Runnable{
        @Override
        public void run()
        {
            info = WebServiceGet.executeHttpGet(username.getText().toString(),password.getText().toString());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //infotv.setText(info);
                    Toast.makeText(LoginActivity.this,info,Toast.LENGTH_SHORT).show();
                    System.out.print(info);
                    dialog.dismiss();
                }
            });
        }
    }

    //验证用户账户
    private Boolean checkUser()
    {
        if (username.getText().toString().isEmpty())
        {
            Toast.makeText(LoginActivity.this,"登录用户不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.getText().toString().isEmpty())
        {
            Toast.makeText(LoginActivity.this,"登录密码不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
