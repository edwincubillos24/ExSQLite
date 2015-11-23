package com.edwinacubillos.exsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnInsert {

    PagerAdapter mSectionsPagerAdapter;
    ArrayList<Fragment> fragmentList;
    ViewPager mViewPager;

    SQLiteDatabase data; //Crear la base de datos

    DeleteFragment deleteFragment;
    InsertFragment insertFragment ;
    LisFragment lisFragment;
    SelectFragment selectFragment;
    UpdateFragment updateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromstart();

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

        insertFragment.setdatabase(data);
        deleteFragment.setdatabase(data);
        selectFragment.setdatabase(data);
        updateFragment.setdatabase(data);
        lisFragment.setdatabase(data);





        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    public void fromstart(){
        databaseCreatorHelper helper = new databaseCreatorHelper(this, "notas", null, 1);
        data=helper.getWritableDatabase();
        Toast.makeText(this, "Nombre: "+helper.getDatabaseName().toString(), Toast.LENGTH_LONG ).show();
    }


    @Override
    public void insert(SQLiteDatabase dd) {
        Toast.makeText(this, "valor recibido", Toast.LENGTH_LONG).show();
        data = dd;
        mViewPager.getAdapter().notifyDataSetChanged();
    }
}
