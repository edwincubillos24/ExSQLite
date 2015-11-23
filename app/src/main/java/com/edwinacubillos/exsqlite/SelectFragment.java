package com.edwinacubillos.exsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment implements View.OnClickListener {

    private SQLiteDatabase data2;
    EditText e;
    TextView t;
    Button b;

    public void setdatabase (SQLiteDatabase d1){ //recibe la base de datos del MainActivity
        data2 = d1;
    }

    public SelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_select, container, false);

        b = (Button) rootView.findViewById(R.id.bBuscar);
        t = (TextView) rootView.findViewById(R.id.sInfo);
        e = (EditText) rootView.findViewById(R.id.eBuscar);

        b.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        String tabla = "notasEstudiantes1";
        String [] columnas = {"nombre", "nota1","nota2"};
        String [] selectionArgs = {e.getText().toString()};
        String selection = "nombre = ?";

        Cursor c = data2.query(tabla, columnas, selection, selectionArgs, null, null,null);
        //data.rawquery("SELECT nombre,nota1,nota2 FROM notasEstudiantes WHERE nombre=? ",selectionArgs,NULL)
        String resultado="";

        if (c.moveToFirst()){
            do{
                for (int i=0; i<c.getColumnCount(); i++){
                    resultado = resultado + c.getString(i);
                }
            }while (c.moveToNext());
        }
        t.setText(resultado.toString());
        borrar();

    }

    public void borrar(){
        e.setText("");

    }
}
