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

public class IntentL3 extends AppCompatActivity {

    public EditText editTextText127;
    public EditText editTextText128;
    public EditText editTextText129;
    public EditText editTextText130;
    public EditText editTextText131;
    private Button button1;
    private Button button2;
    private static final String PREFS_NAME = "MyPrefs";

    private static final String USER_NUMBER_127 = "userNumber127";
    private static final String USER_NUMBER_128 = "userNumber128";
    private static final String USER_NUMBER_129 = "userNumber129";
    private static final String USER_NUMBER_130 = "userNumber130";
    private static final String USER_NUMBER_131 = "userNumber131";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutl3);

        editTextText127 = findViewById(R.id.editTextText127);
        editTextText128 = findViewById(R.id.editTextText128);
        editTextText129 = findViewById(R.id.editTextText129);
        editTextText130 = findViewById(R.id.editTextText130);
        editTextText131 = findViewById(R.id.editTextText131);

        button1 = findViewById(R.id.backButton5);
        button2 = findViewById(R.id.backHomeButton5);

        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(IntentL3.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });

        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText127.setText(sharedPreferences.getString(USER_NUMBER_127, ""));
        editTextText128.setText(sharedPreferences.getString(USER_NUMBER_128, ""));
        editTextText129.setText(sharedPreferences.getString(USER_NUMBER_129, ""));
        editTextText130.setText(sharedPreferences.getString(USER_NUMBER_130, ""));
        editTextText131.setText(sharedPreferences.getString(USER_NUMBER_131, ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(USER_NUMBER_127, editTextText127.getText().toString());
        editor.putString(USER_NUMBER_128, editTextText128.getText().toString());
        editor.putString(USER_NUMBER_129, editTextText129.getText().toString());
        editor.putString(USER_NUMBER_130, editTextText130.getText().toString());
        editor.putString(USER_NUMBER_131, editTextText131.getText().toString());
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
