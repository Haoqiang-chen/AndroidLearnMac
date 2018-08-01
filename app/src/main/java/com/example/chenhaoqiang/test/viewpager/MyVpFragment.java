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
 * 修改Fragment布局中TextView时使用Bundle
 * @author chenhaoqiang
 * @date 2018/7/30
 */
public class MyVpFragment extends Fragment {

    private View rootView;
    private TextView textView;

    public static MyVpFragment newInstance(int position) {
        MyVpFragment fragment = new MyVpFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        //setArguments方法可以提供构造fragment时需要的参数
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragmenmt_vp, container, false);
        textView = rootView.findViewById(R.id.textview_title);
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        textView.setText("这个是第 " + Integer.toString(position) + "个Fragment 哈哈哈");
        return rootView;
    }


}
