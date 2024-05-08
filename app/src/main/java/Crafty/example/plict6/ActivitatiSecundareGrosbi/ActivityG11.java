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


public class ActivityG11 extends AppCompatActivity {

    public EditText editTextText44;
    public EditText editTextText45;
    public EditText editTextText46;
    public EditText editTextText47;
    public EditText editTextText48;
    public EditText editTextText49;
    public EditText editTextText50;

    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g11layout);

        // Inițializare EditText-uri
        editTextText44 = findViewById(R.id.editTextText44);
        editTextText45 = findViewById(R.id.editTextText45);
        editTextText46 = findViewById(R.id.editTextText46);
        editTextText47 = findViewById(R.id.editTextText47);
        editTextText48 = findViewById(R.id.editTextText48);
        editTextText49 = findViewById(R.id.editTextText49);
        editTextText50 = findViewById(R.id.editTextText50);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText44.setText(sharedPreferences.getString("userNumber44", ""));
        editTextText45.setText(sharedPreferences.getString("userNumber45", ""));
        editTextText46.setText(sharedPreferences.getString("userNumber46", ""));
        editTextText47.setText(sharedPreferences.getString("userNumber47", ""));
        editTextText48.setText(sharedPreferences.getString("userNumber48", ""));
        editTextText49.setText(sharedPreferences.getString("userNumber49", ""));
        editTextText50.setText(sharedPreferences.getString("userNumber50", ""));

        // Setare acțiune pentru butonul de înapoi
        findViewById(R.id.backButton19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.backHomeButton24).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityG11.this, MainActivity.class);
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
        editor.putString("userNumber44", editTextText44.getText().toString());
        editor.putString("userNumber45", editTextText45.getText().toString());
        editor.putString("userNumber46", editTextText46.getText().toString());
        editor.putString("userNumber47", editTextText47.getText().toString());
        editor.putString("userNumber48", editTextText48.getText().toString());
        editor.putString("userNumber49", editTextText49.getText().toString());
        editor.putString("userNumber50", editTextText50.getText().toString());
        editor.apply(); // Salvarea efectivă a modificărilor în SharedPreferences
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
