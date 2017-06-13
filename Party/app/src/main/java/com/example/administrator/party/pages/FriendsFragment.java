package com.example.administrator.party.pages;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.party.R;

/**
 * Created by Administrator on 2017/6/13.
 */

public class FriendsFragment extends Fragment {
    public FriendsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends,container,false);
        return view;
    }

}
