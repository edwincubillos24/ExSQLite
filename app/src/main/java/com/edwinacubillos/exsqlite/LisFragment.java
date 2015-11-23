package com.edwinacubillos.exsqlite;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LisFragment extends ListFragment {

    private SQLiteDatabase data2;

    public LisFragment() {
        // Required empty public constructor
    }

    public void setdatabase (SQLiteDatabase d1){ //recibe la base de datos del MainActivity
        data2 = d1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ArrayList<String> resultado=new ArrayList<String>();
        String tabla = "notasEstudiantes1";
        Cursor cursor = data2.rawQuery("select * from "+tabla, null);
        String res="";

        if (cursor.moveToFirst()){
            do{
                for (int i=0;i<cursor.getColumnCount();i++){
                    res = res + "\t"+cursor.getString(i);
                }
                resultado.add(res);
                res = "";
            }while (cursor.moveToNext());
        }

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, resultado));

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        this.getListView().setBackgroundColor(getResources().getColor(R.color.White));
           //     setBackgroundColor(getResources());//.getColor(R.color.White));

        super.onActivityCreated(savedInstanceState);
    }

}
