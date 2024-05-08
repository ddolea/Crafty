package Crafty.example.plict6.ActivitatiPrincipale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import Crafty.example.plict6.MainActivity;

import Crafty.example.plict6.R;
import Crafty.example.plict6.Recyclers.RecyclerGrosbi;
import java.util.ArrayList;

public class grosbi extends Activity {
    private RecyclerView recyclerView;
    private ArrayList<String> grosbiNameList = new ArrayList<>();
    private RecyclerGrosbi adapter;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grosbi);

        // Inițializarea RecyclerView
        recyclerView = findViewById(R.id.recyclerGrosbi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adăugarea numelui produselor de grosbi în lista de nume
        grosbiNameList.add("Aperitivo");
        grosbiNameList.add("Bere");
        grosbiNameList.add("Vodca");
        grosbiNameList.add("Gin");
        grosbiNameList.add("Blended Scotch Whiskey");
        grosbiNameList.add("Old Scotch Whiskey");
        grosbiNameList.add("Single Malt Whiskey");
        grosbiNameList.add("Irish Whiskey");
        grosbiNameList.add("Bulleit");
        grosbiNameList.add("Rom");
        grosbiNameList.add("Tequila");
        grosbiNameList.add("Coniac");
        grosbiNameList.add("Lichior");
        grosbiNameList.add("Cinzano");
        grosbiNameList.add("Prosecco");
        grosbiNameList.add("San Pellegrino 0.33");
        grosbiNameList.add("Ungheni");
        grosbiNameList.add("Johnnie HighBall");
        grosbiNameList.add("Rockstar");
        grosbiNameList.add("Panna & Pellegrino");
        grosbiNameList.add("Monin Sirop");
        grosbiNameList.add("Monin Piure");

        // Inițializarea adaptorului RecyclerView
        adapter = new RecyclerGrosbi(grosbiNameList, this);
        recyclerView.setAdapter(adapter);

        // Inițializarea butonului de ștergere a datelor
        Button buttonClearData = findViewById(R.id.buttonClearDataG);
        buttonClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Creăm și afișăm un AlertDialog pentru confirmare
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(grosbi.this);
                alertDialogBuilder.setTitle("Delete");
                alertDialogBuilder.setMessage("Esti sigur?");
                alertDialogBuilder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Executăm metoda clearUserData() dacă utilizatorul apasă "Da"
                        clearUserData();
                        Toast.makeText(grosbi.this, "Datele au fost sterse cu succes", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("Nu", null);
                alertDialogBuilder.show();
            }
        });


        // Inițializarea butonului de back
        Button backButton = findViewById(R.id.backButton16);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Inițializarea butonului de back la home
        Button backHomeButton = findViewById(R.id.backHomeButton20);
        backHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(grosbi.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Metoda pentru ștergerea datelor introduse de utilizator
    // Metoda pentru ștergerea datelor introduse de utilizator până la userNumber108
    private void clearUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Ștergem datele de la userNumber1 până la userNumber108
        for (int i = 1; i <= 108; i++) {
            editor.remove("userNumber" + i);
        }

        editor.apply(); // Aplicați modificările
    }
}
