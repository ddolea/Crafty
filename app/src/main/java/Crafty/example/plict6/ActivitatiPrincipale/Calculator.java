package Crafty.example.plict6.ActivitatiPrincipale;

import java.io.Serializable;
import java.util.ArrayList;

public class Calculator implements Serializable {

    private ArrayList<Integer> initialValues;
    private int standardValue;

    public Calculator() {
        this.initialValues = new ArrayList<>();
    }
    public void setStandardValue(int value) {
        this.standardValue = value;
    }

    // Adăugarea unei valori inițiale
    public void addInitialValue(int value) {
        initialValues.add(value);
    }

    // Calcularea valorii finale și returnarea acesteia
    public int calculateFinalValue(int standardValue, int position) {
        if (position >= 0 && position < initialValues.size()) {
            int initialValue = initialValues.get(position);
            return standardValue - initialValue;
        }
        return standardValue; // Returnăm valoarea standard dacă nu există o valoare inițială pentru poziția dată
    }

    public int calculateFinalValue(int i) {
        return i;
    }
}
