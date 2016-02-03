package com.kursach.salvadora2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kursach.salvadora2.AssociationDialogFragment;
import com.kursach.salvadora2.Card;
import com.kursach.salvadora2.Deck;
import com.kursach.salvadora2.GameActivity;
import com.kursach.salvadora2.ItemClickSupport;
import com.kursach.salvadora2.Player;
import com.kursach.salvadora2.R;
import com.kursach.salvadora2.TableRecyclerViewAdapter;

import java.util.ArrayList;

public class TableSecondFragment extends Fragment {

    RecyclerView recyclerView;
    TextView tvAssociation;

    int step;
    Player player;

    Deck deck;

    public TableSecondFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_table_second, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.tableRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final GameActivity activity = (GameActivity) getActivity();
        //Узнаю какой сейчас шаг, получаю игрока
        step = activity.getStep();
        player = activity.getPlayers().get(step);

        tvAssociation = (TextView) v.findViewById(R.id.tvAssociation);
        tvAssociation.setText(activity.getAssociation());

        deck = activity.getDeck();

        fulfillCards();

        final ArrayList<Card> cards = player.getCards();

        TableRecyclerViewAdapter tableRecyclerViewAdapter = new TableRecyclerViewAdapter(cards);
        recyclerView.setAdapter(tableRecyclerViewAdapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                player.setPlayerMainCard(cards.get(position));
                activity.setMainCard(cards.get(position));
                player.removePlayerCard(position);
                activity.nextStep();
            }
        });

        return v;
    }

    private void fulfillCards() {
        while (player.getPlayerCardsCount() != 6) {
            player.addPlayerCard(deck.getCard());
        }
    }

}
