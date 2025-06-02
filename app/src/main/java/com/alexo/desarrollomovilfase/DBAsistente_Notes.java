package com.alexo.desarrollomovilfase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBAsistente_Notes extends SQLiteOpenHelper {
    private static final int DB_VERSION = 6;
    private static final String DB_NAME = "appfasedb";
    private static final String TABLE_NAME = "notes";
    private static final String ID_COL = "id";
    private static final String TITLE_COL = "title";
    private static final String DATE_COL = "date";
    private static final String DESC_COL = "description";
    public DBAsistente_Notes (Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT, "
                + DATE_COL + " TEXT, "
                + DESC_COL + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public void saveDB(NotesModel model) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues vals = new ContentValues();
        vals.put(TITLE_COL, model.getTitle());
        vals.put(DATE_COL, model.getDate());
        vals.put(DESC_COL, model.getDescription());

        db.insert(TABLE_NAME, null, vals);
        db.close();
    }

    public ArrayList<NotesModel> leerTodasLasNotas() {
        ArrayList<NotesModel> lista = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME,null);

        if (cursor.moveToFirst()){
            do {
                NotesModel model = new NotesModel();
                model.setTitle(cursor.getString(1));
                model.setDate(cursor.getString(2));
                model.setDescription(cursor.getString(3));

                lista.add(model);
            }while (cursor.moveToNext());
        }
        db.close();
        return lista;
    }
}
