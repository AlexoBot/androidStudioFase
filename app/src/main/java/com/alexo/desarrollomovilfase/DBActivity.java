package com.alexo.desarrollomovilfase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DBActivity extends AppCompatActivity {
    Button addContactBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        addContactBtn = (Button) findViewById(R.id.buttonAddContact);
        addContactBtn.setOnClickListener(addContact());

    }

    private View.OnClickListener addContact() {
        return v -> {

            //leer valores
            EditText nameField = (EditText) findViewById(R.id.editContactName);
            EditText lastNameField = (EditText) findViewById(R.id.editContactLastName);
            EditText phoneField = (EditText) findViewById(R.id.editContactPhone);
            EditText emailField = (EditText) findViewById(R.id.editContactEmail);
            EditText notesField = (EditText) findViewById(R.id.editContactNotes);

            String cName = nameField.getText().toString();
            String cLastName = lastNameField.getText().toString();
            String cPhone = phoneField.getText().toString();
            String cEmail = emailField.getText().toString();
            String cNotes = notesField.getText().toString();

            //insertar en el modelo
            ContactsModel model = new ContactsModel();

            model.setName(cName);
            model.setLastName(cLastName);
            model.setPhone(cPhone);
            model.setEmail(cEmail);
            model.setNotes(cNotes);

            //guardar el modelo en la db
            DBAsistente_Contacts db = new DBAsistente_Contacts(DBActivity.this);
            db.saveDB(model);

            //Limpiar
            nameField.setText("");
            lastNameField.setText("");
            phoneField.setText("");
            emailField.setText("");
            notesField.setText("");
        };
    }
}