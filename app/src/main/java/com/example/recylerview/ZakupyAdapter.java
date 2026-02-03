package com.example.recylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ZakupyAdapter extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder> {

    private ArrayList<Produkt> produkty;
    private LayoutInflater inflater;

    public ZakupyAdapter(Context context,ArrayList<Produkt> produkty) {
        inflater = LayoutInflater.from(context);
        this.produkty = produkty;
    }

    @NonNull
    @Override
    public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.product_layout,parent,false);

        return new ProduktViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduktViewHolder holder, int position) {
        holder.checkBoxView.setText(produkty.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return produkty.size();
    }

    public class ProduktViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public CheckBox checkBoxView;
        ZakupyAdapter zakupyAdapter;

        public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            checkBoxView = itemView.findViewById(R.id.checkBox);
            zakupyAdapter = adapter;
        }

        @Override
        public void onClick(View view) {
            int ktoruProdukt = getLayoutPosition();
            if( produkty.get(ktoruProdukt).isCzyKupione()){
                produkty.get(ktoruProdukt).setCzyKupione(false);
            }
            else{
                produkty.get(ktoruProdukt).setCzyKupione(true);
            }
            checkBoxView.setChecked( produkty.get(ktoruProdukt).isCzyKupione());
            zakupyAdapter.notifyDataSetChanged();
        }
    }
}
