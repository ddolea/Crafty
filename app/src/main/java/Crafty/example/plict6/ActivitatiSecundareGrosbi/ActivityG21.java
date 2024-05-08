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

public class ActivityG21 extends AppCompatActivity {

    public EditText editTextText77;
    public EditText editTextText78;
    public EditText editTextText79;
    public EditText editTextText80;
    public EditText editTextText81;
    public EditText editTextText82;
    public EditText editTextText83;
    public EditText editTextText84;
    public EditText editTextText85;
    public EditText editTextText86;
    public EditText editTextText87;
    public EditText editTextText88;
    public EditText editTextText89;
    public EditText editTextText90;
    public EditText editTextText91;

    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g21layout);

        // Inițializare EditText-uri
        editTextText77 = findViewById(R.id.editTextText77);
        editTextText78 = findViewById(R.id.editTextText78);
        editTextText79 = findViewById(R.id.editTextText79);
        editTextText80 = findViewById(R.id.editTextText80);
        editTextText81 = findViewById(R.id.editTextText81);
        editTextText82 = findViewById(R.id.editTextText82);
        editTextText83 = findViewById(R.id.editTextText83);
        editTextText84 = findViewById(R.id.editTextText84);
        editTextText85 = findViewById(R.id.editTextText85);
        editTextText86 = findViewById(R.id.editTextText86);
        editTextText87 = findViewById(R.id.editTextText87);
        editTextText88 = findViewById(R.id.editTextText88);
        editTextText89 = findViewById(R.id.editTextText89);
        editTextText90 = findViewById(R.id.editTextText90);
        editTextText91 = findViewById(R.id.editTextText91);

        // Setare acțiune pentru butonul de înapoi
        findViewById(R.id.backButton17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Setare acțiune pentru butonul de revenire la activitatea principală
        findViewById(R.id.backHomeButton22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityG21.this, MainActivity.class);
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

        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText77.setText(sharedPreferences.getString("userNumber77", ""));
        editTextText78.setText(sharedPreferences.getString("userNumber78", ""));
        editTextText79.setText(sharedPreferences.getString("userNumber79", ""));
        editTextText80.setText(sharedPreferences.getString("userNumber80", ""));
        editTextText81.setText(sharedPreferences.getString("userNumber81", ""));
        editTextText82.setText(sharedPreferences.getString("userNumber82", ""));
        editTextText83.setText(sharedPreferences.getString("userNumber83", ""));
        editTextText84.setText(sharedPreferences.getString("userNumber84", ""));
        editTextText85.setText(sharedPreferences.getString("userNumber85", ""));
        editTextText86.setText(sharedPreferences.getString("userNumber86", ""));
        editTextText87.setText(sharedPreferences.getString("userNumber87", ""));
        editTextText88.setText(sharedPreferences.getString("userNumber88", ""));
        editTextText89.setText(sharedPreferences.getString("userNumber89", ""));
        editTextText90.setText(sharedPreferences.getString("userNumber90", ""));
        editTextText91.setText(sharedPreferences.getString("userNumber91", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber77", editTextText77.getText().toString());
        editor.putString("userNumber78", editTextText78.getText().toString());
        editor.putString("userNumber79", editTextText79.getText().toString());
        editor.putString("userNumber80", editTextText80.getText().toString());
        editor.putString("userNumber81", editTextText81.getText().toString());
        editor.putString("userNumber82", editTextText82.getText().toString());
        editor.putString("userNumber83", editTextText83.getText().toString());
        editor.putString("userNumber84", editTextText84.getText().toString());
        editor.putString("userNumber85", editTextText85.getText().toString());
        editor.putString("userNumber86", editTextText86.getText().toString());
        editor.putString("userNumber87", editTextText87.getText().toString());
        editor.putString("userNumber88", editTextText88.getText().toString());
        editor.putString("userNumber89", editTextText89.getText().toString());
        editor.putString("userNumber90", editTextText90.getText().toString());
        editor.putString("userNumber91", editTextText91.getText().toString());

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
