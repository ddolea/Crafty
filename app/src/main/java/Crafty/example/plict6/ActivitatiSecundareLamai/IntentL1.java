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

public class IntentL1 extends AppCompatActivity {

    public EditText editTextText112;
    public EditText editTextText113;
    public EditText editTextText114;
    public EditText editTextText115;
    private Button button1;
    private Button button2;
    private static final String PREFS_NAME = "MyPrefs";

    private static final String USER_NUMBER_112 = "userNumber112";
    private static final String USER_NUMBER_113 = "userNumber113";
    private static final String USER_NUMBER_114 = "userNumber114";
    private static final String USER_NUMBER_115 = "userNumber115";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutl1);

        editTextText112 = findViewById(R.id.editTextText112);
        editTextText113 = findViewById(R.id.editTextText113);
        editTextText114 = findViewById(R.id.editTextText114);
        editTextText115 = findViewById(R.id.editTextText115);

        button1 = findViewById(R.id.backButton3);
        button2 = findViewById(R.id.backHomeButton3);

        button2.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(IntentL1.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });

        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText112.setText(sharedPreferences.getString(USER_NUMBER_112, ""));
        editTextText113.setText(sharedPreferences.getString(USER_NUMBER_113, ""));
        editTextText114.setText(sharedPreferences.getString(USER_NUMBER_114, ""));
        editTextText115.setText(sharedPreferences.getString(USER_NUMBER_115, ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(USER_NUMBER_112, editTextText112.getText().toString());
        editor.putString(USER_NUMBER_113, editTextText113.getText().toString());
        editor.putString(USER_NUMBER_114, editTextText114.getText().toString());
        editor.putString(USER_NUMBER_115, editTextText115.getText().toString());
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
