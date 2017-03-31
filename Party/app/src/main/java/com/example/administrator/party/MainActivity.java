package com.example.administrator.party;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_L;
    private Button btn_R;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_L = (Button)findViewById(R.id.btn_Login);
        btn_R = (Button)findViewById(R.id.btn_Register);

        btn_L.setOnClickListener(this);
        btn_R.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_Login:
                Toast.makeText(getApplicationContext(),"点击了登录按钮",Toast.LENGTH_SHORT).show();
//                Intent it = new Intent();
//                it.setAction(Intent.ACTION_VIEW);
//                it.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(it);
                Intent login = new Intent(MainActivity.this,FirstPage.class);
                startActivity(login);
                break;
            case R.id.btn_Register:
                Toast.makeText(getApplicationContext(),"点击了注册按钮",Toast.LENGTH_SHORT).show();
                Intent its = new Intent();
                its.setAction(Intent.ACTION_VIEW);
                its.setData(Uri.parse("http://www.goole.com"));
                startActivity(its);
                break;
        }
    }
}
