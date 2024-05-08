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


public class ActivityG1 extends AppCompatActivity {

    public EditText editTextText94, editTextText95, editTextText96, editTextText97, editTextText98, editTextText99,
            editTextText100, editTextText101, editTextText102, editTextText103, editTextText104, editTextText105,
            editTextText106, editTextText107, editTextText108;

    private static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g1layout);

        editTextText94 = findViewById(R.id.editTextText94);
        editTextText95 = findViewById(R.id.editTextText95);
        editTextText96 = findViewById(R.id.editTextText96);
        editTextText97 = findViewById(R.id.editTextText97);
        editTextText98 = findViewById(R.id.editTextText98);
        editTextText99 = findViewById(R.id.editTextText99);
        editTextText100 = findViewById(R.id.editTextText100);
        editTextText101 = findViewById(R.id.editTextText101);
        editTextText102 = findViewById(R.id.editTextText102);
        editTextText103 = findViewById(R.id.editTextText103);
        editTextText104 = findViewById(R.id.editTextText104);
        editTextText105 = findViewById(R.id.editTextText105);
        editTextText106 = findViewById(R.id.editTextText106);
        editTextText107 = findViewById(R.id.editTextText199);
        editTextText108 = findViewById(R.id.editTextText108);

        SharedPreferences sharedPreferences=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        editTextText94.setText(sharedPreferences.getString("userNumber94",""));
        editTextText95.setText(sharedPreferences.getString("userNumber95",""));
        editTextText96.setText(sharedPreferences.getString("userNumber96",""));
        editTextText97.setText(sharedPreferences.getString("userNumber97",""));
        editTextText98.setText(sharedPreferences.getString("userNumber98",""));
        editTextText99.setText(sharedPreferences.getString("userNumber99",""));
        editTextText100.setText(sharedPreferences.getString("userNumber100",""));
        editTextText101.setText(sharedPreferences.getString("userNumber101",""));
        editTextText102.setText(sharedPreferences.getString("userNumber102",""));
        editTextText103.setText(sharedPreferences.getString("userNumber103",""));
        editTextText104.setText(sharedPreferences.getString("userNumber104",""));
        editTextText105.setText(sharedPreferences.getString("userNumber105",""));
        editTextText106.setText(sharedPreferences.getString("userNumber106",""));
        editTextText107.setText(sharedPreferences.getString("userNumber107",""));
        editTextText108.setText(sharedPreferences.getString("userNumber108",""));

        // Set action for back button
        findViewById(R.id.backButton17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Set action for back home button
        findViewById(R.id.backHomeButton22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityG1.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set listener for hiding keyboard when touched outside
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
        SharedPreferences.Editor editor=getSharedPreferences(PREFS_NAME,MODE_PRIVATE).edit();
        editor.putString("userNumber94",editTextText94.getText().toString());
        editor.putString("userNumber95",editTextText95.getText().toString());
        editor.putString("userNumber96",editTextText96.getText().toString());
        editor.putString("userNumber97",editTextText97.getText().toString());
        editor.putString("userNumber98",editTextText98.getText().toString());
        editor.putString("userNumber99",editTextText99.getText().toString());
        editor.putString("userNumber100",editTextText100.getText().toString());
        editor.putString("userNumber101",editTextText101.getText().toString());
        editor.putString("userNumber102",editTextText102.getText().toString());
        editor.putString("userNumber103",editTextText103.getText().toString());
        editor.putString("userNumber104",editTextText104.getText().toString());
        editor.putString("userNumber105",editTextText105.getText().toString());
        editor.putString("userNumber106",editTextText106.getText().toString());
        editor.putString("userNumber107",editTextText107.getText().toString());
        editor.putString("userNumber108",editTextText108.getText().toString());
        editor.apply();
    }

    // Method for hiding keyboard
    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = getCurrentFocus();
        if (focusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }
}
