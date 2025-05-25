package com.alexo.desarrollomovilfase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);

        // Leer todos los contactos
        DBAsistente_Contacts db = new DBAsistente_Contacts(ViewContactsActivity.this);
        ArrayList<ContactsModel> lista = db.leerTodosLosContactos();

        //Mezclar la lista completa
        ContactRVAdapter reciclador = new ContactRVAdapter(lista, this);
        RecyclerView contactsrv = findViewById(R.id.idRVContacts);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        contactsrv.setLayoutManager(LinearLayoutManager);
        contactsrv.setAdapter(reciclador);
    }
}