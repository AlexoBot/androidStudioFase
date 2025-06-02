package com.alexo.desarrollomovilfase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandingPageActivity extends AppCompatActivity {
    Button botonGotoApi;
    Button botonGotoViewContacts;
    Button botonGotoDB;
    Button btnGotoRegNote;
    Button btnGotoSeeNote;
    TextView tvUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        String userName = getIntent().getStringExtra("NOMBRE");
        tvUserName = (TextView) findViewById(R.id.textViewUserName);
        tvUserName.setText("Hola "+ userName);

        botonGotoViewContacts = (Button) findViewById(R.id.buttonGoToViewContacts);
        botonGotoApi = (Button) findViewById(R.id.buttonGoToApiAct);
        botonGotoDB = (Button) findViewById(R.id.buttonGoToDBAct);
        btnGotoRegNote = (Button) findViewById(R.id.btnGoToRegisterNotesLayout);
        btnGotoSeeNote = (Button) findViewById(R.id.btnGoToNotesLayout);

        botonGotoApi.setOnClickListener(GoToAPIAct());
        botonGotoDB.setOnClickListener(GoToDBAct());
        botonGotoViewContacts.setOnClickListener(GoToViewContacts());
        btnGotoSeeNote.setOnClickListener(GoToSeeNoteLay());
        btnGotoRegNote.setOnClickListener(GoToRegNoteLay());
    }

    private View.OnClickListener GoToRegNoteLay() {
        return v -> {
            Intent i = new Intent(LandingPageActivity.this, RegisterNotesActivity.class);
            startActivity(i);
        };
    }

    private View.OnClickListener GoToSeeNoteLay() {
        return v -> {
            Intent i = new Intent(LandingPageActivity.this, ViewNotesActivity.class);
            startActivity(i);
        };
    }

    private View.OnClickListener GoToViewContacts() {
        return v -> {
            Intent i = new Intent(LandingPageActivity.this, ViewContactsActivity.class);
            startActivity(i);
        };
    }

    private View.OnClickListener GoToDBAct() {
        return v -> {
            Intent i = new Intent(LandingPageActivity.this, DBActivity.class);
            startActivity(i);
        };
    }

    private View.OnClickListener GoToAPIAct() {
        return v -> {
            Intent i = new Intent(LandingPageActivity.this, APIActivity.class);
            startActivity(i);
        };
    }
}