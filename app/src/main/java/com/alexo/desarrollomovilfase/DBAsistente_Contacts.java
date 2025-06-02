package com.alexo.desarrollomovilfase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBAsistente_Contacts extends SQLiteOpenHelper {
    private static final int DB_VERSION = 6;
    private static final String DB_NAME =  "appfasedb";
    private static final String TABLE_NAME =  "contacts";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String LAST_NAME_COL = "last_name";
    private static final String PHONE_COL = "phone";
    private static final String EMAIL_COL = "email";
    private static final String NOTES_COL = "notes";

    public DBAsistente_Contacts (Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT, "
                + LAST_NAME_COL + " TEXT, "
                + PHONE_COL + " TEXT, "
                + EMAIL_COL + " TEXT, "
                + NOTES_COL + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void saveDB(ContactsModel model) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues vals = new ContentValues();
        vals.put(NAME_COL, model.getName());
        vals.put(LAST_NAME_COL, model.getLastName());
        vals.put(PHONE_COL, model.getPhone());
        vals.put(EMAIL_COL, model.getEmail());
        vals.put(NOTES_COL, model.getNotes());

        db.insert(TABLE_NAME, null, vals);
        db.close();
    }

    public ArrayList<ContactsModel> leerTodosLosContactos() {
        ArrayList<ContactsModel> lista = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                ContactsModel model = new ContactsModel();
                model.setName(cursor.getString(1));
                model.setLastName(cursor.getString(2));
                model.setPhone(cursor.getString(3));
                model.setEmail(cursor.getString(4));
                model.setNotes(cursor.getString(5));

                lista.add(model);
            }while (cursor.moveToNext());
        }
        db.close();
        return lista;
    }
}