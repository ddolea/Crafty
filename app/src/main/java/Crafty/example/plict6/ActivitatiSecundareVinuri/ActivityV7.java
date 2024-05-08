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

public class ActivityV7 extends AppCompatActivity {

    private EditText editTextText152;
    private EditText editTextText153;
    private EditText editTextText154;
    private EditText editTextText155;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutv7);

        editTextText152 = findViewById(R.id.editTextText152);
        editTextText153 = findViewById(R.id.editTextText153);
        editTextText154 = findViewById(R.id.editTextText154);
        editTextText155 = findViewById(R.id.editTextText155);

        findViewById(R.id.backButton10).setOnClickListener(v -> onBackPressed());
        findViewById(R.id.backHomeButton32).setOnClickListener(v -> {
            Intent intent = new Intent(ActivityV7.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText152.setText(sharedPreferences.getString("userNumber152", ""));
        editTextText153.setText(sharedPreferences.getString("userNumber153", ""));
        editTextText154.setText(sharedPreferences.getString("userNumber154", ""));
        editTextText155.setText(sharedPreferences.getString("userNumber155", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber152", editTextText152.getText().toString());
        editor.putString("userNumber153", editTextText153.getText().toString());
        editor.putString("userNumber154", editTextText154.getText().toString());
        editor.putString("userNumber155", editTextText155.getText().toString());
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
