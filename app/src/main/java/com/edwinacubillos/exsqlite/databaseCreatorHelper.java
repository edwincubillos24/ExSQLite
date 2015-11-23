package com.edwinacubillos.exsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Edwin on 23/11/2015.
 */
public class databaseCreatorHelper extends SQLiteOpenHelper {

    final static String TABLE_NAME="notasEstudiantes1";
    final static String CREATE_TABLE="create table "+TABLE_NAME+  //"" +
            " (id integer primary key autoincrement," +
            " nombre text, nota1 float, nota2 float, nota3 float)";

    public databaseCreatorHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
