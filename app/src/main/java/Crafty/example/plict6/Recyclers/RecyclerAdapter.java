package Crafty.example.plict6.Recyclers;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import Crafty.example.plict6.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PepsiViewHolder> {
    private final ArrayList<String> pepsiNameList;
    private final ArrayList<String> editTextValues;
    private final Context context;

    public RecyclerAdapter(ArrayList<String> pepsiNameList, Context context) {
        this.pepsiNameList = pepsiNameList;
        this.context = context;
        this.editTextValues = new ArrayList<>();
        loadEditTextValuesFromPrefs();
    }

    @NonNull
    @Override
    public PepsiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pepsi, parent, false);
        return new PepsiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PepsiViewHolder holder, int position) {
        String pepsiName = pepsiNameList.get(position);
        holder.textView.setText(pepsiName);
        holder.editText.setText(editTextValues.get(position));
        holder.editText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                saveEditTextValuesToPrefs();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pepsiNameList.size();
    }

    public static class PepsiViewHolder extends RecyclerView.ViewHolder {
        private final EditText editText;
        private final TextView textView;

        public PepsiViewHolder(@NonNull View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.editTextText199);
            textView = itemView.findViewById(R.id.pepsiText);
        }
    }

    private void loadEditTextValuesFromPrefs() {
        SharedPreferences prefs = context.getSharedPreferences("EditTextPrefs", Context.MODE_PRIVATE);
        for (int i = 0; i < pepsiNameList.size(); i++) {
            String value = prefs.getString("editTextValue_" + i, "");
            editTextValues.add(value);
        }
    }

    private void saveEditTextValuesToPrefs() {
        SharedPreferences prefs = context.getSharedPreferences("EditTextPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        for (int i = 0; i < pepsiNameList.size(); i++) {
            editor.putString("editTextValue_" + i, editTextValues.get(i));
        }
        editor.apply();
    }
}
