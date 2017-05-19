package com.example.administrator.party.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.party.R;

/**
 * Created by Administrator on 2017/5/18.
 */

public class RePassActivity extends Activity implements View.OnClickListener {
    private Button repassbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repassword);

        //repassbtn = (Button)findViewById(R.id.)

    }

    @Override
    public void onClick(View v){
//        switch (v.getId()){
//            case R.id.btn_Login:
//                Toast.makeText(getApplicationContext(),"点击了登录按钮",Toast.LENGTH_SHORT).show();
//                Intent login = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(login);
//                break;
//            case R.id.btn_Register:
//                Toast.makeText(getApplicationContext(),"点击了注册按钮",Toast.LENGTH_SHORT).show();
//                Intent signup = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(signup);
//                break;
//        }
    }
}
