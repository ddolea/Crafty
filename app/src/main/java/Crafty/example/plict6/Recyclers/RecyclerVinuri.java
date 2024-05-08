package Crafty.example.plict6.Recyclers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV0;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV1;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV2;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV3;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV4;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV5;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV6;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV7;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV8;
import Crafty.example.plict6.ActivitatiSecundareVinuri.ActivityV9;
import Crafty.example.plict6.R;


import java.util.ArrayList;

public class RecyclerVinuri extends RecyclerView.Adapter<RecyclerVinuri.vinuriViewHolder> {
    private final ArrayList<String> vinuriNameList;
    private final Context context;

    public RecyclerVinuri(ArrayList<String> vinuriNameList, Context context) {
        this.vinuriNameList = vinuriNameList;
        this.context = context;
    }

    @NonNull
    @Override
    public vinuriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_vinuri, parent, false);
        return new vinuriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vinuriViewHolder holder, int position) {
        String vinName = vinuriNameList.get(position);
        holder.textView.setText(vinName);
        holder.cardView.setOnClickListener(v -> {
            int clickedPosition = holder.getAdapterPosition();
            switch (clickedPosition){
                case 0:
                    Intent intentV0=new Intent(context, ActivityV0.class);
                    context.startActivity(intentV0);
                    break;
                case 1:
                    Intent intentV1=new Intent(context, ActivityV1.class);
                    context.startActivity(intentV1);
                    break;
                case 2:
                    Intent intentV2=new Intent(context, ActivityV2.class);
                    context.startActivity(intentV2);
                    break;
                case 3:
                    Intent intentV3=new Intent(context, ActivityV3.class);
                    context.startActivity(intentV3);
                    break;
                case 4:
                    Intent intentV4=new Intent(context, ActivityV4.class);
                    context.startActivity(intentV4);
                    break;
                case 5:
                    Intent intentV5=new Intent(context, ActivityV5.class);
                    context.startActivity(intentV5);
                    break;
                case 6:
                    Intent intentV6=new Intent(context, ActivityV6.class);
                    context.startActivity(intentV6);
                    break;
                case 7:
                    Intent intentV7=new Intent(context, ActivityV7.class);
                    context.startActivity(intentV7);
                    break;
                case 8:
                    Intent intentV8=new Intent(context, ActivityV8.class);
                    context.startActivity(intentV8);
                    break;
                case 9:
                    Intent intentV9=new Intent(context, ActivityV9.class);
                    context.startActivity(intentV9);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public int getItemCount() {
        return vinuriNameList.size();
    }

    public static class vinuriViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardView;

        public vinuriViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.vinuriText);
            cardView = itemView.findViewById(R.id.cardVinuri);
        }
    }
}
