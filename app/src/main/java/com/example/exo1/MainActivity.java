package com.example.exo1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {
    private int counter = 0; // Déclare une variable pour le compteur
    private TextView counterTextView; // Déclare une variable pour le TextView


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Trouver le bouton dans le layout en utilisant son ID
        Button toastButton = findViewById(R.id.toast_button);

        // Associer un OnClickListener pour détecter les clics sur le bouton
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Afficher un Toast avec le message "Hello Toast!"
                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
            }
        });
        Button count =findViewById(R.id.count);
        counterTextView = findViewById(R.id.counter_text_view);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    counter++; // Incrémente le compteur
                    counterTextView.setText(String.valueOf(counter));

            }
        });


        // Gérer les insets pour les barres du système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }}