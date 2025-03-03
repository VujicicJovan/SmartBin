package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dobrodosli);
        EdgeToEdge.enable(this);


        Button btnLogIn = (Button) findViewById(R.id.btnLogin);
        Button btnSingUp = (Button) findViewById(R.id.btnNapNal);


        if (btnLogIn != null && btnSingUp != null) {

            btnLogIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent LogInOpen = new Intent(MainActivity.this, LogIn.class);                    startActivity(LogInOpen);
                }
            });

            btnSingUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent SignupOpen = new Intent(MainActivity.this, SignUp.class);
                    startActivity(SignupOpen);
                }
            });
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
