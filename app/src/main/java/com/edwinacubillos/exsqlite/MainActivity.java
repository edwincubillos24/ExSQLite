package com.edwinacubillos.exsqlite;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PagerAdapter mSectionsPagerAdapter;
    ArrayList<Fragment> fragmentList;
    ViewPager mViewPager;

    DeleteFragment deleteFragment;
    InsertFragment insertFragment ;
    LisFragment lisFragment;
    SelectFragment selectFragment;
    UpdateFragment updateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deleteFragment=new DeleteFragment();
        insertFragment=new InsertFragment();
        lisFragment=new LisFragment();
        selectFragment=new SelectFragment();
        updateFragment=new UpdateFragment();

        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(deleteFragment);
        fragmentList.add(insertFragment);
        fragmentList.add(selectFragment);
        fragmentList.add(updateFragment);
        fragmentList.add(lisFragment);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }
}
