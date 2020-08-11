package com.eduardo.leandro.windowautomation.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eduardo.leandro.windowautomation.R;
import com.eduardo.leandro.windowautomation.model.Historico;
import com.eduardo.leandro.windowautomation.view.DetalhesHistoricoActivity;


import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private final List<Historico> historicos;

    private Context mContext;


    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;


        public HistoryViewHolder(View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    Intent intent = new Intent(mContext, DetalhesHistoricoActivity.class);
                    intent.putExtra("itemTitle", historicos.get(position).getStatus());
                    intent.putExtra("itemDetail", historicos.get(position).getDatetime());
                    mContext.startActivity(intent);


                }
            });
        }


    }

    public HistoryAdapter(List<Historico> historicos, Context context) {
        this.historicos = historicos;
        this.mContext = context;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_history, parent, false);

        HistoryViewHolder hvh = new HistoryViewHolder(v);

        return hvh;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, final int position) {

        holder.itemTitle.setText(historicos.get(position).getStatus());
        holder.itemDetail.setText(historicos.get(position).getDatetime());


    }

    @Override
    public int getItemCount() {

        return historicos != null ? historicos.size() : 0;
    }


}
