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


public class ActivityG9 extends AppCompatActivity {

    public EditText editTextText34;
    public EditText editTextText35;
    public EditText editTextText36;
    public EditText editTextText37;
    public EditText editTextText38;
    public EditText editTextText39;
    public EditText editTextText40; // Adăugarea editTextText40

    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g9layout);

        // Inițializare EditText-uri
        editTextText34 = findViewById(R.id.editTextText34);
        editTextText35 = findViewById(R.id.editTextText35);
        editTextText36 = findViewById(R.id.editTextText36);
        editTextText37 = findViewById(R.id.editTextText37);
        editTextText38 = findViewById(R.id.editTextText38);
        editTextText39 = findViewById(R.id.editTextText39);
        editTextText40 = findViewById(R.id.editTextText40); // Inițializare editTextText40
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText34.setText(sharedPreferences.getString("userNumber34", ""));
        editTextText35.setText(sharedPreferences.getString("userNumber35", ""));
        editTextText36.setText(sharedPreferences.getString("userNumber36", ""));
        editTextText37.setText(sharedPreferences.getString("userNumber37", ""));
        editTextText38.setText(sharedPreferences.getString("userNumber38", ""));
        editTextText39.setText(sharedPreferences.getString("userNumber39", ""));
        editTextText40.setText(sharedPreferences.getString("userNumber40", "")); // Setarea textului pentru editTextText40

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
                Intent intent = new Intent(ActivityG9.this, MainActivity.class);
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
        editor.putString("userNumber34", editTextText34.getText().toString());
        editor.putString("userNumber35", editTextText35.getText().toString());
        editor.putString("userNumber36", editTextText36.getText().toString());
        editor.putString("userNumber37", editTextText37.getText().toString());
        editor.putString("userNumber38", editTextText38.getText().toString());
        editor.putString("userNumber39", editTextText39.getText().toString());
        editor.putString("userNumber40", editTextText40.getText().toString()); // Salvarea textului pentru editTextText40
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
