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

public class ResultActivityGrosbi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ProductData> productList;
    Button button1;
    Button button2;
    Button buttonCopy3;


    private static final String PREFS_NAME = "MyPrefs";
    private static final String[] orderedProductNames = {
            "Aperol", "Campari", "Crodino", "Ketel One", "Ciroc", "Smirnoff Red", "Smirnoff North", "Tanqueray London Dry", "Tanqueray Royale",
            "Tanqueray Flor de Sevilla", "Tanqueray Rangpur", "Gordon`s Pink", "Gordon`s Sicilian Lemon", "Gordon`s Mediterranean", "Tanqueray No. 10","Tanqueray 0%",
            "Johnnie Walker Red Label", "Haig Club", "Johnnie Walker Black Label", "Johnnie Walker Double Black", "Johnnie Walker Green Label",
            "Johnnie Walker 18 yo", "Johnnie Walker Gold Reserve", "Johnie Walker Blue Label", "Singleton", "Lagavulin", "Caol Ila", "Talisker",
            "Roe & Coe", "Bushmills The Original", "Bushmills Black Bush", "Bulleit Bourbon", "Bulleit Rye", "Zacapa XO", "Captain Tiki", "Zacapa 23",
            "Pampero Aniversario", "Captain Morgan Spiced Black", "Captain Morgan Spiced Gold", "Pampero Blanco", "Don Julio", "1800 Reserva Anejo",
            "Don Julio Blanco", "Courvoiser XO", "Courvoiser VS", "Courvoiser VSOP", "Metaxa 7*", "KVINT XO", "KVINT VSOP", "Grand Marnier",
            "Jaggermeister", "Baileys", "Tia Maria", "Lichior Peche", "Amaretto Disaronno", "Disaronno Velvet", "Frangelico","Monin Triplu Sec", "Amaro Averna",
            "Cinzano Bianco", "Cinzano Dry", "Cinzano Rosso 1757", "Grande Vento Brut", "Grande Vento Rose", "San Pellegrino 0.33 Arranciata",
            "San Pellegrino 0.33 Pompelmo", "San Pellegrino 0.33 Arranciata Rossa", "San Pellegrino 0.33 Tonic", "Ungheni Rachiu Caise", "Ungheni Balsam",
            "Johnnie Walker Red HighBall", "Johnnie Walker Black HighBall", "Rockstar Original 0.250 Doza", "Rockstar XDurance 0.250 Doza",
            "Acqua Panna 0.750", "San Pellegrino 0.750", "Monin Sirop Rose", "Monin Sirop Vanillie", "Monin Sirop Watermelon", "Monin Sirop Soc",
            "Monin Sirop Cocos", "Monin Sirop Lavanda", "Monin Sirop Caramel", "Monin Sirop Red Berries", "Monin Sirop Pumpkin Spiced",
            "Monin Sirop Ginger Bread", "Monin Sirop ChocoCookie", "Monin Sirop Iasomie","Monin Sirop Red Berries", "Monin Sirop Popcorn", "Monin Sirop Black Currant",
            "Monin Piure Passion Fruit", "Monin Piure Strawberry", "Peroni Premium 0.33", "Peroni N.A. 0.33", "Peroni Capri 0.33", "Peroni Draught",
            "Azuga Nefiltrata", "Azuga Nepasteurizata", "Ursus Premium 0.33", "Ursus N.A. 0.33", "Kozel Premium", "Kozel Dark", "Pilsner Urquell", "Asahi",
            "Ursus Pilsner", "Ursus Nefiltrat", "Ursus IPA"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grosbifinishing);

        recyclerView = findViewById(R.id.recyclerFinishGrosbi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        getProductListFromSharedPreferences();
        setupRecyclerView();
        button1=findViewById(R.id.backButton1);
        button2=findViewById(R.id.backHomeButton2);
        buttonCopy3=findViewById(R.id.copyButton3);
        button1.setOnClickListener(v -> onBackPressed());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivityGrosbi.this, MainActivity.class);
            startActivity(intent);
        });
        buttonCopy3.setOnClickListener(v -> {
            StringBuilder copiedData = new StringBuilder();

            for (ResultActivityGrosbi.ProductData product : productList) {
                copiedData.append(product.getProductName()).append(" - ").append(product.getQuantity()).append("\n");
            }

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Copied Data", copiedData.toString());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(ResultActivityGrosbi.this, "Data copied to clipboard", Toast.LENGTH_SHORT).show();
        });
    }


    private void getProductListFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Map<String, String> productQuantities = new LinkedHashMap<>(); // Folosim LinkedHashMap pentru a păstra ordinea de inserare

        String aperolQuantity = sharedPreferences.getString("userNumber1", "");
        String campariQuantity = sharedPreferences.getString("userNumber2", "");
        String crodinoQuantity = sharedPreferences.getString("userNumber3", "");
        String ketelOneQuantity = sharedPreferences.getString("userNumber4", "");
        String cirocQuantity = sharedPreferences.getString("userNumber5", "");
        String smirnoffRedQuantity = sharedPreferences.getString("userNumber6", "");
        String smirnoffNorthQuantity = sharedPreferences.getString("userNumber7", "");
        String tanquerayLondonDryQuantity = sharedPreferences.getString("userNumber8", "");
        String tanquerayRoyaleQuantity = sharedPreferences.getString("userNumber9", "");
        String tanquerayFlorDeSevillaQuantity = sharedPreferences.getString("userNumber10", "");
        String tanquerayRangpurQuantity = sharedPreferences.getString("userNumber11", "");
        String gordonsPinkQuantity = sharedPreferences.getString("userNumber12", "");
        String gordonsSicilianLemonQuantity = sharedPreferences.getString("userNumber13", "");
        String gordonsMediterraneanQuantity = sharedPreferences.getString("userNumber14", "");
        String tanquerayNo10Quantity = sharedPreferences.getString("userNumber15", "");
        String tanquerayZeroQuantity = sharedPreferences.getString("userNumber16", "");
        String johnnieWalkerRedLabelQuantity = sharedPreferences.getString("userNumber17", "");
        String haigClubQuantity = sharedPreferences.getString("userNumber18", "");
        String johnnieWalkerBlackLabelQuantity = sharedPreferences.getString("userNumber19", "");
        String johnnieWalkerDoubleBlackQuantity = sharedPreferences.getString("userNumber20", "");
        String johnnieWalkerGreenLabelQuantity = sharedPreferences.getString("userNumber21", "");
        String johnnieWalker18yoQuantity = sharedPreferences.getString("userNumber22", "");
        String johnnieWalkerGoldReserveQuantity = sharedPreferences.getString("userNumber23", "");
        String johnnieWalkerBlueLabelQuantity = sharedPreferences.getString("userNumber24", "");
        String singletonQuantity = sharedPreferences.getString("userNumber25", "");
        String lagavulinQuantity = sharedPreferences.getString("userNumber26", "");
        String caolIlaQuantity = sharedPreferences.getString("userNumber27", "");
        String taliskerQuantity = sharedPreferences.getString("userNumber28", "");
        String roeAndCoeQuantity = sharedPreferences.getString("userNumber29", "");
        String bushmillsTheOriginalQuantity = sharedPreferences.getString("userNumber30", "");
        String bushmillsBlackBushQuantity = sharedPreferences.getString("userNumber31", "");
        String bulleitBourbonQuantity = sharedPreferences.getString("userNumber32", "");
        String bulleitRyeQuantity = sharedPreferences.getString("userNumber33", "");
        String zacapaXOQuantity = sharedPreferences.getString("userNumber34", "");
        String captainTikiQuantity = sharedPreferences.getString("userNumber35", "");
        String zacapa23Quantity = sharedPreferences.getString("userNumber36", "");
        String pamperoAniversarioQuantity = sharedPreferences.getString("userNumber37", "");
        String captainMorganSpicedBlackQuantity = sharedPreferences.getString("userNumber38", "");
        String captainMorganSpicedGoldQuantity = sharedPreferences.getString("userNumber39", "");
        String pamperoBlancoQuantity = sharedPreferences.getString("userNumber40", "");
        String donJulioQuantity = sharedPreferences.getString("userNumber41", "");
        String reserverAnejoQuantity = sharedPreferences.getString("userNumber42", "");
        String donJulioBlancoQuantity = sharedPreferences.getString("userNumber43", "");
        String courvoiserXOQuantity = sharedPreferences.getString("userNumber44", "");
        String courvoiserVSQuantity = sharedPreferences.getString("userNumber45", "");
        String courvoiserVSOPQuantity = sharedPreferences.getString("userNumber46", "");
        String metaxa7Quantity = sharedPreferences.getString("userNumber47", "");
        String kvintXOQuantity = sharedPreferences.getString("userNumber48", "");
        String kvintVSOPQuantity = sharedPreferences.getString("userNumber49", "");
        String grandMarnierQuantity = sharedPreferences.getString("userNumber50", "");
        String jaggermeisterQuantity = sharedPreferences.getString("userNumber51", "");
        String baileysQuantity = sharedPreferences.getString("userNumber52", "");
        String tiaMariaQuantity = sharedPreferences.getString("userNumber53", "");
        String lichiorPecheQuantity = sharedPreferences.getString("userNumber54", "");
        String amarettoDisaronnoQuantity = sharedPreferences.getString("userNumber55", "");
        String disaronnoVelvetQuantity = sharedPreferences.getString("userNumber56", "");
        String frangelicoQuantity = sharedPreferences.getString("userNumber57", "");
        String tripluSecQuantity = sharedPreferences.getString("userNumber58", "");
        String amaroAvernaQuantity = sharedPreferences.getString("userNumber59", "");
        String cinzanoBiancoQuantity = sharedPreferences.getString("userNumber60", "");
        String cinzanoDryQuantity = sharedPreferences.getString("userNumber61", "");
        String cinzanoRosso1757Quantity = sharedPreferences.getString("userNumber62", "");
        String grandeVentoBrutQuantity = sharedPreferences.getString("userNumber63", "");
        String grandeVentoRoseQuantity = sharedPreferences.getString("userNumber64", "");
        String sanPellegrino033ArranciataQuantity = sharedPreferences.getString("userNumber65", "");
        String sanPellegrino033PompelmoQuantity = sharedPreferences.getString("userNumber66", "");
        String sanPellegrino033ArranciataRossaQuantity = sharedPreferences.getString("userNumber67", "");
        String sanPellegrino033TonicQuantity = sharedPreferences.getString("userNumber68", "");
        String ungheniRachiuCaiseQuantity = sharedPreferences.getString("userNumber69", "");
        String ungheniBalsamQuantity = sharedPreferences.getString("userNumber70", "");
        String johnnieWalkerRedHighBallQuantity = sharedPreferences.getString("userNumber71", "");
        String johnnieWalkerBlackHighBallQuantity = sharedPreferences.getString("userNumber72", "");
        String rockstarOriginal0250DozaQuantity = sharedPreferences.getString("userNumber73", "");
        String rockstarXDurance0250DozaQuantity = sharedPreferences.getString("userNumber74", "");
        String acquaPanna0750Quantity = sharedPreferences.getString("userNumber75", "");
        String sanPellegrino0750Quantity = sharedPreferences.getString("userNumber76", "");
        String moninSiropRoseQuantity = sharedPreferences.getString("userNumber77", "");
        String moninSiropVanillieQuantity = sharedPreferences.getString("userNumber78", "");
        String moninSiropWatermelonQuantity = sharedPreferences.getString("userNumber79", "");
        String moninSiropSocQuantity = sharedPreferences.getString("userNumber80", "");
        String moninSiropCocosQuantity = sharedPreferences.getString("userNumber81", "");
        String moninSiropLavandaQuantity = sharedPreferences.getString("userNumber82", "");
        String moninSiropCaramelQuantity = sharedPreferences.getString("userNumber83", "");
        String moninSiropLemonTeaQuantity = sharedPreferences.getString("userNumber84", "");
        String moninSiropPumpkinSpicedQuantity = sharedPreferences.getString("userNumber85", "");
        String moninSiropGingerBreadQuantity = sharedPreferences.getString("userNumber86", "");
        String moninSiropChocoCookieQuantity = sharedPreferences.getString("userNumber87", "");
        String moninSiropIasomieQuantity = sharedPreferences.getString("userNumber88", "");
        String moninSiropRedBerries2Quantity = sharedPreferences.getString("userNumber89", "");
        String moninSiropPopcornQuantity = sharedPreferences.getString("userNumber90", "");
        String moninSiropBlackCurrantQuantity = sharedPreferences.getString("userNumber91", "");
        String moninPiurePassionFruitQuantity = sharedPreferences.getString("userNumber92", "");
        String moninPiureStrawberryQuantity = sharedPreferences.getString("userNumber93", "");
        String peroniPremium033Quantity = sharedPreferences.getString("userNumber94", "");
        String peroniNA033Quantity = sharedPreferences.getString("userNumber95", "");
        String peroniCapri033Quantity = sharedPreferences.getString("userNumber96", "");
        String peroniDraughtQuantity = sharedPreferences.getString("userNumber97", "");
        String azugaNefiltrataQuantity = sharedPreferences.getString("userNumber98", "");
        String azugaNepasteurizataQuantity = sharedPreferences.getString("userNumber99", "");
        String ursusPremium033Quantity = sharedPreferences.getString("userNumber100", "");
        String ursusNA033Quantity = sharedPreferences.getString("userNumber101", "");
        String kozelPremiumQuantity = sharedPreferences.getString("userNumber102", "");
        String kozelDarkQuantity = sharedPreferences.getString("userNumber103", "");
        String pilsnerUrquellQuantity = sharedPreferences.getString("userNumber104", "");
        String asahiQuantity = sharedPreferences.getString("userNumber105", "");
        String ursusPilsnerQuantity = sharedPreferences.getString("userNumber106", "");
        String ursusNefiltratQuantity = sharedPreferences.getString("userNumber107", "");
        String ursusIPAQuantity = sharedPreferences.getString("userNumber108", "");


        if (!aperolQuantity.isEmpty() && Integer.parseInt(aperolQuantity) < 500) {
            productQuantities.put("Aperol", "1");
        }


        if (!campariQuantity.isEmpty() && Integer.parseInt(campariQuantity) < 400) {
            productQuantities.put("Campari", "1");
        }

        if(!crodinoQuantity.isEmpty() && Integer.parseInt(crodinoQuantity)<7){
            productQuantities.put("Crodino", "6");
        }
        if(!ketelOneQuantity.isEmpty() && Integer.parseInt(ketelOneQuantity)<700){
            productQuantities.put("Ketel One", "1");
        }
        if(!cirocQuantity.isEmpty() && Integer.parseInt(cirocQuantity)<300){
            productQuantities.put("Ciroc", "1");
        }
        if(!smirnoffRedQuantity.isEmpty() && Integer.parseInt(smirnoffRedQuantity)<400){
            productQuantities.put("Smirnoff Red", "1");
        }
        if(!smirnoffNorthQuantity.isEmpty() && Integer.parseInt(smirnoffNorthQuantity)<200){
            productQuantities.put("Smirnoff North", "1");
        }
        if(!tanquerayLondonDryQuantity.isEmpty() && Integer.parseInt(tanquerayLondonDryQuantity)<700){
            productQuantities.put("Tanqueray London Dry", "1");
        }
        if(!tanquerayRoyaleQuantity.isEmpty() && Integer.parseInt(tanquerayRoyaleQuantity)<700){
            productQuantities.put("Tanqueray Royale", "1");
        }
        if(!tanquerayFlorDeSevillaQuantity.isEmpty() && Integer.parseInt(tanquerayFlorDeSevillaQuantity)<700){
            productQuantities.put("Tanqueray Flor de Sevilla", "1");
        }
        if(!tanquerayRangpurQuantity.isEmpty() && Integer.parseInt(tanquerayRangpurQuantity)<700){
            productQuantities.put("Tanqueray Rangpur", "1");
        }
        if(!gordonsPinkQuantity.isEmpty() && Integer.parseInt(gordonsPinkQuantity)<700){
            productQuantities.put("Gordon`s Pink", "1");
        }
        if(!gordonsSicilianLemonQuantity.isEmpty() && Integer.parseInt(gordonsSicilianLemonQuantity)<700){
            productQuantities.put("Gordon`s Sicilian Lemon", "1");
        }
        if(!gordonsMediterraneanQuantity.isEmpty() && Integer.parseInt(gordonsMediterraneanQuantity)<700){
            productQuantities.put("Gordon`s Mediterranean", "1");
        }
        if(!tanquerayNo10Quantity.isEmpty() && Integer.parseInt(tanquerayNo10Quantity)<700){
            productQuantities.put("Tanqueray No. 10", "1");
        }
        if(!tanquerayZeroQuantity.isEmpty() && Integer.parseInt(tanquerayZeroQuantity)<700){
            productQuantities.put("Tanqueray 0%", "1");
        }
        if(!johnnieWalkerRedLabelQuantity.isEmpty() && Integer.parseInt(johnnieWalkerRedLabelQuantity)<350){
            productQuantities.put("Johnnie Walker Red Label", "1");
        }
        if(!haigClubQuantity.isEmpty() && Integer.parseInt(haigClubQuantity)<101){
            productQuantities.put("Haig Club", "1");
        }
        if(!johnnieWalkerBlackLabelQuantity.isEmpty() && Integer.parseInt(johnnieWalkerBlackLabelQuantity)<350){
            productQuantities.put("Johnnie Walker Black Label", "1");
        }
        if(!johnnieWalkerDoubleBlackQuantity.isEmpty() && Integer.parseInt(johnnieWalkerDoubleBlackQuantity)<350){
            productQuantities.put("Johnnie Walker Double Black", "1");
        }
        if(!johnnieWalkerGreenLabelQuantity.isEmpty() && Integer.parseInt(johnnieWalkerGreenLabelQuantity)<350){
            productQuantities.put("Johnnie Walker Green Label", "1");
        }
        if(!johnnieWalker18yoQuantity.isEmpty() && Integer.parseInt(johnnieWalker18yoQuantity)<350){
            productQuantities.put("Johnnie Walker 18 yo", "1");
        }
        if(!johnnieWalkerGoldReserveQuantity.isEmpty() && Integer.parseInt(johnnieWalkerGoldReserveQuantity)<350){
            productQuantities.put("Johnnie Walker Gold Reserve", "1");
        }
        if(!johnnieWalkerBlueLabelQuantity.isEmpty() && Integer.parseInt(johnnieWalkerBlueLabelQuantity)<101){
            productQuantities.put("Johnnie Walker Blue Label", "1");
        }
        if(!singletonQuantity.isEmpty() && Integer.parseInt(singletonQuantity)<350){
            productQuantities.put("Singleton", "1");
        }
        if(!lagavulinQuantity.isEmpty() && Integer.parseInt(lagavulinQuantity)<200){
            productQuantities.put("Lagavulin", "1");
        }
        if(!caolIlaQuantity.isEmpty() && Integer.parseInt(caolIlaQuantity)<200){
            productQuantities.put("Caol Ila", "1");
        }
        if(!taliskerQuantity.isEmpty() && Integer.parseInt(taliskerQuantity)<250){
            productQuantities.put("Talisker", "1");
        }
        if(!roeAndCoeQuantity.isEmpty() && Integer.parseInt(roeAndCoeQuantity)<200){
            productQuantities.put("Roe & Coe", "1");
        }
        if(!bushmillsTheOriginalQuantity.isEmpty() && Integer.parseInt(bushmillsTheOriginalQuantity)<350){
            productQuantities.put("Bushmills the Original", "1");
        }
        if(!bushmillsBlackBushQuantity.isEmpty() && Integer.parseInt(bushmillsBlackBushQuantity)<350){
            productQuantities.put("Bushmills Black Bush", "1");
        }
        if(!bulleitBourbonQuantity.isEmpty() && Integer.parseInt(bulleitBourbonQuantity)<350){
            productQuantities.put("Bulleit Bourbon", "1");
        }
        if(!bulleitRyeQuantity.isEmpty() && Integer.parseInt(bulleitRyeQuantity)<101){
            productQuantities.put("Bulleit Rye", "1");
        }

        if(!acquaPanna0750Quantity.isEmpty() && Integer.parseInt(acquaPanna0750Quantity)<6){
            int n1=6-Integer.parseInt(acquaPanna0750Quantity);
            productQuantities.put("Acqua Panna 0.750", String.valueOf(n1));
        }

        if(!bulleitRyeQuantity.isEmpty() && Integer.parseInt(bulleitRyeQuantity)<101){
            productQuantities.put("Bulleit Rye", "1");
        }

        if(!asahiQuantity.isEmpty() && Integer.parseInt(asahiQuantity)<6){
            productQuantities.put("Asahi 0.33", "1");
        }
        if(!azugaNepasteurizataQuantity.isEmpty() && Integer.parseInt(azugaNepasteurizataQuantity)<6){
            productQuantities.put("Azuga Nepasteurizata", "1");
        }
        if(!azugaNefiltrataQuantity.isEmpty() && Integer.parseInt(azugaNefiltrataQuantity)<6){
            productQuantities.put("Azuga Nefiltrata", "1");
        }
        if(!kozelDarkQuantity.isEmpty() && Integer.parseInt(kozelDarkQuantity)<6){
            productQuantities.put("Kozel Dark 0.33", "1");
        }
        if(!kozelPremiumQuantity.isEmpty() && Integer.parseInt(kozelPremiumQuantity)<6){
            productQuantities.put("Kozel Premium", "1");
        }
        if(!peroniNA033Quantity.isEmpty() && Integer.parseInt(peroniNA033Quantity)<10){
            productQuantities.put("Peroni N.A. 0.33", "1");
        }
        if(!peroniCapri033Quantity.isEmpty() && Integer.parseInt(peroniCapri033Quantity)<10){
            productQuantities.put("Peroni Capri 0.33", "1");
        }
        if(!peroniDraughtQuantity.isEmpty() && Integer.parseInt(peroniDraughtQuantity)<1){
            productQuantities.put("Peroni Draught", "1");
        }
        if(!pilsnerUrquellQuantity.isEmpty() && Integer.parseInt(pilsnerUrquellQuantity)<6){
            productQuantities.put("Pilsner Urquell 0.33", "1");
        }
        if(!peroniPremium033Quantity.isEmpty() && Integer.parseInt(peroniPremium033Quantity)<10){
            productQuantities.put("Peroni Premium 0.33", "1");
        }
        if(!ursusIPAQuantity.isEmpty() && Integer.parseInt(ursusIPAQuantity)<4){
            productQuantities.put("Ursus IPA 0.33", "12");
        }
        if(!ursusNefiltratQuantity.isEmpty() && Integer.parseInt(ursusNefiltratQuantity)<4){
            productQuantities.put("Ursus Nefiltrat 0.33", "12");
        }
        if(!ursusPilsnerQuantity.isEmpty() && Integer.parseInt(ursusPilsnerQuantity)<4){
            productQuantities.put("Ursus Pilsner 0.33", "12");
        }
        if(!ursusPremium033Quantity.isEmpty() && Integer.parseInt(ursusPremium033Quantity)<6){
            productQuantities.put("Ursus Premium 0.33", "1");
        }

        if(!kvintVSOPQuantity.isEmpty() && Integer.parseInt(kvintVSOPQuantity)<350){
            productQuantities.put("Kvint VSOP 6yo", "1");
        }
        if(!kvintXOQuantity.isEmpty() && Integer.parseInt(kvintXOQuantity)<350){
            productQuantities.put("Kvint XO", "1");
        }

        if(!lichiorPecheQuantity.isEmpty() && Integer.parseInt(lichiorPecheQuantity)<350){
            productQuantities.put("Monin Lichior Peche", "1");
        }
        if(!tripluSecQuantity.isEmpty() && Integer.parseInt(tripluSecQuantity)<350){
            productQuantities.put("Monin Triplu Sec", "1");
        }

        if(!rockstarOriginal0250DozaQuantity.isEmpty() && Integer.parseInt(rockstarOriginal0250DozaQuantity)<3){
            productQuantities.put("Rockstar Original", "6");
        }
        if(!rockstarXDurance0250DozaQuantity.isEmpty() && Integer.parseInt(rockstarXDurance0250DozaQuantity)<3){
            productQuantities.put("Rockstar Xdurance", "6");
        }

        if(!amarettoDisaronnoQuantity.isEmpty() && Integer.parseInt(amarettoDisaronnoQuantity)<701){
            productQuantities.put("Disaronno", "1");
        }
        if(!disaronnoVelvetQuantity.isEmpty() && Integer.parseInt(disaronnoVelvetQuantity)<400){
            productQuantities.put("Disaronno Velvet", "1");
        }
        if(!aperolQuantity.isEmpty() && Integer.parseInt(aperolQuantity)<701){
            productQuantities.put("Aperol", "1");
        }
        if(!lichiorPecheQuantity.isEmpty() && Integer.parseInt(lichiorPecheQuantity)<400){
            productQuantities.put("Monin Lichior Peche", "1");
        }
        if(!baileysQuantity.isEmpty() && Integer.parseInt(baileysQuantity)<300){
            productQuantities.put("Baileys", "1");
        }
        if(!campariQuantity.isEmpty() && Integer.parseInt(campariQuantity)<701){
            productQuantities.put("Campari", "1");
        }
        if(!captainMorganSpicedBlackQuantity.isEmpty() && Integer.parseInt(captainMorganSpicedBlackQuantity)<300){
            productQuantities.put("Captain Morgan Spiced Black", "1");
        }
        if(!captainMorganSpicedGoldQuantity.isEmpty() && Integer.parseInt(captainMorganSpicedGoldQuantity)<701){
            productQuantities.put("Captain Morgan Spiced Gold", "1");
        }
        if(!captainTikiQuantity.isEmpty() && Integer.parseInt(captainTikiQuantity)<300){
            productQuantities.put("Captain Morgan Tiki", "1");
        }
        if(!cinzanoBiancoQuantity.isEmpty() && Integer.parseInt(cinzanoBiancoQuantity)<300){
            productQuantities.put("Cinzano Bianco", "1");
        }
        if(!cinzanoDryQuantity.isEmpty() && Integer.parseInt(cinzanoDryQuantity)<300){
            productQuantities.put("Cinzano Dry", "1");
        }
        if(!cinzanoRosso1757Quantity.isEmpty() && Integer.parseInt(cinzanoRosso1757Quantity)<700){
            productQuantities.put("Cinzano Rosoo 1757", "1");
        }
        if(!cirocQuantity.isEmpty() && Integer.parseInt(cirocQuantity)<300){
            productQuantities.put("Ciroc", "1");
        }
        if(!courvoiserVSOPQuantity.isEmpty() && Integer.parseInt(courvoiserVSOPQuantity)<300){
            productQuantities.put("Courvoiser VSOP", "1");
        }
        if(!courvoiserXOQuantity.isEmpty() && Integer.parseInt(courvoiserXOQuantity)<300){
            productQuantities.put("Courvoiser XO", "1");
        }
        if(!courvoiserVSQuantity.isEmpty() && Integer.parseInt(courvoiserVSQuantity)<300){
            productQuantities.put("Courvoiser VS", "1");
        }
        if(!donJulioQuantity.isEmpty() && Integer.parseInt(donJulioQuantity)<700){
            productQuantities.put("Don Julio Reposado", "1");
        }
        if(!donJulioBlancoQuantity.isEmpty() && Integer.parseInt(donJulioBlancoQuantity)<600){
            productQuantities.put("Don Julio Blanco", "1");
        }
        if(!frangelicoQuantity.isEmpty() && Integer.parseInt(frangelicoQuantity)<401){  //asta e Pasooa :)
            productQuantities.put("Passoa", "1");
        }
        if(!gordonsPinkQuantity.isEmpty() && Integer.parseInt(gordonsPinkQuantity)<701){
            productQuantities.put("Gordon`s Pink", "1");
        }
        if(!gordonsMediterraneanQuantity.isEmpty() && Integer.parseInt(gordonsMediterraneanQuantity)<701){
            productQuantities.put("Gordon`s Mediterranean", "1");
        }
        if(!gordonsSicilianLemonQuantity.isEmpty() && Integer.parseInt(gordonsSicilianLemonQuantity)<701){
            productQuantities.put("Gordon`s Sicilian Lemon", "1");
        }
        if(!grandMarnierQuantity.isEmpty() && Integer.parseInt(grandMarnierQuantity)<150){
            productQuantities.put("Grand Marnier Rouge", "1");
        }
        if(!jaggermeisterQuantity.isEmpty() && Integer.parseInt(jaggermeisterQuantity)<400){
            productQuantities.put("Jaggermeister", "1");
        }
        if(!ketelOneQuantity.isEmpty() && Integer.parseInt(ketelOneQuantity)<701){
            productQuantities.put("Ketel One", "1");
        }
        if(!metaxa7Quantity.isEmpty() && Integer.parseInt(metaxa7Quantity)<500){
            productQuantities.put("Metaxa 7*", "1");
        }
        if(!pamperoAniversarioQuantity.isEmpty() && Integer.parseInt(pamperoAniversarioQuantity)<701){
            productQuantities.put("Pampero Aniversario", "1");
        }
        if(!pamperoBlancoQuantity.isEmpty() && Integer.parseInt(pamperoBlancoQuantity)<401){
            productQuantities.put("Pampero Blanco", "1");
        }
        if(!reserverAnejoQuantity.isEmpty() && Integer.parseInt(reserverAnejoQuantity)<400){
            productQuantities.put("Tequila 1800 Reserva Anejo", "1");
        }
        if(!smirnoffNorthQuantity.isEmpty() && Integer.parseInt(smirnoffNorthQuantity)<401){
            productQuantities.put("Smirnoff North ", "1");
        }
        if(!smirnoffRedQuantity.isEmpty() && Integer.parseInt(smirnoffRedQuantity)<501){
            productQuantities.put("Smirnoff Red", "1");
        }
        if(!cinzanoBiancoQuantity.isEmpty() && Integer.parseInt(cinzanoBiancoQuantity)<300){
            productQuantities.put("Cinzano Bianco", "1");
        }
        if(!tanquerayZeroQuantity.isEmpty() && Integer.parseInt(tanquerayZeroQuantity)<701){
            productQuantities.put("Tanqueray 0%", "1");
        }
        if(!tanquerayFlorDeSevillaQuantity.isEmpty() && Integer.parseInt(tanquerayFlorDeSevillaQuantity)<701){
            productQuantities.put("Tanqueray Flor De Sevilla", "1");
        }
        if(!tanquerayLondonDryQuantity.isEmpty() && Integer.parseInt(tanquerayLondonDryQuantity)<701){
            productQuantities.put("Tanqueray London Dry", "1");
        }
        if(!tanquerayNo10Quantity.isEmpty() && Integer.parseInt(tanquerayNo10Quantity)<701){
            productQuantities.put("Tanqueray No. 10", "1");
        }
        if(!tanquerayFlorDeSevillaQuantity.isEmpty() && Integer.parseInt(tanquerayFlorDeSevillaQuantity)<701){
            productQuantities.put("Tanqueray Flor De Sevilla", "1");
        }
        if(!moninSiropChocoCookieQuantity.isEmpty() && Integer.parseInt(moninSiropChocoCookieQuantity)<301){
            productQuantities.put("Monin Sirop ChocoCookie", "1");
        }
        if(!moninSiropGingerBreadQuantity.isEmpty() && Integer.parseInt(moninSiropGingerBreadQuantity)<301){
            productQuantities.put("Monin Sirop GingerBread", "1");
        }
        if(!moninSiropIasomieQuantity.isEmpty() && Integer.parseInt(moninSiropIasomieQuantity)<301){
            productQuantities.put("Monin Sirop Iasomie", "1");
        }
        if(!moninSiropBlackCurrantQuantity.isEmpty() && Integer.parseInt(moninSiropBlackCurrantQuantity)<301){
            productQuantities.put("Monin Sirop BlackCurrant", "1");
        }
        if(!moninSiropCaramelQuantity.isEmpty() && Integer.parseInt(moninSiropCaramelQuantity)<301){
            productQuantities.put("Monin Sirop Caramel", "1");
        }
        if(!moninSiropCocosQuantity.isEmpty() && Integer.parseInt(moninSiropCocosQuantity)<501){
            productQuantities.put("Monin Sirop Cocos", "1");
        }
        if(!moninSiropLavandaQuantity.isEmpty() && Integer.parseInt(moninSiropLavandaQuantity)<501){
            productQuantities.put("Monin Sirop Lavanda", "1");
        }
        if(!moninSiropBlackCurrantQuantity.isEmpty() && Integer.parseInt(moninSiropBlackCurrantQuantity)<301){
            productQuantities.put("Monin Sirop BlackCurrant", "1");
        }
        if(!moninSiropLemonTeaQuantity.isEmpty() && Integer.parseInt(moninSiropLemonTeaQuantity)<301){
            productQuantities.put("Monin Sirop Lemon Tea", "1");
        }
        if(!moninSiropPopcornQuantity.isEmpty() && Integer.parseInt(moninSiropPopcornQuantity)<301){
            productQuantities.put("Monin Sirop Popcorn", "1");
        }
        if(!moninSiropPopcornQuantity.isEmpty() && Integer.parseInt(moninSiropPopcornQuantity)<101){
            productQuantities.put("Monin Sirop Popcorn", "1");
        }
        if(!moninSiropPumpkinSpicedQuantity.isEmpty() && Integer.parseInt(moninSiropPumpkinSpicedQuantity)<301){
            productQuantities.put("Monin Sirop PumpkinSpiced", "1");
        }
        if(!moninSiropRedBerries2Quantity.isEmpty() && Integer.parseInt(moninSiropRedBerries2Quantity)<401){
            productQuantities.put("Monin Sirop Red Berries", "1");
        }
        if(!moninSiropRoseQuantity.isEmpty() && Integer.parseInt(moninSiropRoseQuantity)<401){
            productQuantities.put("Monin Sirop Rose", "1");
        }
        if(!moninSiropVanillieQuantity.isEmpty() && Integer.parseInt(moninSiropVanillieQuantity)<401){
            productQuantities.put("Monin Sirop Vanilie", "1");
        }
        if(!moninSiropBlackCurrantQuantity.isEmpty() && Integer.parseInt(moninSiropBlackCurrantQuantity)<301){
            productQuantities.put("Monin Sirop BlackCurrant", "1");
        }
        if(!moninPiureStrawberryQuantity.isEmpty() && Integer.parseInt(moninPiureStrawberryQuantity)<2){
            productQuantities.put("Monin Piure Strawberry", "1");
        }
        if(!moninPiurePassionFruitQuantity.isEmpty() && Integer.parseInt(moninPiurePassionFruitQuantity)<2){
            productQuantities.put("Monin Pire Passion Fruit", "1");
        }
        if(!moninSiropWatermelonQuantity.isEmpty() && Integer.parseInt(moninSiropWatermelonQuantity)<501){
            productQuantities.put("Monin Sirop Watermelon", "1");
        }
        if(!moninSiropSocQuantity.isEmpty() && Integer.parseInt(moninSiropSocQuantity)<701){
            productQuantities.put("Monin Sirop Soc", "1");
        }
        if(!ungheniBalsamQuantity.isEmpty() && Integer.parseInt(ungheniBalsamQuantity)<301){
            productQuantities.put("Ungheni Balsam", "1");
        }
        if(!ungheniRachiuCaiseQuantity.isEmpty() && Integer.parseInt(ungheniRachiuCaiseQuantity)<301){
            productQuantities.put("Ungheni Rachiu Caise", "1");
        }
        if(!grandeVentoBrutQuantity.isEmpty() && Integer.parseInt(grandeVentoBrutQuantity)<6){
            productQuantities.put("Grande Vento Brut", "1");
        }
        if(!grandeVentoRoseQuantity.isEmpty() && Integer.parseInt(grandeVentoRoseQuantity)<4){
            productQuantities.put("Grande Vento Rose", "1");
        }

        if(!bulleitBourbonQuantity.isEmpty() && Integer.parseInt(bulleitBourbonQuantity)<401){
            productQuantities.put("Bulleit Bourbon", "1");
        }
        if(!sanPellegrino033ArranciataQuantity.isEmpty() && Integer.parseInt(sanPellegrino033ArranciataQuantity)<6){
            productQuantities.put("San Pellegrino 0.33 Arranciata", "6");
        }
        if(!sanPellegrino033PompelmoQuantity.isEmpty() && Integer.parseInt(sanPellegrino033PompelmoQuantity)<6){
            productQuantities.put("San Pellegrino 0.33 Pompelmo", "6");
        }
        if(!sanPellegrino033TonicQuantity.isEmpty() && Integer.parseInt(sanPellegrino033TonicQuantity)<6){
            productQuantities.put("San Pellegrino 0.33 Tonic", "6");
        }
        if(!tiaMariaQuantity.isEmpty() && Integer.parseInt(tiaMariaQuantity)<301){
            productQuantities.put("Tia Maria", "1");
        }
        if(!zacapa23Quantity.isEmpty() && Integer.parseInt(zacapa23Quantity)<201){
            productQuantities.put("Zacapa 23", "1");
        }
        if(!zacapaXOQuantity.isEmpty() && Integer.parseInt(zacapaXOQuantity)<201){
            productQuantities.put("Zacapa XO", "1");
        }
        if(!sanPellegrino033ArranciataRossaQuantity.isEmpty() && Integer.parseInt(sanPellegrino033ArranciataRossaQuantity)<6){
            productQuantities.put("San Pellegrino 0.33 Arranciata Rossa", "6");
        }
        if(!amaroAvernaQuantity.isEmpty() && Integer.parseInt(amaroAvernaQuantity)<401){
            productQuantities.put("Amaro Averna", "1");
        }

        if(!johnnieWalkerBlackHighBallQuantity.isEmpty() && Integer.parseInt(johnnieWalkerBlackHighBallQuantity)<201){
            productQuantities.put("Johnnie Walker Black HighBall", "1");
        }
        if(!johnnieWalkerRedHighBallQuantity.isEmpty() && Integer.parseInt(johnnieWalkerRedHighBallQuantity)<201){
            productQuantities.put("Johnnie Walker Red HighBall", "1");
        }
        if(!bulleitBourbonQuantity.isEmpty() && Integer.parseInt(bulleitBourbonQuantity)<401){
            productQuantities.put("Bulleit Bourbon", "1");
        }
        if(!sanPellegrino0750Quantity.isEmpty() && Integer.parseInt(sanPellegrino0750Quantity)<5){
            int n46=4-Integer.parseInt(sanPellegrino0750Quantity);
            productQuantities.put("San Pellegrino 0.750", String.valueOf(n46));
        }




        // Adăugăm produsele în listă în ordinea în care au fost introduse
        for (Map.Entry<String, String> entry : productQuantities.entrySet()) {
            productList.add(new ProductData(entry.getKey(), entry.getValue()));
        }
    }



    private void setupRecyclerView() {
        ResultAdapterGrosbi adapter = new ResultAdapterGrosbi(productList);
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
