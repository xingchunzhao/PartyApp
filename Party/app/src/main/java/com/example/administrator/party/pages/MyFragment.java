package com.example.administrator.party.pages;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.party.R;

/**
 * Created by Administrator on 2017/6/7.
 */

public class MyFragment extends Fragment {

    private String content;

    public MyFragment(){}
    @Override
    public View onCreateView(LayoutInflater  inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);
//        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
//        txt_content.setText(content);
        return view;
    }
}
