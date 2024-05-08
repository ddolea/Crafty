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

public class ActivityV5 extends AppCompatActivity {

    private EditText editTextText148;
    private EditText editTextText149;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutv5);

        editTextText148 = findViewById(R.id.editTextText148);
        editTextText149 = findViewById(R.id.editTextText149);

        findViewById(R.id.backButton15).setOnClickListener(v -> onBackPressed());
        findViewById(R.id.backHomeButton36).setOnClickListener(v -> {
            Intent intent = new Intent(ActivityV5.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText148.setText(sharedPreferences.getString("userNumber148", ""));
        editTextText149.setText(sharedPreferences.getString("userNumber149", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber148", editTextText148.getText().toString());
        editor.putString("userNumber149", editTextText149.getText().toString());
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
