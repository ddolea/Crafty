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

public class ResultActivityNecesar extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ProductData> productList;
    Button button1;
    Button button2;
    Button buttonCopy2;


    private static final String PREFS_NAME = "MyPrefs";
    private static final String[] orderedProductNames = {
            "Lapte Cocos", "Lapte", "Lapte Soia", "Lamai", "Portocale", "Grefe", "Lime", "Afine",
            "Capsune", "Rodie", "Fructul Pasiunii Proaspat", "Flori Comestibile", "Menta", "Rozmarin", "Cimbrisor", "Busuioc", "Ghimbir", "Miere",
            "Pepsi Auxiliar 0.5", "Plata 1.5L Pet", "Acqua Carpatica Minerala 0.5 Auxiliar", "7Up Auxiliar 0.5", "Tonic Auxiliar 0.5", "Frisca Tub",
            "Frisca Lichida"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.necesarfinishing);

        recyclerView = findViewById(R.id.recyclerFinishNecesar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        getProductListFromSharedPreferences();
        setupRecyclerView();
        button1=findViewById(R.id.backButton1);
        button2=findViewById(R.id.backHomeButton2);
        buttonCopy2=findViewById(R.id.copyButton2);
        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivityNecesar.this, MainActivity.class);
            startActivity(intent);
        });
        buttonCopy2.setOnClickListener(v -> {
            StringBuilder copiedData = new StringBuilder();

            for (ResultActivityNecesar.ProductData product : productList) {
                copiedData.append(product.getProductName()).append(" - ").append(product.getQuantity()).append("\n");
            }

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Copied Data", copiedData.toString());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(ResultActivityNecesar.this, "Data copied to clipboard", Toast.LENGTH_SHORT).show();
        });
    }


    private void getProductListFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Map<String, String> productQuantities = new LinkedHashMap<>(); // Folosim LinkedHashMap pentru a păstra ordinea de inserare


        String lapteCocosQuantity = sharedPreferences.getString("userNumber109", "");
        String lapteQuantity = sharedPreferences.getString("userNumber110", "");
        String lapteSoiaQuantity = sharedPreferences.getString("userNumber111", "");
        String lamaiQuantity = sharedPreferences.getString("userNumber112", "");
        String portocaleQuantity = sharedPreferences.getString("userNumber113", "");
        String grefeQuantity = sharedPreferences.getString("userNumber114", "");
        String limeQuantity = sharedPreferences.getString("userNumber115", "");
        String afineQuantity = sharedPreferences.getString("userNumber116", "");
        String capsuneQuantity = sharedPreferences.getString("userNumber117", "");
        String rodieQuantity = sharedPreferences.getString("userNumber118", "");
        String fructulPasiuniiProaspatQuantity = sharedPreferences.getString("userNumber119", "");
        String floriComestibileQuantity = sharedPreferences.getString("userNumber120", "");
        String mentaQuantity = sharedPreferences.getString("userNumber121", "");
        String rozmarinQuantity = sharedPreferences.getString("userNumber122", "");
        String cimbrisorQuantity = sharedPreferences.getString("userNumber123", "");
        String busuiocQuantity = sharedPreferences.getString("userNumber124", "");
        String ghimbirQuantity = sharedPreferences.getString("userNumber125", "");
        String miereQuantity = sharedPreferences.getString("userNumber126", "");
        String pepsiAuxiliar05Quantity = sharedPreferences.getString("userNumber127", "");
        String plata15LPetQuantity = sharedPreferences.getString("userNumber128", "");
        String acquaCarpaticaMinerala05AuxiliarQuantity = sharedPreferences.getString("userNumber129", "");
        String sevenUpAuxiliar05Quantity = sharedPreferences.getString("userNumber130", "");
        String tonicAuxiliar05Quantity = sharedPreferences.getString("userNumber131", "");
        String friscaTubQuantity = sharedPreferences.getString("userNumber132", "");
        String friscaLichidaQuantity = sharedPreferences.getString("userNumber133", "");

        if(!afineQuantity.isEmpty() && Integer.parseInt(afineQuantity)<1){
            productQuantities.put("Afine", "1");
        }
        if(!acquaCarpaticaMinerala05AuxiliarQuantity.isEmpty() && Integer.parseInt(acquaCarpaticaMinerala05AuxiliarQuantity)<6){
            productQuantities.put("Apa Minerala Auxiliar 0.5", "12");
        }

        if(!plata15LPetQuantity.isEmpty() && Integer.parseInt(plata15LPetQuantity)<8){
            productQuantities.put("Apa Plata 1.5L Pet", "10");
        }


        if(!sevenUpAuxiliar05Quantity.isEmpty() && Integer.parseInt(sevenUpAuxiliar05Quantity)<3){
            productQuantities.put("Seven Up Auxiliar 0.5", "12");
        }
        if(!tonicAuxiliar05Quantity.isEmpty() && Integer.parseInt(tonicAuxiliar05Quantity)<6){
            productQuantities.put("Tonic Auxiliar 0.5", "12");
        }

        if(!pepsiAuxiliar05Quantity.isEmpty() && Integer.parseInt(pepsiAuxiliar05Quantity)<6){
            productQuantities.put("Pepsi Auxiliar 0.5", "12");
        }

        if(!busuiocQuantity.isEmpty() && Integer.parseInt(busuiocQuantity)<1){
            productQuantities.put("Busuioc", "1");
        }
        if(!capsuneQuantity.isEmpty() && Integer.parseInt(capsuneQuantity)<1){
            productQuantities.put("Capsune", "1");
        }
        if(!cimbrisorQuantity.isEmpty() && Integer.parseInt(cimbrisorQuantity)<1){
            productQuantities.put("Cimbrisor", "1");
        }


        if(!floriComestibileQuantity.isEmpty() && Integer.parseInt(floriComestibileQuantity)<1){
            productQuantities.put("Flori comestibile", "1");
        }
        if(!friscaTubQuantity.isEmpty() && Integer.parseInt(pepsiAuxiliar05Quantity)<3){
            productQuantities.put("Frisca Lichida", "2");
        }
        if(!friscaTubQuantity.isEmpty() && Integer.parseInt(friscaTubQuantity)<6){
            productQuantities.put("Frisca Tub", "4");
        }
        if(!fructulPasiuniiProaspatQuantity.isEmpty() && Integer.parseInt(fructulPasiuniiProaspatQuantity)<4){
            int n5=4-Integer.parseInt(fructulPasiuniiProaspatQuantity);
            productQuantities.put("Fructul Pasiunii Proaspat", String.valueOf(n5));
        }
        if(!ghimbirQuantity.isEmpty() && Integer.parseInt(ghimbirQuantity)<1){
            productQuantities.put("Ghimbir", "300grame");
        }
        if(!grefeQuantity.isEmpty() && Integer.parseInt(grefeQuantity)<6){
            productQuantities.put("Grefe", "1");
        }
        if(!lamaiQuantity.isEmpty() && Integer.parseInt(lamaiQuantity)<1){
            productQuantities.put("Lamai", "1");
        }
        if(!lapteQuantity.isEmpty() && Integer.parseInt(lapteQuantity)<15){
            productQuantities.put("Lapte", "1");
        }
        if(!lapteCocosQuantity.isEmpty() && Integer.parseInt(lapteCocosQuantity)<1){
            productQuantities.put("Lapte Cocos", "2");
        }
        if(!lapteSoiaQuantity.isEmpty() && Integer.parseInt(lapteSoiaQuantity)<1){
            productQuantities.put("Lapte Soia", "2");
        }
        if(!limeQuantity.isEmpty() && Integer.parseInt(limeQuantity)<1){
            productQuantities.put("Lime", "3 kg");
        }

        if(!mentaQuantity.isEmpty() && Integer.parseInt(mentaQuantity)<4){
            int n6=4-Integer.parseInt(mentaQuantity);
            productQuantities.put("Menta", String.valueOf(n6));
        }
        if(!miereQuantity.isEmpty() && Integer.parseInt(miereQuantity)<3){
            int n7=3-Integer.parseInt(miereQuantity);
            productQuantities.put("Miere", String.valueOf(n7));
        }

        if(!portocaleQuantity.isEmpty() && Integer.parseInt(portocaleQuantity)<1){
            productQuantities.put("Portocale", "1");
        }

        if(!rodieQuantity.isEmpty() && Integer.parseInt(rodieQuantity)<1){
            productQuantities.put("Rodie", "1");
        }
        if(!rozmarinQuantity.isEmpty() && Integer.parseInt(rozmarinQuantity)<1){
            productQuantities.put("Rozmarin", "1");
        }

        if(!friscaLichidaQuantity.isEmpty() && Integer.parseInt(friscaLichidaQuantity)<3){
            productQuantities.put("Frisca Lichida", "2");
        }






        // Adăugăm produsele în listă în ordinea în care au fost introduse
        for (Map.Entry<String, String> entry : productQuantities.entrySet()) {
            productList.add(new ProductData(entry.getKey(), entry.getValue()));
        }
    }



    private void setupRecyclerView() {
        ResultAdapterNecesar adapter = new ResultAdapterNecesar(productList);
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
