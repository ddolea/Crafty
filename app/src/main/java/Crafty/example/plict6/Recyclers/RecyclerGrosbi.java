package Crafty.example.plict6.Recyclers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import Crafty.example.plict6.ActivitatiSecundareGrosbi.Activity22;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG0;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG1;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG10;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG11;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG12;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG13;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG14;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG15;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG16;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG17;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG18;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG19;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG2;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG21;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG3;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG4;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG5;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG6;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG7;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG8;
import Crafty.example.plict6.ActivitatiSecundareGrosbi.ActivityG9;
import Crafty.example.plict6.R;


import java.util.ArrayList;

public class RecyclerGrosbi extends RecyclerView.Adapter<RecyclerGrosbi.grosbiViewHolder> {
    private final ArrayList<String> grosbiNameList;
    private final Context context;

    public RecyclerGrosbi(ArrayList<String> grosbiNameList, Context context) {
        this.grosbiNameList = grosbiNameList;
        this.context = context;
    }

    @NonNull
    @Override
    public grosbiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_grosbi, parent, false);
        return new grosbiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull grosbiViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String grosbiName = grosbiNameList.get(position);
        holder.textView.setText(grosbiName);
        holder.cardView2.setOnClickListener(v -> {
            int switchedPosition = holder.getAdapterPosition();

            switch(switchedPosition){
                case 0:
                    Intent intentg0=new Intent(context, ActivityG0.class);
                    context.startActivity(intentg0);
                    break;
                case 1:
                    Intent intentg1=new Intent(context, ActivityG1.class);
                    context.startActivity(intentg1);
                    break;
                case 2:
                    Intent intentg2=new Intent(context, ActivityG2.class);
                    context.startActivity(intentg2);
                    break;
                case 3:
                    Intent intentg3=new Intent(context, ActivityG3.class);
                    context.startActivity(intentg3);
                    break;
                case 4:
                    Intent intentg4=new Intent(context, ActivityG4.class);
                    context.startActivity(intentg4);
                    break;
                case 5:
                    Intent intentg5=new Intent(context, ActivityG5.class);
                    context.startActivity(intentg5);
                    break;
                case 6:
                    Intent intentg6=new Intent(context, ActivityG6.class);
                    context.startActivity(intentg6);
                    break;
                case 7:
                    Intent intentg7=new Intent(context, ActivityG7.class);
                    context.startActivity(intentg7);
                    break;
                case 8:
                    Intent intentg8=new Intent(context, ActivityG8.class);
                    context.startActivity(intentg8);
                    break;
                case 9:
                    Intent intentg9=new Intent(context, ActivityG9.class);
                    context.startActivity(intentg9);
                    break;
                case 10:
                    Intent intentg10=new Intent(context, ActivityG10.class);
                    context.startActivity(intentg10);
                    break;
                case 11:
                    Intent intentg11=new Intent(context, ActivityG11.class);
                    context.startActivity(intentg11);
                    break;
                case 12:
                    Intent intentg12=new Intent(context, ActivityG12.class);
                    context.startActivity(intentg12);
                    break;
                case 13:
                    Intent intentg13=new Intent(context, ActivityG13.class);
                    context.startActivity(intentg13);
                    break;
                case 14:
                    Intent intentg14=new Intent(context, ActivityG14.class);
                    context.startActivity(intentg14);
                    break;
                case 15:
                    Intent intentg15=new Intent(context, ActivityG15.class);
                    context.startActivity(intentg15);
                    break;
                case 16:
                    Intent intentg16=new Intent(context, ActivityG16.class);
                    context.startActivity(intentg16);
                    break;
                case 17:
                    Intent intentg17=new Intent(context, ActivityG17.class);
                    context.startActivity(intentg17);
                    break;
                case 18:
                    Intent intentg18=new Intent(context, ActivityG18.class);
                    context.startActivity(intentg18);
                    break;
                case 19:
                    Intent intentg19=new Intent(context, ActivityG19.class);
                    context.startActivity(intentg19);
                    break;
                case 20:
                    Intent intentg20=new Intent(context, ActivityG21.class);
                    context.startActivity(intentg20);
                    break;
                case 21:
                    Intent intentg21=new Intent(context, Activity22.class);
                    context.startActivity(intentg21);
                    break;


                default:
            }
        });
    }

    @Override
    public int getItemCount() {
        return grosbiNameList.size();
    }

    public static class grosbiViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardView2;

        public grosbiViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textGrosbi);
            cardView2 = itemView.findViewById(R.id.cardGrosbi);
        }
    }
}