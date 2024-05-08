package Crafty.example.plict6.ActivitatiPrincipale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import Crafty.example.plict6.R;

public class ResultAdapterNecesar extends RecyclerView.Adapter<ResultAdapterNecesar.ResultNecesarViewHolder> {

    private final List<ResultActivityNecesar.ProductData> productList;

    public ResultAdapterNecesar(List<ResultActivityNecesar.ProductData> productList) {
        this.productList = productList;

    }

    @NonNull
    @Override
    public ResultNecesarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_necesar_finishing, parent, false);
        return new ResultNecesarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultNecesarViewHolder holder, int position) {
        ResultActivityNecesar.ProductData product = productList.get(position);
        holder.productNameTextView2.setText(product.getProductName());
        holder.productQuantityTextView2.setText(product.getQuantity());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class ResultNecesarViewHolder extends RecyclerView.ViewHolder {
        public TextView productNameTextView2;
        public TextView productQuantityTextView2;

        public ResultNecesarViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView2 = itemView.findViewById(R.id.productNameTextView2);
            productQuantityTextView2 = itemView.findViewById(R.id.productNumberEditText2);
        }
    }

}
