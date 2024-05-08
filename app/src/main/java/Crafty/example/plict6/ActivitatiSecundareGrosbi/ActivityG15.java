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

public class ActivityG15 extends AppCompatActivity {

    public EditText editTextText65;
    public EditText editTextText66;
    public EditText editTextText67;
    public EditText editTextText68;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_TEXT_65 = "userNumber65";
    private static final String KEY_TEXT_66 = "userNumber66";
    private static final String KEY_TEXT_67 = "userNumber67";
    private static final String KEY_TEXT_68 = "userNumber68";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g15layout);

        // Inițializare EditText-uri
        editTextText65 = findViewById(R.id.editTextText65);
        editTextText66 = findViewById(R.id.editTextText66);
        editTextText67 = findViewById(R.id.editTextText67);
        editTextText68 = findViewById(R.id.editTextText68);

        // Restaurare text din SharedPreferences și afișare în EditText
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText65.setText(sharedPreferences.getString(KEY_TEXT_65, ""));
        editTextText66.setText(sharedPreferences.getString(KEY_TEXT_66, ""));
        editTextText67.setText(sharedPreferences.getString(KEY_TEXT_67, ""));
        editTextText68.setText(sharedPreferences.getString(KEY_TEXT_68, ""));

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
                Intent intent = new Intent(ActivityG15.this, MainActivity.class);
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
        editor.putString(KEY_TEXT_65, editTextText65.getText().toString());
        editor.putString(KEY_TEXT_66, editTextText66.getText().toString());
        editor.putString(KEY_TEXT_67, editTextText67.getText().toString());
        editor.putString(KEY_TEXT_68, editTextText68.getText().toString());
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
