package com.example.chenhaoqiang.test.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.chenhaoqiang.test.R;

/**
 * 用于在ViewPager中显示Page
 * ViewPager总结：
 *    ViewPager的作用：可以实现屏幕幻灯片动画
 *    ViewPager的使用方法：首先在布局文件中可以使用通过继承自定义的ViewPager，或者直接使用基类ViewPager
 *                       然后需要为ViewPager提供适配器即PagerAdapter，PagerAdapter适配器用于提供填充Page的View，一般使用Fragment来作为Page的View
 * @author chenhaoqiang
 * @date 2018/7/30
 */
public class ViewPagerActivity extends AppCompatActivity {

    private static final int CHAT = 0;
    private static final int CONTACTS = 1;
    private static final int FIND = 2;
    private static final int MINE = 3;

    private ViewPager viewPager;
    private ImageView imgChat, imgContacts, imgFind, imgMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initView();
        initListener();
        //设置ViewPager的适配器
        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myVpAdapter);

    }

    private void initView(){
        viewPager = findViewById(R.id.viewpager);
        imgChat = findViewById(R.id.img_chat);
        imgContacts = findViewById(R.id.img_contacts);
        imgFind = findViewById(R.id.img_find);
        imgMine = findViewById(R.id.img_mine);
    }

    private void initListener(){
        imgChat.setOnClickListener(show);
        imgContacts.setOnClickListener(show);
        imgFind.setOnClickListener(show);
        imgMine.setOnClickListener(show);

    }

    View.OnClickListener show = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == imgChat){
                viewPager.setCurrentItem(CHAT);
            }
            if (v == imgContacts){
                viewPager.setCurrentItem(CONTACTS);
            }
            if (v == imgFind){
                viewPager.setCurrentItem(FIND);
            }
            if (v == imgMine){
                viewPager.setCurrentItem(MINE);
            }
        }
    };
    /**
     * 重写返回按钮的功能
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
