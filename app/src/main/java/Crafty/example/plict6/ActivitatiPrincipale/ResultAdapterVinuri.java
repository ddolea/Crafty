package Crafty.example.plict6.ActivitatiPrincipale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import Crafty.example.plict6.R;

public class ResultAdapterVinuri extends RecyclerView.Adapter<ResultAdapterVinuri.ResultVinuriViewHolder> {

    private final List<ResultActivityVinuri.ProductData> productList;

    public ResultAdapterVinuri(List<ResultActivityVinuri.ProductData> productList) {
        this.productList = productList;

    }

    @NonNull
    @Override
    public ResultVinuriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_vinuri_finishing, parent, false);
        return new ResultVinuriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultVinuriViewHolder holder, int position) {
        ResultActivityVinuri.ProductData product = productList.get(position);
        holder.productNameTextView3.setText(product.getProductName());
        holder.productQuantityTextView3.setText(product.getQuantity());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class ResultVinuriViewHolder extends RecyclerView.ViewHolder {
        public TextView productNameTextView3;
        public TextView productQuantityTextView3;

        public ResultVinuriViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView3 = itemView.findViewById(R.id.productNameTextView3);
            productQuantityTextView3 = itemView.findViewById(R.id.productNumberEditText3);
        }
    }

}
