package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogIn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uloguj_se);

        Button btnUlogujSe = findViewById(R.id.btnLogin);
        EditText EmailLogIn = findViewById(R.id.editTextTextEmailAddress);
        EditText LozinkaLogIn = findViewById(R.id.editTextTextPassword);



        DatabaseHelper dbHelper = new DatabaseHelper(LogIn.this);

        btnUlogujSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EmailLogIntxt = EmailLogIn.getText().toString();
                String LozinkaLogIntxt = LozinkaLogIn.getText().toString();

                if (dbHelper.checkUser(EmailLogIntxt, LozinkaLogIntxt)) {
                    Toast.makeText(LogIn.this, "Uspešna prijava", Toast.LENGTH_SHORT).show();
                    Intent MainManueOpen = new Intent(LogIn.this, MainMenu.class);
                    dbHelper.setCurrentUserEmail(EmailLogIntxt);;
                    startActivity(MainManueOpen);



                } else {
                    Toast.makeText(LogIn.this, "Neispravan email i/ili lozinka!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}