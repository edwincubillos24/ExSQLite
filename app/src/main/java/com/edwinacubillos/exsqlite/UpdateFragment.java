package com.edwinacubillos.exsqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment implements View.OnClickListener{

    private SQLiteDatabase data2;
    OnInsert listener;
    EditText nombre, nota1,nota2, nota3;

    public void setdatabase (SQLiteDatabase d1){ //recibe la base de datos del MainActivity
        data2 = d1;
    }

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_update, container, false);

        nombre = (EditText) rootView.findViewById(R.id.eSobNombre);
        nota1 = (EditText) rootView.findViewById(R.id.eSobNota1);
        nota2 = (EditText) rootView.findViewById(R.id.eSobNota2);
        nota3 = (EditText) rootView.findViewById(R.id.eSobNota3);

        Button sobreescribir = (Button) rootView.findViewById(R.id.bSobreescribir);

        sobreescribir.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnInsert) context;
    }

    @Override
    public void onClick(View v) {
        String tabla = "notasEstudiantes1";
        String selection="nombre = ?";
        String [] selectionArgs = {nombre.getText().toString()};
        ContentValues valor = new ContentValues();
        valor.put("nota1",Float.parseFloat(nota1.getText().toString()));
        valor.put("nota2",Float.parseFloat(nota2.getText().toString()));
        valor.put("nota3", Float.parseFloat(nota3.getText().toString()));
        data2.update(tabla, valor, selection, selectionArgs);
        borrar();
    }

    public void borrar(){
        nombre.setText("");
        nota1.setText("");
        nota2.setText("");
        nota3.setText("");
    }
}
