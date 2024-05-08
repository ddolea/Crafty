package Crafty.example.plict6.ActivitatiSecundareVinuri;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;

public class ActivityV8 extends AppCompatActivity {

    private EditText editTextText156;
    private EditText editTextText157;
    private EditText editTextText158;
    private EditText editTextText159;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutv8);

        editTextText156 = findViewById(R.id.editTextText156);
        editTextText157 = findViewById(R.id.editTextText157);
        editTextText158 = findViewById(R.id.editTextText158);
        editTextText159 = findViewById(R.id.editTextText159);

        findViewById(R.id.backButton99).setOnClickListener(v -> onBackPressed());
        findViewById(R.id.backHomeButton40).setOnClickListener(v -> {
            Intent intent = new Intent(ActivityV8.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText156.setText(sharedPreferences.getString("userNumber156", ""));
        editTextText157.setText(sharedPreferences.getString("userNumber157", ""));
        editTextText158.setText(sharedPreferences.getString("userNumber158", ""));
        editTextText159.setText(sharedPreferences.getString("userNumber159", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber156", editTextText156.getText().toString());
        editor.putString("userNumber157", editTextText157.getText().toString());
        editor.putString("userNumber158", editTextText158.getText().toString());
        editor.putString("userNumber159", editTextText159.getText().toString());
        editor.apply();
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = getCurrentFocus();
        if (focusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }
}
