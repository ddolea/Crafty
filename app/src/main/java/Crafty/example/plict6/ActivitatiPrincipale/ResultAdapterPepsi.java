package Crafty.example.plict6.ActivitatiPrincipale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import Crafty.example.plict6.R;

public class ResultAdapterPepsi extends RecyclerView.Adapter<ResultAdapterPepsi.ResultPepsiViewHolder> {

    private final List<ResultActivityPepsi.ProductData> productList;

    public ResultAdapterPepsi(List<ResultActivityPepsi.ProductData> productList) {
        this.productList = productList;

    }

    @NonNull
    @Override
    public ResultPepsiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pepsi_finishing, parent, false);
        return new ResultPepsiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultPepsiViewHolder holder, int position) {
        ResultActivityPepsi.ProductData product = productList.get(position);
        holder.productNameTextView4.setText(product.getProductName());
        holder.productQuantityTextView4.setText(product.getQuantity());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class ResultPepsiViewHolder extends RecyclerView.ViewHolder {
        public TextView productNameTextView4;
        public TextView productQuantityTextView4;

        public ResultPepsiViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView4 = itemView.findViewById(R.id.productNameTextView4);
            productQuantityTextView4 = itemView.findViewById(R.id.productNumberEditText4);
        }
    }

}
