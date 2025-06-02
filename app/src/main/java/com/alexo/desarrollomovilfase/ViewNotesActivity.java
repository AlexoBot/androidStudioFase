package com.alexo.desarrollomovilfase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        // Leer todos los contactos
        DBAsistente_Notes db = new DBAsistente_Notes(ViewNotesActivity.this);
        ArrayList<NotesModel> lista = db.leerTodasLasNotas();

        NotesRVAdapter reciclador = new NotesRVAdapter(lista, this);
        RecyclerView notesrv = findViewById(R.id.idRVNotes);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        notesrv.setLayoutManager(LinearLayoutManager);
        notesrv.setAdapter(reciclador);
    }
}