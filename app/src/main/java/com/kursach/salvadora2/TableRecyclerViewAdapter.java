package com.kursach.salvadora2;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class TableRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Card> cards;

    public TableRecyclerViewAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(v);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CardViewHolder) holder).card.setImageDrawable(cards.get(position).getCardImage());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    private static class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView card;

        public CardViewHolder(View itemView) {
            super(itemView);
            card = (ImageView) itemView.findViewById(R.id.card);
        }
    }
}
