package com.example.chenhaoqiang.test.viewpager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

/**
 * ViewPager的适配器：用于向ViewPager提供用于显示的Page
 * 此例中每页显示一个Fragment
 *
 * @author chenhaoqiang
 * @date 2018/7/30
 */
public class MyVpAdapter extends FragmentStatePagerAdapter {
    private static final int PAGE_NUM = 5;

    public MyVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MyVpFragment myVpFragment = new MyVpFragment();
        myVpFragment.setTitle(position);
        return myVpFragment;
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }

}
