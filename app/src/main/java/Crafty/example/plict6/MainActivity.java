package Crafty.example.plict6;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.ActivitatiPrincipale.Finishing;
import Crafty.example.plict6.ActivitatiPrincipale.grosbi;
import Crafty.example.plict6.ActivitatiPrincipale.lamai;
import Crafty.example.plict6.ActivitatiPrincipale.pepsi;
import Crafty.example.plict6.ActivitatiPrincipale.vinuri;



public class MainActivity extends AppCompatActivity {
    ImageView imageview1;
    ImageView imageview2;
    ImageView imageview3;
    ImageView imageview4;
    Button button;
    private static final String PREFS_NAME = "MyPrefs";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview1 = findViewById(R.id.lamai);
        imageview2 = findViewById(R.id.grosbi);
        imageview3 = findViewById(R.id.vinuri);
        imageview4 = findViewById(R.id.pepsi);

        imageview1.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), lamai.class);
            startActivity(i);
        });

        imageview2.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), grosbi.class);
            startActivity(i);
        });

        imageview3.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), vinuri.class);
            startActivity(i);
        });

        imageview4.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), pepsi.class);
            startActivity(i);
        });
        Button buttonClearData = findViewById(R.id.buttonClearDataM);
        buttonClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Creăm și afișăm un AlertDialog pentru confirmare
                android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Delete");
                alertDialogBuilder.setMessage("Esti sigur?");
                alertDialogBuilder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Executăm metoda clearUserData() dacă utilizatorul apasă "Da"
                        clearUserData();
                        Toast.makeText(MainActivity.this, "Datele au fost sterse cu succes", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("Nu", null);
                alertDialogBuilder.show();
            }
        });

        button = findViewById(R.id.buttonFinish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Esti sigur?")
                        .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Dacă utilizatorul apasă "Da", deschide ResultActivity
                                Intent intent = new Intent(MainActivity.this, Finishing.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Nu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Dacă utilizatorul apasă "Nu", închide dialogul fără a face nimic
                                dialog.dismiss();
                            }
                        });
                // Crearea și afișarea dialogului
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
    private void clearUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Ștergem datele de la userNumber1 până la userNumber108
        for (int i = 1; i <= 176; i++) {
            editor.remove("userNumber" + i);
        }

        editor.apply(); // Aplicați modificările
    }
}


