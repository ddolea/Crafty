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


public class ActivityG6 extends AppCompatActivity {

    public EditText editTextText25;
    public EditText editTextText26;
    public EditText editTextText27;
    public EditText editTextText28;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g6layout);

        // Inițializare EditText-uri
        editTextText25 = findViewById(R.id.editTextText25);
        editTextText26 = findViewById(R.id.editTextText26);
        editTextText27 = findViewById(R.id.editTextText27);
        editTextText28 = findViewById(R.id.editTextText28);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText25.setText(sharedPreferences.getString("userNumber25", ""));
        editTextText26.setText(sharedPreferences.getString("userNumber26", ""));
        editTextText27.setText(sharedPreferences.getString("userNumber27", ""));
        editTextText28.setText(sharedPreferences.getString("userNumber28", ""));

        // Setare acțiune pentru butonul de înapoi
        findViewById(R.id.backButton18).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.backHomeButton23).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityG6.this, MainActivity.class);
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
        editor.putString("userNumber25", editTextText25.getText().toString());
        editor.putString("userNumber26", editTextText26.getText().toString());
        editor.putString("userNumber27", editTextText27.getText().toString());
        editor.putString("userNumber28", editTextText28.getText().toString());
        editor.apply();
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
