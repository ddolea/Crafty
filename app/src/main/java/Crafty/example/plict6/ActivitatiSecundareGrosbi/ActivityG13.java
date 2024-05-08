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

public class ActivityG13 extends AppCompatActivity {

    public EditText editTextText60;
    public EditText editTextText61;
    public EditText editTextText62;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_TEXT_60 = "userNumber60";
    private static final String KEY_TEXT_61 = "userNumber61";
    private static final String KEY_TEXT_62 = "userNumber62";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g13layout);

        // Inițializare EditText-uri
        editTextText60 = findViewById(R.id.editTextText60);
        editTextText61 = findViewById(R.id.editTextText61);
        editTextText62 = findViewById(R.id.editTextText62);

        // Restaurare text din SharedPreferences și afișare în EditText
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText60.setText(sharedPreferences.getString(KEY_TEXT_60, ""));
        editTextText61.setText(sharedPreferences.getString(KEY_TEXT_61, ""));
        editTextText62.setText(sharedPreferences.getString(KEY_TEXT_62, ""));

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
                Intent intent = new Intent(ActivityG13.this, MainActivity.class);
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
        editor.putString(KEY_TEXT_60, editTextText60.getText().toString());
        editor.putString(KEY_TEXT_61, editTextText61.getText().toString());
        editor.putString(KEY_TEXT_62, editTextText62.getText().toString());
        editor.apply(); // Salvarea efectivă a modificărilor în SharedPreferences
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
