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

public class ActivityG18 extends AppCompatActivity {

    public EditText editTextText73;
    public EditText editTextText74;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_TEXT_73 = "userNumber73";
    private static final String KEY_TEXT_74 = "userNumber74";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g18layout);

        // Inițializare EditText-uri
        editTextText73 = findViewById(R.id.editTextText73);
        editTextText74 = findViewById(R.id.editTextText74);

        // Restaurare text din SharedPreferences și afișare în EditText
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText73.setText(sharedPreferences.getString(KEY_TEXT_73, ""));
        editTextText74.setText(sharedPreferences.getString(KEY_TEXT_74, ""));

        // Setare acțiune pentru butonul de înapoi
        findViewById(R.id.backButton20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.backHomeButton25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityG18.this, MainActivity.class);
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
        editor.putString(KEY_TEXT_73, editTextText73.getText().toString());
        editor.putString(KEY_TEXT_74, editTextText74.getText().toString());
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
