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

public class ResultActivityVinuri extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ProductData> productList;
    Button button1;
    Button button2;
    Button buttonCopy4;


    private static final String PREFS_NAME = "MyPrefs";
    private static final String[] orderedProductNames = {
            "Budureasca Fume", "Budureasca Rose", "Budureasca Shiraz", "Budureasca Noble White", "Budureasca Noble Five", "Purcari Chardonnay",
            "Purcari Rose", "Purcari Rara Neagra", "Naiv Tamaioasa Romaneasca", "Naiv Busuioaca de Buhotin", "Gitana Winery Saperavi", "Gitana Winery Lupi",
            "Vinarte Prince Mircea Merlot", "Vinarte Roza de Samburesti", "Petro Vaselo Bendis Roze", "Ferrari Maximum Brut", "Taraboste Rosu", "Taraboste Chardonnay",
            "Mircesti Feteasca Neagra Saperavi", "Bardul Din Mircesti Fume Blanc", "Mircesti Sauvignon Blanc", "Mircesti Rose",
            "Individo Cabernet Merlot Rose", "Individo Pinot Gris", "Individo Rara Neagra Malbe Syrah", "Individo Rose",
            "Amor", "Castel Vladoianu"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vinurifinishing);

        recyclerView = findViewById(R.id.recyclerFinishVinuri);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        getProductListFromSharedPreferences();
        setupRecyclerView();
        button1=findViewById(R.id.backButton1);
        button2=findViewById(R.id.backHomeButton2);
        buttonCopy4=findViewById(R.id.copyButton4);
        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivityVinuri.this, MainActivity.class);
            startActivity(intent);
        });
        buttonCopy4.setOnClickListener(v -> {
            StringBuilder copiedData = new StringBuilder();

            for (ResultActivityVinuri.ProductData product : productList) {
                copiedData.append(product.getProductName()).append(" - ").append(product.getQuantity()).append("\n");
            }

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Copied Data", copiedData.toString());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(ResultActivityVinuri.this, "Data copied to clipboard", Toast.LENGTH_SHORT).show();
        });
    }


    private void getProductListFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Map<String, String> productQuantities = new LinkedHashMap<>(); // Folosim LinkedHashMap pentru a păstra ordinea de inserare

        String budureascaFumeQuantity = sharedPreferences.getString("userNumber134", "");
        String budureascaRoseQuantity = sharedPreferences.getString("userNumber135", "");
        String budureascaShirazQuantity = sharedPreferences.getString("userNumber136", "");
        String budureascaNobleWhiteQuantity = sharedPreferences.getString("userNumber137", "");
        String budureascaNobleFiveQuantity = sharedPreferences.getString("userNumber138", "");
        String purcariChardonnayQuantity = sharedPreferences.getString("userNumber139", "");
        String purcariRoseQuantity = sharedPreferences.getString("userNumber140", "");
        String purcariRaraNeagraQuantity = sharedPreferences.getString("userNumber141", "");
        String naivTamaioasaRomaneascaQuantity = sharedPreferences.getString("userNumber142", "");
        String naivBusuioacaDeBuhotinQuantity = sharedPreferences.getString("userNumber143", "");
        String gitanaWinerySaperaviQuantity = sharedPreferences.getString("userNumber144", "");
        String gitanaWineryLupiQuantity = sharedPreferences.getString("userNumber145", "");
        String vinartePrinceMirceaMerlotQuantity = sharedPreferences.getString("userNumber146", "");
        String vinarteRozaDeSamburestiQuantity = sharedPreferences.getString("userNumber147", "");
        String petroVaseloBendisRozeQuantity = sharedPreferences.getString("userNumber148", "");
        String ferrariMaximumBrutQuantity = sharedPreferences.getString("userNumber149", "");
        String tarabosteRosuQuantity = sharedPreferences.getString("userNumber150", "");
        String tarabosteChardonnayQuantity = sharedPreferences.getString("userNumber151", "");
        String mircestiFeteascaNeagraSaperaviQuantity = sharedPreferences.getString("userNumber152", "");
        String bardulDinMircestiFumeBlancQuantity = sharedPreferences.getString("userNumber153", "");
        String mircestiSauvignonBlancQuantity = sharedPreferences.getString("userNumber154", "");
        String mircestiRoseQuantity = sharedPreferences.getString("userNumber155", "");
        String individoCabernetMerlotRoseQuantity = sharedPreferences.getString("userNumber156", "");
        String individoPinotGrisQuantity = sharedPreferences.getString("userNumber157", "");
        String individoRaraNeagraMalbeSyrahQuantity = sharedPreferences.getString("userNumber158", "");
        String individoRoseQuantity = sharedPreferences.getString("userNumber159", "");
        String amorQuantity = sharedPreferences.getString("userNumber160", "");
        String castelVladoianuQuantity = sharedPreferences.getString("userNumber161", "");

        if(!individoCabernetMerlotRoseQuantity.isEmpty() && Integer.parseInt(individoCabernetMerlotRoseQuantity)<6){
            int n14=6-Integer.parseInt(individoCabernetMerlotRoseQuantity);
            productQuantities.put("Individo Cabernet Merlot Rose", String.valueOf(n14));
        }
        if(!individoPinotGrisQuantity.isEmpty() && Integer.parseInt(individoPinotGrisQuantity)<6){
            int n15=6-Integer.parseInt(individoPinotGrisQuantity);
            productQuantities.put("Individo Pinot Gris & Chardonnay", String.valueOf(n15));
        }
        if(!individoRaraNeagraMalbeSyrahQuantity.isEmpty() && Integer.parseInt(individoRaraNeagraMalbeSyrahQuantity)<6){
            int n16=6-Integer.parseInt(individoRaraNeagraMalbeSyrahQuantity);
            productQuantities.put("Individo Rara Neagra Malbec Syrah", String.valueOf(n16));
        }
        if(!individoRoseQuantity.isEmpty() && Integer.parseInt(individoRoseQuantity)<6){
            int n17=6-Integer.parseInt(individoRoseQuantity);
            productQuantities.put("Individo Rose", String.valueOf(n17));
        }
        if(!tarabosteRosuQuantity.isEmpty() && Integer.parseInt(tarabosteRosuQuantity)<6){
            int n18=6-Integer.parseInt(tarabosteRosuQuantity);
            productQuantities.put("Taraboste Cabernet & Merlot", String.valueOf(n18));
        }
        if(!tarabosteChardonnayQuantity.isEmpty() && Integer.parseInt(tarabosteChardonnayQuantity)<6){
            int n19=6-Integer.parseInt(tarabosteChardonnayQuantity);
            productQuantities.put("Taraboste Chardonnay", String.valueOf(n19));
        }
        if(!naivBusuioacaDeBuhotinQuantity.isEmpty() && Integer.parseInt(naivBusuioacaDeBuhotinQuantity)<6){
            int n20=6-Integer.parseInt(naivBusuioacaDeBuhotinQuantity);
            productQuantities.put("Naiv Busuioaca de Buhotin", String.valueOf(n20));
        }
        if(!budureascaFumeQuantity.isEmpty() && Integer.parseInt(budureascaFumeQuantity)<6){
            int n21=6-Integer.parseInt(budureascaFumeQuantity);
            productQuantities.put("Budureasca Fume", String.valueOf(n21));
        }
        if(!budureascaNobleFiveQuantity.isEmpty() && Integer.parseInt(budureascaNobleFiveQuantity)<6){
            int n22=6-Integer.parseInt(budureascaNobleFiveQuantity);
            productQuantities.put("Budureasca Noble 5", String.valueOf(n22));
        }
        if(!budureascaNobleWhiteQuantity.isEmpty() && Integer.parseInt(budureascaNobleWhiteQuantity)<6){
            int n23=6-Integer.parseInt(budureascaNobleWhiteQuantity);
            productQuantities.put("Budureasca Noble White", String.valueOf(n23));
        }
        if(!budureascaRoseQuantity.isEmpty() && Integer.parseInt(budureascaRoseQuantity)<8){
            int n24=8-Integer.parseInt(budureascaRoseQuantity);
            productQuantities.put("Budureasca Rose", String.valueOf(n24));
        }
        if(!budureascaShirazQuantity.isEmpty() && Integer.parseInt(budureascaShirazQuantity)<6){
            int n25=6-Integer.parseInt(budureascaShirazQuantity);
            productQuantities.put("Budureasca Shiraz", String.valueOf(n25));
        }
        if(!castelVladoianuQuantity.isEmpty() && Integer.parseInt(castelVladoianuQuantity)<6){
            int n26=6-Integer.parseInt(castelVladoianuQuantity);
            productQuantities.put("Castel Vladoianu", String.valueOf(n26));
        }
        if(!naivTamaioasaRomaneascaQuantity.isEmpty() && Integer.parseInt(naivTamaioasaRomaneascaQuantity)<6){
            int n27=7-Integer.parseInt(naivTamaioasaRomaneascaQuantity);
            productQuantities.put("Naiv Tamaioasa Romaneasca", String.valueOf(n27));
        }
        if(!mircestiFeteascaNeagraSaperaviQuantity.isEmpty() && Integer.parseInt(mircestiFeteascaNeagraSaperaviQuantity)<6){
            int n28=6-Integer.parseInt(mircestiFeteascaNeagraSaperaviQuantity);
            productQuantities.put("Crama Mircesti Feteasca Neagra Saperavi", String.valueOf(n28));
        }
        if(!mircestiRoseQuantity.isEmpty() && Integer.parseInt(mircestiRoseQuantity)<6){
            int n29=6-Integer.parseInt(mircestiRoseQuantity);
            productQuantities.put("Crama Mircesti Rose", String.valueOf(n29));
        }
        if(!mircestiSauvignonBlancQuantity.isEmpty() && Integer.parseInt(mircestiSauvignonBlancQuantity)<6){
            int n30=6-Integer.parseInt(mircestiSauvignonBlancQuantity);
            productQuantities.put("Mircesti Sauvignon Blanc", String.valueOf(n30));
        }
        if(!individoCabernetMerlotRoseQuantity.isEmpty() && Integer.parseInt(individoCabernetMerlotRoseQuantity)<6){
            int n31=6-Integer.parseInt(individoCabernetMerlotRoseQuantity);
            productQuantities.put("Individo Cabernet Merlot Rose", String.valueOf(n31));
        }
        if(!bardulDinMircestiFumeBlancQuantity.isEmpty() && Integer.parseInt(bardulDinMircestiFumeBlancQuantity)<6){
            int n32=6-Integer.parseInt(bardulDinMircestiFumeBlancQuantity);
            productQuantities.put("Bardul din Mircesti Fume Blanc", String.valueOf(n32));
        }
        if(!gitanaWineryLupiQuantity.isEmpty() && Integer.parseInt(gitanaWineryLupiQuantity)<6){
            int n33=6-Integer.parseInt(gitanaWineryLupiQuantity);
            productQuantities.put("Gitana Winery Lupi", String.valueOf(n33));
        }
        if(!gitanaWinerySaperaviQuantity.isEmpty() && Integer.parseInt(gitanaWinerySaperaviQuantity)<6){
            int n34=6-Integer.parseInt(gitanaWinerySaperaviQuantity);
            productQuantities.put("Gitana Winery Saperavi", String.valueOf(n34));
        }
        if(!amorQuantity.isEmpty() && Integer.parseInt(amorQuantity)<6){
            int n35=6-Integer.parseInt(amorQuantity);
            productQuantities.put("Amor", String.valueOf(n35));
        }
        if(!petroVaseloBendisRozeQuantity.isEmpty() && Integer.parseInt(petroVaseloBendisRozeQuantity)<4){
            int n36=4-Integer.parseInt(petroVaseloBendisRozeQuantity);
            productQuantities.put("Petro Vaselo Bendis Rose", String.valueOf(n36));
        }
        if(!purcariRoseQuantity.isEmpty() && Integer.parseInt(purcariRoseQuantity)<8){
            int n37=8-Integer.parseInt(purcariRoseQuantity);
            productQuantities.put("Purcari Rose", String.valueOf(n37));
        }
        if(!purcariChardonnayQuantity.isEmpty() && Integer.parseInt(purcariChardonnayQuantity)<8){
            int n38=8-Integer.parseInt(purcariChardonnayQuantity);
            productQuantities.put("Purcari Chardonnay", String.valueOf(n38));
        }
        if(!purcariRaraNeagraQuantity.isEmpty() && Integer.parseInt(purcariRaraNeagraQuantity)<6){
            int n39=6-Integer.parseInt(purcariRaraNeagraQuantity);
            productQuantities.put("Purcari Rara Neagra", String.valueOf(n39));
        }
        if(!ferrariMaximumBrutQuantity.isEmpty() && Integer.parseInt(ferrariMaximumBrutQuantity)<4){
            int n40=4-Integer.parseInt(ferrariMaximumBrutQuantity);
            productQuantities.put("Ferrari Maximum Brut", String.valueOf(n40));
        }
        if(!vinartePrinceMirceaMerlotQuantity.isEmpty() && Integer.parseInt(vinartePrinceMirceaMerlotQuantity)<6){
            int n41=6-Integer.parseInt(vinartePrinceMirceaMerlotQuantity);
            productQuantities.put("Prince Mircea Merlot", String.valueOf(n41));
        }
        if(!vinarteRozaDeSamburestiQuantity.isEmpty() && Integer.parseInt(vinarteRozaDeSamburestiQuantity)<6){
            int n42=6-Integer.parseInt(vinarteRozaDeSamburestiQuantity);
            productQuantities.put("Vinarte Roza de Samburesti", String.valueOf(n42));
        }





        // Adăugăm produsele în listă în ordinea în care au fost introduse
        for (Map.Entry<String, String> entry : productQuantities.entrySet()) {
            productList.add(new ProductData(entry.getKey(), entry.getValue()));
        }
    }



    private void setupRecyclerView() {
        ResultAdapterVinuri adapter = new ResultAdapterVinuri(productList);
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
