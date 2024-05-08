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

public class ActivityG12 extends AppCompatActivity {

    public EditText editTextText51;
    public EditText editTextText52;
    public EditText editTextText53;
    public EditText editTextText54;
    public EditText editTextText55;
    public EditText editTextText56;
    public EditText editTextText57;
    public EditText editTextText58;
    public EditText editTextText59;

    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g12layout);

        // Inițializare EditText-uri
        editTextText51 = findViewById(R.id.editTextText51);
        editTextText52 = findViewById(R.id.editTextText52);
        editTextText53 = findViewById(R.id.editTextText53);
        editTextText54 = findViewById(R.id.editTextText54);
        editTextText55 = findViewById(R.id.editTextText55);
        editTextText56 = findViewById(R.id.editTextText56);
        editTextText57 = findViewById(R.id.editTextText57);
        editTextText58 = findViewById(R.id.editTextText58);
        editTextText59 = findViewById(R.id.editTextText59);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText51.setText(sharedPreferences.getString("userNumber51", ""));
        editTextText52.setText(sharedPreferences.getString("userNumber52", ""));
        editTextText53.setText(sharedPreferences.getString("userNumber53", ""));
        editTextText54.setText(sharedPreferences.getString("userNumber54", ""));
        editTextText55.setText(sharedPreferences.getString("userNumber55", ""));
        editTextText56.setText(sharedPreferences.getString("userNumber56", ""));
        editTextText57.setText(sharedPreferences.getString("userNumber57", ""));
        editTextText58.setText(sharedPreferences.getString("userNumber58", ""));
        editTextText59.setText(sharedPreferences.getString("userNumber59", ""));

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
                Intent intent = new Intent(ActivityG12.this, MainActivity.class);
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
        editor.putString("userNumber51", editTextText51.getText().toString());
        editor.putString("userNumber52", editTextText52.getText().toString());
        editor.putString("userNumber53", editTextText53.getText().toString());
        editor.putString("userNumber54", editTextText54.getText().toString());
        editor.putString("userNumber55", editTextText55.getText().toString());
        editor.putString("userNumber56", editTextText56.getText().toString());
        editor.putString("userNumber57", editTextText57.getText().toString());
        editor.putString("userNumber58", editTextText58.getText().toString());
        editor.putString("userNumber59", editTextText59.getText().toString());
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
