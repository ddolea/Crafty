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

public class ActivityV1 extends AppCompatActivity {

    private EditText editTextText139;
    private EditText editTextText140;
    private EditText editTextText141;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutv1);

        editTextText139 = findViewById(R.id.editTextText139);
        editTextText140 = findViewById(R.id.editTextText140);
        editTextText141 = findViewById(R.id.editTextText141);

        findViewById(R.id.backButton10).setOnClickListener(v -> onBackPressed());
        findViewById(R.id.backHomeButton32).setOnClickListener(v -> {
            Intent intent = new Intent(ActivityV1.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText139.setText(sharedPreferences.getString("userNumber139", ""));
        editTextText140.setText(sharedPreferences.getString("userNumber140", ""));
        editTextText141.setText(sharedPreferences.getString("userNumber141", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber139", editTextText139.getText().toString());
        editor.putString("userNumber140", editTextText140.getText().toString());
        editor.putString("userNumber141", editTextText141.getText().toString());
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
