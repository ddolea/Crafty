package Crafty.example.plict6.ActivitatiSecundareGrosbi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;


public class ActivityG5 extends AppCompatActivity {

    public EditText editTextText19;
    public EditText editTextText20;
    public EditText editTextText21;
    public EditText editTextText22;
    public EditText editTextText23;
    public EditText editTextText24;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g5layout);

        // Inițializare EditText-uri
        editTextText19 = findViewById(R.id.editTextText19);
        editTextText20 = findViewById(R.id.editTextText20);
        editTextText21 = findViewById(R.id.editTextText21);
        editTextText22 = findViewById(R.id.editTextText22);
        editTextText23 = findViewById(R.id.editTextText23);
        editTextText24 = findViewById(R.id.editTextText24);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText19.setText(sharedPreferences.getString("userNumber19", ""));
        editTextText20.setText(sharedPreferences.getString("userNumber20", ""));
        editTextText21.setText(sharedPreferences.getString("userNumber21", ""));
        editTextText22.setText(sharedPreferences.getString("userNumber22", ""));
        editTextText23.setText(sharedPreferences.getString("userNumber23", ""));
        editTextText24.setText(sharedPreferences.getString("userNumber24", ""));

        // Setare acțiune pentru butonul de înapoi
        findViewById(R.id.backButton9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.backHomeButton31).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityG5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Ascultător de evenimente pentru a ascunde tastatura când se atinge în afara ei
        findViewById(R.id.activityRootView).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber19", editTextText19.getText().toString());
        editor.putString("userNumber20", editTextText20.getText().toString());
        editor.putString("userNumber21", editTextText21.getText().toString());
        editor.putString("userNumber22", editTextText22.getText().toString());
        editor.putString("userNumber23", editTextText23.getText().toString());
        editor.putString("userNumber24", editTextText24.getText().toString());
        editor.apply();
    }

    // Metodă pentru ascunderea tastaturii
    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = getCurrentFocus();
        if (focusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }
}
