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


public class ActivityG3 extends AppCompatActivity {

    public EditText editTextText8;
    public EditText editTextText9;
    public EditText editTextText10;
    public EditText editTextText11;
    public EditText editTextText12;
    public EditText editTextText13;
    public EditText editTextText14;
    public EditText editTextText15;
    public EditText editTextText16;
    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g3layout);

        // Inițializare EditText-uri
        editTextText8 = findViewById(R.id.editTextText8);
        editTextText9 = findViewById(R.id.editTextText9);
        editTextText10 = findViewById(R.id.editTextText10);
        editTextText11 = findViewById(R.id.editTextText11);
        editTextText12 = findViewById(R.id.editTextText12);
        editTextText13 = findViewById(R.id.editTextText13);
        editTextText14 = findViewById(R.id.editTextText14);
        editTextText15 = findViewById(R.id.editTextText15);
        editTextText16 = findViewById(R.id.editTextText16);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText8.setText(sharedPreferences.getString("userNumber8", ""));
        editTextText9.setText(sharedPreferences.getString("userNumber9", ""));
        editTextText10.setText(sharedPreferences.getString("userNumber10", ""));
        editTextText11.setText(sharedPreferences.getString("userNumber11", ""));
        editTextText12.setText(sharedPreferences.getString("userNumber12", ""));
        editTextText13.setText(sharedPreferences.getString("userNumber13", ""));
        editTextText14.setText(sharedPreferences.getString("userNumber14", ""));
        editTextText15.setText(sharedPreferences.getString("userNumber15", ""));
        editTextText16.setText(sharedPreferences.getString("userNumber16", ""));

        // Setare acțiune pentru butonul de înapoi
        findViewById(R.id.backButton19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.backHomeButton24).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityG3.this, MainActivity.class);
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
        editor.putString("userNumber8", editTextText8.getText().toString());
        editor.putString("userNumber9", editTextText9.getText().toString());
        editor.putString("userNumber10", editTextText10.getText().toString());
        editor.putString("userNumber11", editTextText11.getText().toString());
        editor.putString("userNumber12", editTextText12.getText().toString());
        editor.putString("userNumber13", editTextText13.getText().toString());
        editor.putString("userNumber14", editTextText14.getText().toString());
        editor.putString("userNumber15", editTextText15.getText().toString());
        editor.putString("userNumber16", editTextText16.getText().toString());
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
