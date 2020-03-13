package com.example.oneclicktrader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class mAdp extends RecyclerView.Adapter<mAdp.ViewHolder> {
    private ArrayList<phoneItem> phoneItems;
    private CellOnClick mCellOnClick;


    public  static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView iv;
        public TextView  modelT, condT, priceT, colorT;
        CellOnClick cellOnClick;

        public ViewHolder(View itemView, CellOnClick cellOnClick) {
            super(itemView);
            iv = itemView.findViewById(R.id.cell_image);
            modelT = itemView.findViewById(R.id.cell_model);
            condT = itemView.findViewById(R.id.cell_condition);
            priceT = itemView.findViewById(R.id.cell_price);
            colorT = itemView.findViewById(R.id.cell_color);
            this.cellOnClick = cellOnClick;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            cellOnClick.cellOnClick(getAdapterPosition());
        }
    }

    public mAdp(ArrayList<phoneItem> phoneItems, CellOnClick cellOnClick) {
        this.phoneItems = phoneItems;
        this.mCellOnClick = cellOnClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_item, parent, false);
        ViewHolder vh = new ViewHolder(v, mCellOnClick);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        phoneItem pi = phoneItems.get(position);
        holder.iv.setImageResource(pi.getImageSource());
        holder.priceT.setText("$" + pi.getPrice());
        holder.condT.setText(pi.getCondition());
        holder.modelT.setText(pi.getModel());
        holder.colorT.setText(pi.getColor());
    }

    @Override
    public int getItemCount() {
        return phoneItems.size();
    }

    public interface CellOnClick{
        void cellOnClick(int position);
    }
}
