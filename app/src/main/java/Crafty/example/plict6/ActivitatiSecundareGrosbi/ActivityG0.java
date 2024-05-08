package Crafty.example.plict6.ActivitatiSecundareGrosbi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;


public class ActivityG0 extends AppCompatActivity {

    public EditText editTextText1;
    public EditText editTextText2;
    public EditText editTextText3;
    Button button1;
    Button button2;
    private static final String PREFS_NAME = "MyPrefs";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityg0layout);

        editTextText1 = findViewById(R.id.editTextText1);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);

        button1 = findViewById(R.id.backButton21);
        button2 = findViewById(R.id.backHomeButton21);

        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityG0.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });

        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        // Verificăm dacă valorile din SharedPreferences nu sunt goale, înainte de a le seta în EditText-uri
        String userNumber1 = sharedPreferences.getString("userNumber1", "");
        String userNumber2 = sharedPreferences.getString("userNumber2", "");
        String userNumber3 = sharedPreferences.getString("userNumber3", "");
        // Setăm valorile din SharedPreferences în EditText-uri doar dacă nu sunt goale
        if (!userNumber1.isEmpty()) {
            editTextText1.setText(userNumber1);
        }
        if (!userNumber2.isEmpty()) {
            editTextText2.setText(userNumber2);
        }
        if (!userNumber3.isEmpty()) {
            editTextText3.setText(userNumber3);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber1", editTextText1.getText().toString());
        editor.putString("userNumber2", editTextText2.getText().toString());
        editor.putString("userNumber3", editTextText3.getText().toString());
        editor.apply();
        Log.d("SharedPrefs", "Value for userNumber1: " + editTextText1.getText().toString());
        Log.d("SharedPrefs", "Value for userNumber2: " + editTextText2.getText().toString());
        Log.d("SharedPrefs", "Value for userNumber3: " + editTextText3.getText().toString());
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
}