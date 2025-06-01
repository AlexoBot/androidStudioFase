package com.alexo.desarrollomovilfase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterNotesActivity extends AppCompatActivity {
    Button btnRegisterNewNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_notes);

        btnRegisterNewNote = (Button) findViewById(R.id.btnCreateNote);

        btnRegisterNewNote.setOnClickListener(CreateNote());
    }

    private View.OnClickListener CreateNote() {
        return v -> {

            //leer valores
            EditText titleField = (EditText) findViewById(R.id.eptNotesTitle);
            EditText dateField = (EditText) findViewById(R.id.eptNotesDate);
            EditText descField = (EditText) findViewById(R.id.eptNotesDescription);


            String cTitle = titleField.getText().toString();
            String cDate = dateField.getText().toString();
            String cDesc = descField.getText().toString();

            //insertar en el modelo
            NotesModel model = new NotesModel();

            model.setTitle(cTitle);
            model.setDate(cDate);
            model.setDescription(cDesc);

            //guardar el modelo en la db
            DBAsistente_Notes db = new DBAsistente_Notes(RegisterNotesActivity.this);
            db.saveDB(model);

            //Limpiar
            titleField.setText("");
            dateField.setText("");
            descField.setText("");
        };
    }
}