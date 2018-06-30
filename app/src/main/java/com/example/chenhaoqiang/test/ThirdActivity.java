package com.example.chenhaoqiang.test;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.chenhaoqiang.test.fragment.FirestFragment;

public class ThirdActivity extends AppCompatActivity implements FirestFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        /*FragmentManager是与Activity中Fragment交互的接口即用于管理Activity中的Fragment
        * FragmentTransaction是执行一系列Fragment操作的接口*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        /*在运行期间将fragment添加到Activity的布局中：先将fragment添加到父容器中然后提交fragmentTransaction的修改*/
        fragmentTransaction.add(R.id.framelayout_fragment, FirestFragment.newInstance("param1", "param2"))
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, "交互接口", Toast.LENGTH_SHORT).show();
    }
}
