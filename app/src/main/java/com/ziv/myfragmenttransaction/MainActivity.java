package com.ziv.myfragmenttransaction;

import android.hardware.camera2.CameraManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ziv.myfragmenttransaction.fragments.DetailFragment;
import com.ziv.myfragmenttransaction.fragments.InfoFragment;
import com.ziv.myfragmenttransaction.fragments.OrderFragment;
import com.ziv.myfragmenttransaction.fragments.StartFragment;

/**
 * 实现Start、Order、Info三个Fragment的自由跳转，Detail作为二级页面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentManager mFragmentManager;

    private StartFragment startFragment;
    private OrderFragment orderFragment;
    private InfoFragment infoFragment;
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();

        startFragment = new StartFragment();
        orderFragment = new OrderFragment();
        infoFragment = new InfoFragment();

        findViewById(R.id.radiobutton_start).setOnClickListener(this);
        findViewById(R.id.radiobutton_order).setOnClickListener(this);
        findViewById(R.id.radiobutton_info).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.radiobutton_start:
                replaceFragment(startFragment,"",true);
                break;
            case R.id.radiobutton_order:
                replaceFragment(orderFragment,"",true);
                break;
            case R.id.radiobutton_info:
                replaceFragment(infoFragment,"",true);
                break;
        }
    }

    /**
     * fragment切换
     * @param fragment 需要显示的Fragment
     * @param tag Tag标签
     * @param addToBackStack 是否加入栈
     */
    public void replaceFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment, tag);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
    /**
     * 解决重影问题
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * 跳转DetailFragment
     * @param view
     */
    public void startDetailFragment(View view) {
        DetailFragment detailFragment = new DetailFragment();
        replaceFragment(detailFragment,"",true);
    }
}
