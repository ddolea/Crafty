package Crafty.example.plict6.ActivitatiPrincipale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import Crafty.example.plict6.R;

public class ResultAdapterGrosbi extends RecyclerView.Adapter<ResultAdapterGrosbi.ResultGrosbiViewHolder> {

    private final List<ResultActivityGrosbi.ProductData> productList;

    public ResultAdapterGrosbi(List<ResultActivityGrosbi.ProductData> productList) {
        this.productList = productList;

    }

    @NonNull
    @Override
    public ResultGrosbiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_grosbi_finishing, parent, false);
        return new ResultGrosbiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultGrosbiViewHolder holder, int position) {
        ResultActivityGrosbi.ProductData product = productList.get(position);
        holder.productNameTextView1.setText(product.getProductName());
        holder.productQuantityTextView1.setText(product.getQuantity());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class ResultGrosbiViewHolder extends RecyclerView.ViewHolder {
        public TextView productNameTextView1;
        public TextView productQuantityTextView1;

        public ResultGrosbiViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView1 = itemView.findViewById(R.id.productNameTextView1);
            productQuantityTextView1 = itemView.findViewById(R.id.productNumberEditText1);
        }
    }

}
