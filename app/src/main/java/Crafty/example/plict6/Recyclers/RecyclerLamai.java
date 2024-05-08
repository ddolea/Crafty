package Crafty.example.plict6.Recyclers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import Crafty.example.plict6.ActivitatiSecundareLamai.IntentL0;
import Crafty.example.plict6.ActivitatiSecundareLamai.IntentL1;
import Crafty.example.plict6.ActivitatiSecundareLamai.IntentL2;
import Crafty.example.plict6.ActivitatiSecundareLamai.IntentL3;
import Crafty.example.plict6.ActivitatiSecundareLamai.IntentL4;
import Crafty.example.plict6.R;


import java.util.ArrayList;

public class RecyclerLamai extends RecyclerView.Adapter<RecyclerLamai.lamaiViewHolder>{
    private final ArrayList<String> lamaiNameList;
    private Context context;

    public ArrayList<String> getLamaiNameList() {
        return lamaiNameList;
    }

    public Context getContext() {
        return context;
    }

    public RecyclerLamai(ArrayList<String> lamaiNameList, Context context) {
        this.lamaiNameList = lamaiNameList;
        this.context = context;
    }
    @NonNull
    @Override
    public lamaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_lamai, parent, false);
        return new lamaiViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull lamaiViewHolder holder, int position) {
        holder.textView.setText(lamaiNameList.get(position));
        holder.cardView.setOnClickListener(v -> {
            int clickedPosition = holder.getAdapterPosition();
            switch (clickedPosition) {
                case 0:
                    Intent intentL0 = new Intent(context, IntentL0.class);
                    context.startActivity(intentL0);
                    break;
                case 1:
                    Intent intentL1 = new Intent(context, IntentL1.class);
                    context.startActivity(intentL1);
                    break;
                case 2:
                    Intent intentL2 = new Intent(context, IntentL2.class);
                    context.startActivity(intentL2);
                    break;
                case 3:
                    Intent intentL3 = new Intent(context, IntentL3.class);
                    context.startActivity(intentL3);
                    break;
                case 4:
                    Intent intentL4 = new Intent(context, IntentL4.class);
                    context.startActivity(intentL4);
                    break;
                default:
                    break;
            }

        });
    }

    private static void onBackPressed() {
    }


    @Override
    public int getItemCount() {
        return lamaiNameList.size();
    }

    public class lamaiViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardView;
        EditText editText;
        Button button;
        public lamaiViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.LamaiText);
            cardView = itemView.findViewById(R.id.cardLamai);
            editText= itemView.findViewById(R.id.RecyclerLamai);
            button=itemView.findViewById(R.id.backButton2);
        }
    }
}

