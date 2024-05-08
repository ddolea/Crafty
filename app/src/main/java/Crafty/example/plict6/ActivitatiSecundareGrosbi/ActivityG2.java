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


public class ActivityG2 extends AppCompatActivity {

    public EditText editTextText4;
    public EditText editTextText5;
    public EditText editTextText6;
    public EditText editTextText7;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g2layout);

        editTextText4 = findViewById(R.id.editTextText4);
        editTextText5 = findViewById(R.id.editTextText5);
        editTextText6 = findViewById(R.id.editTextText6);
        editTextText7 = findViewById(R.id.editTextText7);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText4.setText(sharedPreferences.getString("userNumber4", ""));
        editTextText5.setText(sharedPreferences.getString("userNumber5", ""));
        editTextText6.setText(sharedPreferences.getString("userNumber6", ""));
        editTextText7.setText(sharedPreferences.getString("userNumber7", ""));

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
                Intent intent = new Intent(ActivityG2.this, MainActivity.class);
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
        editor.putString("userNumber4", editTextText4.getText().toString());
        editor.putString("userNumber5", editTextText5.getText().toString());
        editor.putString("userNumber6", editTextText6.getText().toString());
        editor.putString("userNumber7", editTextText7.getText().toString());
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
