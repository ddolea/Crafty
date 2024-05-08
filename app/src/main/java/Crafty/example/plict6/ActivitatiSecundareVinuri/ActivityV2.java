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

public class ActivityV2 extends AppCompatActivity {

    private EditText editTextText142;
    private EditText editTextText143;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutv2);

        editTextText142 = findViewById(R.id.editTextText142);
        editTextText143 = findViewById(R.id.editTextText143);

        findViewById(R.id.backButton15).setOnClickListener(v -> onBackPressed());
        findViewById(R.id.backHomeButton33).setOnClickListener(v -> {
            Intent intent = new Intent(ActivityV2.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText142.setText(sharedPreferences.getString("userNumber142", ""));
        editTextText143.setText(sharedPreferences.getString("userNumber143", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber142", editTextText142.getText().toString());
        editor.putString("userNumber143", editTextText143.getText().toString());
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
