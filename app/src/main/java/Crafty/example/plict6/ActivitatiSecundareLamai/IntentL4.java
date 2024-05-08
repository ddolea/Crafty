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

public class IntentL4 extends AppCompatActivity {

    public EditText editTextText132;
    public EditText editTextText133;
    private Button button1;
    private Button button2;
    private static final String PREFS_NAME = "MyPrefs";

    private static final String USER_NUMBER_132 = "userNumber132";
    private static final String USER_NUMBER_133 = "userNumber133";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutl4);

        editTextText132 = findViewById(R.id.editTextText132);
        editTextText133 = findViewById(R.id.editTextText133);

        button1 = findViewById(R.id.backButton6);
        button2 = findViewById(R.id.backHomeButton6);

        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(IntentL4.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });

        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText132.setText(sharedPreferences.getString(USER_NUMBER_132, ""));
        editTextText133.setText(sharedPreferences.getString(USER_NUMBER_133, ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(USER_NUMBER_132, editTextText132.getText().toString());
        editor.putString(USER_NUMBER_133, editTextText133.getText().toString());
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
