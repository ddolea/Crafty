package Crafty.example.plict6.ActivitatiSecundareVinuri;

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

public class ActivityV0 extends AppCompatActivity {


    public EditText editTextText134;
    public EditText editTextText135;
    public EditText editTextText136;
    public EditText editTextText137;
    public EditText editTextText138;
    private static final String PREFS_NAME = "MyPrefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutv0);

        // Inițializare EditText-uri

        editTextText134 = findViewById(R.id.editTextText134);
        editTextText135 = findViewById(R.id.editTextText135);
        editTextText136 = findViewById(R.id.editTextText136);
        editTextText137 = findViewById(R.id.editTextText137);
        editTextText138 = findViewById(R.id.editTextText138);



        // Setare acțiune pentru butonul de înapoi
        findViewById(R.id.backButton9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.backHomeButton31).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityV0.this, MainActivity.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText134.setText(sharedPreferences.getString("userNumber134", ""));
        editTextText135.setText(sharedPreferences.getString("userNumber135", ""));
        editTextText136.setText(sharedPreferences.getString("userNumber136", ""));
        editTextText137.setText(sharedPreferences.getString("userNumber137", ""));
        editTextText138.setText(sharedPreferences.getString("userNumber138", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("userNumber134", editTextText134.getText().toString());
        editor.putString("userNumber135", editTextText135.getText().toString());
        editor.putString("userNumber136", editTextText136.getText().toString());
        editor.putString("userNumber137", editTextText137.getText().toString());
        editor.putString("userNumber138", editTextText138.getText().toString());

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
