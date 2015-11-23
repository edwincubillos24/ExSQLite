package com.edwinacubillos.exsqlite;


import android.content.Context;
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
public class DeleteFragment extends Fragment implements View.OnClickListener {

    private SQLiteDatabase data2;
    EditText e;
    Button b;
    OnInsert listener;

    public DeleteFragment() {
        // Required empty public constructor
    }

    public void setdatabase (SQLiteDatabase d1){ //recibe la base de datos del MainActivity
        data2 = d1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_delete, container, false);
        b = (Button) rootView.findViewById(R.id.bDelBuscar);
        e = (EditText) rootView.findViewById(R.id.eDelBuscar);
        b.setOnClickListener(this);
        return rootView;

    }

    @Override
    public void onClick(View v) {
        String tabla = "notasEstudiantes1";
        String selection = "nombre = ?";
        String [] selectionArgs = {e.getText().toString()};
        data2.delete(tabla,selection,selectionArgs);
        borrar();
    }
    public void borrar () {e.setText("");}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnInsert) context;
    }
}
