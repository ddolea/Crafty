package Crafty.example.plict6.ActivitatiSecundareLamai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;


public class IntentL0 extends AppCompatActivity {

    private EditText editTextText109;
    private EditText editTextText110;
    private EditText editTextText111;
    private Button button1;
    private Button button2;
    private static final String PREFS_NAME = "MyPrefs";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutl0);

        editTextText109 = findViewById(R.id.editTextText109);
        editTextText110 = findViewById(R.id.editTextText110);
        editTextText111 = findViewById(R.id.editTextText111);

        button1 = findViewById(R.id.backButton2);
        button2 = findViewById(R.id.backHomeButton2);

        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(IntentL0.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });
        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText109.setText(sharedPreferences.getString("userNumber109", ""));
        editTextText110.setText(sharedPreferences.getString("userNumber110", ""));
        editTextText111.setText(sharedPreferences.getString("userNumber111", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber109", editTextText109.getText().toString());
        editor.putString("userNumber110", editTextText110.getText().toString());
        editor.putString("userNumber111", editTextText111.getText().toString());
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
}
