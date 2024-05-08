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
import Crafty.example.plict6.Recyclers.RecyclerLamai;

import java.util.ArrayList;

public class lamai extends Activity {
    RecyclerView recyclerView;
    ArrayList<String> lamaiNameList = new ArrayList<>();
    RecyclerLamai adapter;
    Button button;
    Button button2;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lamai);
        recyclerView=this.findViewById(R.id.RecyclerLamai);
        Button buttonClearData = findViewById(R.id.buttonClearDataL);
        buttonClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Creăm și afișăm un AlertDialog pentru confirmare
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(lamai.this);
                alertDialogBuilder.setTitle("Delete");
                alertDialogBuilder.setMessage("Esti sigur?");
                alertDialogBuilder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Executăm metoda clearUserData() dacă utilizatorul apasă "Da"
                        clearUserData();
                        Toast.makeText(lamai.this, "Datele au fost sterse cu succes", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("Nu", null);
                alertDialogBuilder.show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(lamai.this));
        lamaiNameList.add("Lapte");
        lamaiNameList.add("Ladite");
        lamaiNameList.add("Caserole");
        lamaiNameList.add("Auxiliare");
        lamaiNameList.add("Frisca");
        adapter=new RecyclerLamai(lamaiNameList,this);
        recyclerView.setAdapter(adapter);
        button=findViewById(R.id.backButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamai.this.finish();
            }
        });
        button2=findViewById(R.id.backHomeButton1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lamai.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void clearUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Ștergem datele de la userNumber1 până la userNumber108
        for (int i = 109; i <= 133; i++) {
            editor.remove("userNumber" + i);
        }

        editor.apply(); // Aplicați modificările
    }
}


