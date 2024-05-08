package Crafty.example.plict6.ActivitatiPrincipale;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Crafty.example.plict6.MainActivity;
import Crafty.example.plict6.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultActivityPepsi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ProductData> productList;
    Button button1;
    Button button2;
    Button buttonCopy;



    private static final String PREFS_NAME = "MyPrefs";
    private static final String[] orderedProductNames = {

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pepsifinishing);

        recyclerView = findViewById(R.id.recyclerFinishPepsi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        getProductListFromSharedPreferences();
        setupRecyclerView();
        button1=findViewById(R.id.backButton1);
        button2=findViewById(R.id.backHomeButton2);
        buttonCopy=findViewById(R.id.copyButton);
        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivityPepsi.this, MainActivity.class);
            startActivity(intent);
        });
        buttonCopy.setOnClickListener(v -> {
            StringBuilder copiedData = new StringBuilder();

            for (ProductData product : productList) {
                copiedData.append(product.getProductName()).append(" - ").append(product.getQuantity()).append("\n");
            }

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Copied Data", copiedData.toString());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(ResultActivityPepsi.this, "Data copied to clipboard", Toast.LENGTH_SHORT).show();
        });

    }



    private void getProductListFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Map<String, String> productQuantities = new LinkedHashMap<>(); // Folosim LinkedHashMap pentru a păstra ordinea de inserare

        String pepsi0250SticlaQuantity = sharedPreferences.getString("userNumber162", "");
        String pepsiMax0250SticlaQuantity = sharedPreferences.getString("userNumber163", "");
        String pepsiTwist0250SticlaQuantity = sharedPreferences.getString("userNumber164", "");
        String pepsiVintage0250SticlaQuantity = sharedPreferences.getString("userNumber165", "");
        String mirinda0250SticlaQuantity = sharedPreferences.getString("userNumber166", "");
        String sevenUp0250SticlaQuantity = sharedPreferences.getString("userNumber167", "");
        String acquaCarpaticaPlata033Quantity = sharedPreferences.getString("userNumber168", "");
        String acquaCarpaticaMinerala033Quantity = sharedPreferences.getString("userNumber169", "");
        String acquaCarpaticaPlata15LPetQuantity = sharedPreferences.getString("userNumber170", "");
        String rockstar0250MlDozaQuantity = sharedPreferences.getString("userNumber171", "");
        String prigatKiwi0250SticlaQuantity = sharedPreferences.getString("userNumber172", "");
        String prigatCapsuneSiBanane0250SticlaQuantity = sharedPreferences.getString("userNumber173", "");
        String prigatPiersica0250SticlaQuantity = sharedPreferences.getString("userNumber174", "");
        String lipton0250SticlaQuantity = sharedPreferences.getString("userNumber175", "");
        String evervess0250SticlaQuantity = sharedPreferences.getString("userNumber176", "");


        if(!sevenUp0250SticlaQuantity.isEmpty() && Integer.parseInt(sevenUp0250SticlaQuantity)<15){
            productQuantities.put("7 Up 0.250 sticla", "1");
        }

        if(!acquaCarpaticaMinerala033Quantity.isEmpty() && Integer.parseInt(acquaCarpaticaMinerala033Quantity)<8){
            int n2= 8-Integer.parseInt(acquaCarpaticaMinerala033Quantity);
            productQuantities.put("Acqua Carpatica 0.33 minerala", String.valueOf(n2));
        }

        if(!acquaCarpaticaPlata033Quantity.isEmpty() && Integer.parseInt(acquaCarpaticaPlata033Quantity)<10){
            int n3=10-Integer.parseInt(acquaCarpaticaPlata033Quantity);
            productQuantities.put("Acqua Carpatica Plata 0.33", String.valueOf(n3));
        }
        if(!evervess0250SticlaQuantity.isEmpty() && Integer.parseInt(evervess0250SticlaQuantity)<4){
            int n4=4-Integer.parseInt(evervess0250SticlaQuantity);
            productQuantities.put("Evervess 0.250ml sticla", String.valueOf(n4));
        }

        if(!lipton0250SticlaQuantity.isEmpty() && Integer.parseInt(lipton0250SticlaQuantity)<4){
            productQuantities.put("Lipton 0.250 sticla", "1");
        }

        if(!mirinda0250SticlaQuantity.isEmpty() && Integer.parseInt(mirinda0250SticlaQuantity)<8){
            productQuantities.put("Mirinda 0.250 sticla", "1");
        }

        if(!pepsi0250SticlaQuantity.isEmpty() && Integer.parseInt(pepsi0250SticlaQuantity)<4){
            int n8=4-Integer.parseInt(pepsi0250SticlaQuantity);
            productQuantities.put("Pepsi 0.250 sticla", String.valueOf(n8));
        }
        if(!pepsiVintage0250SticlaQuantity.isEmpty() && Integer.parseInt(pepsiVintage0250SticlaQuantity)<1){
            productQuantities.put("Pepsi Vintage 0.250", "1");
        }
        if(!pepsiMax0250SticlaQuantity.isEmpty() && Integer.parseInt(pepsiMax0250SticlaQuantity)<2){
            int n9=2-Integer.parseInt(pepsiMax0250SticlaQuantity);
            productQuantities.put("Pepsi Max 0.250 sticla", String.valueOf(n9));
        }
        if(!pepsiTwist0250SticlaQuantity.isEmpty() && Integer.parseInt(pepsiTwist0250SticlaQuantity)<2){
            int n10=2-Integer.parseInt(pepsiMax0250SticlaQuantity);
            productQuantities.put("Pepsi Twist 0.250 sticla", String.valueOf(n10));
        }

        if(!prigatCapsuneSiBanane0250SticlaQuantity.isEmpty() && Integer.parseInt(prigatCapsuneSiBanane0250SticlaQuantity)<4){
            int n11=4-Integer.parseInt(prigatCapsuneSiBanane0250SticlaQuantity);
            productQuantities.put("Prigat Capsune si Banane", String.valueOf(n11));
        }
        if(!prigatKiwi0250SticlaQuantity.isEmpty() && Integer.parseInt(prigatKiwi0250SticlaQuantity)<4){
            int n12=4-Integer.parseInt(prigatKiwi0250SticlaQuantity);
            productQuantities.put("Prigat Kiwi", String.valueOf(n12));
        }
        if(!prigatPiersica0250SticlaQuantity.isEmpty() && Integer.parseInt(prigatPiersica0250SticlaQuantity)<4){
            int n13=4-Integer.parseInt(prigatPiersica0250SticlaQuantity);
            productQuantities.put("Prigat Piersica", String.valueOf(n13));
        }
        if(!rockstar0250MlDozaQuantity.isEmpty() && Integer.parseInt(rockstar0250MlDozaQuantity)<3){
            productQuantities.put("Rockstar", "6");
        }

        if(!acquaCarpaticaPlata15LPetQuantity.isEmpty() && Integer.parseInt(acquaCarpaticaPlata15LPetQuantity)<10){
            productQuantities.put("Acqua Carpatica 1.5L Pet Plata", "10");
        }





        // Adăugăm produsele în listă în ordinea în care au fost introduse
        for (Map.Entry<String, String> entry : productQuantities.entrySet()) {
            productList.add(new ProductData(entry.getKey(), entry.getValue()));
        }
    }



    private void setupRecyclerView() {
        ResultAdapterPepsi adapter = new ResultAdapterPepsi(productList);
        recyclerView.setAdapter(adapter);
    }

    public static class ProductData {
        private final String productName;
        private final String quantity;

        public ProductData(String productName, String quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }

        public String getQuantity() {
            return quantity;
        }
    }
}
