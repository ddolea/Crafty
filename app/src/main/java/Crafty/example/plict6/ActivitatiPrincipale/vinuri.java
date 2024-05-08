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
import Crafty.example.plict6.Recyclers.RecyclerVinuri;

import java.util.ArrayList;

public class vinuri extends Activity{
    RecyclerView recyclerView;
    ArrayList<String>vinuriNameList=new ArrayList<>();
    RecyclerVinuri adapter;
    private static final String PREFS_NAME = "MyPrefs";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Button button;
        Button button2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vinuri);
        recyclerView = findViewById(R.id.recyclerVinuri);
        recyclerView.setLayoutManager(new LinearLayoutManager(vinuri.this));
        vinuriNameList.add("Budureasca");
        vinuriNameList.add("Purcari");
        vinuriNameList.add("Naiv Tamaioasa Romaneasca");
        vinuriNameList.add("Gitana Winery");
        vinuriNameList.add("Vinarte");
        vinuriNameList.add("Spumant");
        vinuriNameList.add("Taraboste");
        vinuriNameList.add("Crama Mircesti");
        vinuriNameList.add("Individo");
        vinuriNameList.add("Vladoianu & Montedidio");
        adapter= new RecyclerVinuri(vinuriNameList,vinuri.this);
        recyclerView.setAdapter(adapter);
        button=findViewById(R.id.backButton7);
        button2=findViewById(R.id.backHomeButton30);
        Button buttonClearData = findViewById(R.id.buttonClearDataV);
        buttonClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Creăm și afișăm un AlertDialog pentru confirmare
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(vinuri.this);
                alertDialogBuilder.setTitle("Delete");
                alertDialogBuilder.setMessage("Esti sigur?");
                alertDialogBuilder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Executăm metoda clearUserData() dacă utilizatorul apasă "Da"
                        clearUserData();
                        Toast.makeText(vinuri.this, "Datele au fost sterse cu succes", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("Nu", null);
                alertDialogBuilder.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vinuri.this.finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vinuri.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void clearUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Ștergem datele de la userNumber1 până la userNumber108
        for (int i = 134; i <= 161; i++) {
            editor.remove("userNumber" + i);
        }

        editor.apply(); // Aplicați modificările
    }
}
