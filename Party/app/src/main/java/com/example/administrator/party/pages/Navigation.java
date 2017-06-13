package com.example.administrator.party.pages;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.party.R;


/**
 * Created by Administrator on 2017/3/31.
 */

public class Navigation extends AppCompatActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{

    //UI Objects
    private RadioGroup rg_tab_bar;
    private RadioButton rb_home;
    private RadioButton rb_friends;
    private RadioButton rb_message;
    private RadioButton rb_my;
    private ViewPager vpager;

    private MyFragmentPageAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

//    private RadioGroup rg_tab_bar;
//    private RadioButton rb_home;
//
//    //Fragment Object
//    private MyFragment fg4;
//    private HomeFragment fg1;
//    private FriendsFragment fg2;
//    private CodeFragment fg3;
//    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
//        fManager = getFragmentManager();
//        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
//        rg_tab_bar.setOnCheckedChangeListener(this);
//        //获取第一个单选按钮，并设置其为选中状态
//        rb_home = (RadioButton) findViewById(R.id.rb_home);
//        rb_home.setChecked(true);

        mAdapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        bindViews();
        rb_home.setChecked(true);
    }

    private void bindViews() {
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_friends = (RadioButton) findViewById(R.id.rb_friends);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_my = (RadioButton) findViewById(R.id.rb_my);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_friends:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_message:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_my:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_home.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_friends.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_message.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_my.setChecked(true);
                    break;
            }
        }
    }
//
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        FragmentTransaction fTransaction = fManager.beginTransaction();
//        hideAllFragment(fTransaction);
//        switch (checkedId){
//            case R.id.rb_home:
//                if(fg1 == null){
//                    fg1 = new HomeFragment();
//                    fTransaction.add(R.id.ly_content,fg1);
//                }else{
//                    fTransaction.show(fg1);
//                }
//                break;
//            case R.id.rb_friends:
//                if(fg2 == null){
//                    fg2 = new FriendsFragment();
//                    fTransaction.add(R.id.ly_content,fg2);
//                }else{
//                    fTransaction.show(fg2);
//                }
//                break;
//            case R.id.rb_message:
//                if(fg3 == null){
//                    fg3 = new CodeFragment();
//                    fTransaction.add(R.id.ly_content,fg3);
//                }else{
//                    fTransaction.show(fg3);
//                }
//                break;
//            case R.id.rb_my:
//                if(fg4 == null){
//                    fg4 = new MyFragment();
//                    fTransaction.add(R.id.ly_content,fg4);
//                }else{
//                    fTransaction.show(fg4);
//                }
//                break;
//        }
//        fTransaction.commit();
//    }
//
//    //隐藏所有Fragment
//    private void hideAllFragment(FragmentTransaction fragmentTransaction){
//        if(fg1 != null)fragmentTransaction.hide(fg1);
//        if(fg2 != null)fragmentTransaction.hide(fg2);
//        if(fg3 != null)fragmentTransaction.hide(fg3);
//        if(fg4 != null)fragmentTransaction.hide(fg4);
//    }

}
