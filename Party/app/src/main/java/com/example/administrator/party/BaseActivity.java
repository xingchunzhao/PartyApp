package com.example.administrator.party;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.administrator.party.activity.LoginActivity;
import com.example.administrator.party.http.WebServiceGet;

/**
 * Created by Administrator on 2017/5/19.
 */

public class BaseActivity extends Activity{

    //检测网络
    public boolean checkNetwork()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null)
        {
            return connectivityManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }
}
