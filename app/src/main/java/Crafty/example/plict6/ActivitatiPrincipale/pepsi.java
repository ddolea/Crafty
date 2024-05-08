package Crafty.example.plict6.ActivitatiPrincipale;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;


public class pepsi extends AppCompatActivity {


    EditText editTextText162;
     EditText editTextText163;
   EditText editTextText164;
     EditText editTextText165;
     EditText editTextText166;
    EditText editTextText167;
     EditText editTextText168;
    EditText editTextText169;
     EditText editTextText170;
     EditText editTextText171;
     EditText editTextText172;
     EditText editTextText173;
     EditText editTextText174;
    EditText editTextText175;
    EditText editTextText176;
     Button backButton17;
     Button backHomeButton22;
     Button buttonClearDataP;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pepsi);


        editTextText162 = findViewById(R.id.editTextText162);
        editTextText163 = findViewById(R.id.editTextText163);
        editTextText164 = findViewById(R.id.editTextText164);
        editTextText165 = findViewById(R.id.editTextText165);
        editTextText166 = findViewById(R.id.editTextText166);
        editTextText167 = findViewById(R.id.editTextText167);
        editTextText168 = findViewById(R.id.editTextText168);
        editTextText169 = findViewById(R.id.editTextText169);
        editTextText170 = findViewById(R.id.editTextText170);
        editTextText171 = findViewById(R.id.editTextText171);
        editTextText172 = findViewById(R.id.editTextText172);
        editTextText173 = findViewById(R.id.editTextText173);
        editTextText174 = findViewById(R.id.editTextText174);
        editTextText175 = findViewById(R.id.editTextText175);
        editTextText176 = findViewById(R.id.editTextText176);
buttonClearDataP=findViewById(R.id.buttonClearDataP);
        backButton17 = findViewById(R.id.backButton17);
       buttonClearDataP.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d("TAG", "Button clicked");

               AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(pepsi.this);
               alertDialogBuilder.setTitle("Delete");
               alertDialogBuilder.setMessage("Esti sigur?");
               alertDialogBuilder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       // Executăm metoda clearUserData() dacă utilizatorul apasă "Da"
                       clearUserData();
                       Toast.makeText(pepsi.this, "Datele au fost sterse cu succes", Toast.LENGTH_SHORT).show();
                   }
               });
               alertDialogBuilder.setNegativeButton("Nu", null);
               alertDialogBuilder.show();
           }
       });
        backButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        backHomeButton22 = findViewById(R.id.backHomeButton22);
        backHomeButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pepsi.this, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });

        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText162.setText(sharedPreferences.getString("userNumber162", ""));
        editTextText163.setText(sharedPreferences.getString("userNumber163", ""));
        editTextText164.setText(sharedPreferences.getString("userNumber164", ""));
        editTextText165.setText(sharedPreferences.getString("userNumber165", ""));
        editTextText166.setText(sharedPreferences.getString("userNumber166", ""));
        editTextText167.setText(sharedPreferences.getString("userNumber167", ""));
        editTextText168.setText(sharedPreferences.getString("userNumber168", ""));
        editTextText169.setText(sharedPreferences.getString("userNumber169", ""));
        editTextText170.setText(sharedPreferences.getString("userNumber170", ""));
        editTextText171.setText(sharedPreferences.getString("userNumber171", ""));
        editTextText172.setText(sharedPreferences.getString("userNumber172", ""));
        editTextText173.setText(sharedPreferences.getString("userNumber173", ""));
        editTextText174.setText(sharedPreferences.getString("userNumber174", ""));
        editTextText175.setText(sharedPreferences.getString("userNumber175", ""));
        editTextText176.setText(sharedPreferences.getString("userNumber176", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Salvarea datelor introduse de utilizator în SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber162", editTextText162.getText().toString());
        editor.putString("userNumber163", editTextText163.getText().toString());
        editor.putString("userNumber164", editTextText164.getText().toString());
        editor.putString("userNumber165", editTextText165.getText().toString());
        editor.putString("userNumber166", editTextText166.getText().toString());
        editor.putString("userNumber167", editTextText167.getText().toString());
        editor.putString("userNumber168", editTextText168.getText().toString());
        editor.putString("userNumber169", editTextText169.getText().toString());
        editor.putString("userNumber170", editTextText170.getText().toString());
        editor.putString("userNumber171", editTextText171.getText().toString());
        editor.putString("userNumber172", editTextText172.getText().toString());
        editor.putString("userNumber173", editTextText173.getText().toString());
        editor.putString("userNumber174", editTextText174.getText().toString());
        editor.putString("userNumber175", editTextText175.getText().toString());
        editor.putString("userNumber176", editTextText176.getText().toString());
        editor.apply();
    }

    private void hideKeyboard() {
        if (getApplicationContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            View focusedView = getCurrentFocus();
            if (focusedView != null) {
                inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
            }
        }
    }
    private void clearUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        for (int i = 162; i <= 176; i++) {
            editor.remove("userNumber" + i);
        }

        editor.apply(); // Aplicați modificările
    }
}

