package com.example.chenhaoqiang.test.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chenhaoqiang.test.R;

/**
 * 用于在ViewPager中显示Page
 *
 * @author chenhaoqiang
 * @date 2018/7/30
 */
public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.viewpager);
        //设置ViewPager的适配器
        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myVpAdapter);
    }

    /**
     * 设置返回按钮的功能
     */
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
