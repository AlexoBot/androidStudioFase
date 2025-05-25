package com.alexo.desarrollomovilfase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    Button botonLogin;
    EditText editTextName;
    EditText editTextPass;
    String loginName = "Admin";
    String loginPass = "Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botonLogin = (Button) findViewById(R.id.buttonLoginAct);
        editTextName = (EditText) findViewById(R.id.editLoginName);
        editTextPass = (EditText) findViewById(R.id.editLoginPass);

        botonLogin.setOnClickListener(clickLogin());
    }


    private View.OnClickListener clickLogin() {
        return v -> {
            // Convert user input to String
            String inputName = editTextName.getText().toString();
            String inputPass = editTextPass.getText().toString();

            // Compare using .equals()
            if (inputName.equals(loginName) && inputPass.equals(loginPass)) {
                botonLogin.setText("Login successful!");
                Intent i = new Intent(LoginActivity.this, LandingPageActivity.class);
                i.putExtra("NOMBRE",inputName);
                startActivity(i);
            } else {
                botonLogin.setText("Login failed!");
            }
        };
    }
}