package com.example.chenhaoqiang.test.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenhaoqiang.test.R;

/**
 * ViewPager用到的Fragment
 * 用来表示每一页中的内容
 *
 * @author chenhaoqiang
 * @date 2018/7/30
 */
public class MyVpFragment extends Fragment {

    private View rootView;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragmenmt_vp, container, false);
        return rootView;
    }

    public void setTitle(int position){
        textView = rootView.findViewById(R.id.textview_title);
        textView.setText("这个是第 " + Integer.toString(position) + "个Fragment 哈哈哈");
    }
}
