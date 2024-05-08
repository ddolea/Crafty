package Crafty.example.plict6.ActivitatiSecundareLamai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;

public class IntentL2 extends AppCompatActivity {

    public EditText editTextText116;
    public EditText editTextText117;
    public EditText editTextText118;
    public EditText editTextText119;
    public EditText editTextText120;
    public EditText editTextText121;
    public EditText editTextText122;
    public EditText editTextText123;
    public EditText editTextText124;
    public EditText editTextText125;
    public EditText editTextText126;
    private Button button1;
    private Button button2;
    private static final String PREFS_NAME = "MyPrefs";

    private static final String USER_NUMBER_116 = "userNumber116";
    private static final String USER_NUMBER_117 = "userNumber117";
    private static final String USER_NUMBER_118 = "userNumber118";
    private static final String USER_NUMBER_119 = "userNumber119";
    private static final String USER_NUMBER_120 = "userNumber120";
    private static final String USER_NUMBER_121 = "userNumber121";
    private static final String USER_NUMBER_122 = "userNumber122";
    private static final String USER_NUMBER_123 = "userNumber123";
    private static final String USER_NUMBER_124 = "userNumber124";
    private static final String USER_NUMBER_125 = "userNumber125";
    private static final String USER_NUMBER_126 = "userNumber126";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutl2);

        editTextText116 = findViewById(R.id.editTextText116);
        editTextText117 = findViewById(R.id.editTextText117);
        editTextText118 = findViewById(R.id.editTextText118);
        editTextText119 = findViewById(R.id.editTextText119);
        editTextText120 = findViewById(R.id.editTextText120);
        editTextText121 = findViewById(R.id.editTextText121);
        editTextText122 = findViewById(R.id.editTextText122);
        editTextText123 = findViewById(R.id.editTextText123);
        editTextText124 = findViewById(R.id.editTextText124);
        editTextText125 = findViewById(R.id.editTextText125);
        editTextText126 = findViewById(R.id.editTextText126);

        button1 = findViewById(R.id.backButton4);
        button2 = findViewById(R.id.backHomeButton4);

        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(IntentL2.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.activityRootView).setOnTouchListener((v, event) -> {
            hideKeyboard();
            return false;
        });

        // Restaurarea datelor salvate
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextText116.setText(sharedPreferences.getString(USER_NUMBER_116, ""));
        editTextText117.setText(sharedPreferences.getString(USER_NUMBER_117, ""));
        editTextText118.setText(sharedPreferences.getString(USER_NUMBER_118, ""));
        editTextText119.setText(sharedPreferences.getString(USER_NUMBER_119, ""));
        editTextText120.setText(sharedPreferences.getString(USER_NUMBER_120, ""));
        editTextText121.setText(sharedPreferences.getString(USER_NUMBER_121, ""));
        editTextText122.setText(sharedPreferences.getString(USER_NUMBER_122, ""));
        editTextText123.setText(sharedPreferences.getString(USER_NUMBER_123, ""));
        editTextText124.setText(sharedPreferences.getString(USER_NUMBER_124, ""));
        editTextText125.setText(sharedPreferences.getString(USER_NUMBER_125, ""));
        editTextText126.setText(sharedPreferences.getString(USER_NUMBER_126, ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(USER_NUMBER_116, editTextText116.getText().toString());
        editor.putString(USER_NUMBER_117, editTextText117.getText().toString());
        editor.putString(USER_NUMBER_118, editTextText118.getText().toString());
        editor.putString(USER_NUMBER_119, editTextText119.getText().toString());
        editor.putString(USER_NUMBER_120, editTextText120.getText().toString());
        editor.putString(USER_NUMBER_121, editTextText121.getText().toString());
        editor.putString(USER_NUMBER_122, editTextText122.getText().toString());
        editor.putString(USER_NUMBER_123, editTextText123.getText().toString());
        editor.putString(USER_NUMBER_124, editTextText124.getText().toString());
        editor.putString(USER_NUMBER_125, editTextText125.getText().toString());
        editor.putString(USER_NUMBER_126, editTextText126.getText().toString());
        editor.apply();
    }

    private void hideKeyboard() {
        if (getApplicationContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            View focusedView = getCurrentFocus();
            if (focusedView != null) {
                inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
            }
        }
    }
}
