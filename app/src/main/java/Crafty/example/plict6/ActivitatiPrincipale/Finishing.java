package Crafty.example.plict6.ActivitatiPrincipale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;


public class Finishing extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefs";
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finishing);
textView2=findViewById(R.id.textView2);
textView1=findViewById(R.id.textView1);
textView3=findViewById(R.id.textView3);
textView4=findViewById(R.id.textView4);
button1=findViewById(R.id.backButton1);
button2=findViewById(R.id.backHomeButton2);
        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(Finishing.this, MainActivity.class);
            startActivity(intent);
        });
textView2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Finishing.this,ResultActivityGrosbi.class);
        startActivity(intent);
    }
});
textView1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(Finishing.this,ResultActivityNecesar.class);
        startActivity(intent);
    }
});
textView4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(Finishing.this,ResultActivityVinuri.class);
        startActivity(intent);
    }
});
textView3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Finishing.this, ResultActivityPepsi.class);
        startActivity(intent);
    }
});
    }
}
