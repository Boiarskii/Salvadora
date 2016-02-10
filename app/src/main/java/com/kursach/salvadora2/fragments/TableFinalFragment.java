package com.kursach.salvadora2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kursach.salvadora2.Card;
import com.kursach.salvadora2.Deck;
import com.kursach.salvadora2.GameActivity;
import com.kursach.salvadora2.GameInfo;
import com.kursach.salvadora2.ItemClickSupport;
import com.kursach.salvadora2.Player;
import com.kursach.salvadora2.R;
import com.kursach.salvadora2.Score;
import com.kursach.salvadora2.TableRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;


public class TableFinalFragment extends Fragment {

    RecyclerView recyclerView;
    TextView tvAssociation;

    int step;
    Player player;

    GameActivity activity;

    Deck deck;

    Score score;

    public TableFinalFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_table_second, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.tableRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        activity = (GameActivity) getActivity();
        //Узнаю какой сейчас шаг, получаю игрока
        step = activity.getStep();
        player = activity.getPlayers().get(step);

        tvAssociation = (TextView) v.findViewById(R.id.tvAssociation);
        tvAssociation.setText(player.getName() + ", угадайте карту ведущего");

        score = Score.getInstance();

        final ArrayList<Card> cards = getFinalCards();

        TableRecyclerViewAdapter tableRecyclerViewAdapter = new TableRecyclerViewAdapter(cards);
        recyclerView.setAdapter(tableRecyclerViewAdapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                //Игрок нажал на эту карту
                Card chosenCard = cards.get(position);

                //Если карта отгадана верно
                if (chosenCard.equals(activity.getMainCard())) {
                    score.changePlayerScore(player, 3);
                    Log.d("MyLogs", player.getName() + " имеет очков " + score.getPlayerScore(player));
                    score.upCorrectCounter();


                } else {
                    score.changePlayerScore(findCardHost(chosenCard), 1);
                    Log.d("MyLogs", findCardHost(chosenCard).getName() + " имеет очков " + score.getPlayerScore(findCardHost(chosenCard)));
                }

                if (step == (GameInfo.getInstance().getPlayersCount() - 1)) {

                    //Если никто не угадал карту ведущего
                    if (score.getCorrectCounter() == 0) {
                        score.changePlayerScore(activity.getMainPlayer(), -2);
                    } else
                        //Если все отгадали карту ведущего
                        if (score.getCorrectCounter() == (GameInfo.getInstance().getPlayersCount() - 1)) {
                            score.changePlayerScore(activity.getMainPlayer(), -3);
                        } else
                            //Если хотя бы 1 отгадал, и хотя бы 1 не отгадал
                            score.changePlayerScore(activity.getMainPlayer(), (score.getCorrectCounter() + 3));

                    //Показать экран результатов
                    Log.d("MyLogs", activity.getMainPlayer().getName() + " имеет очков " + score.getPlayerScore(activity.getMainPlayer()));
                    activity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container2, new ScoreFragment()).commit();

                } else {
                    activity.nextAlternativeStep();
                    activity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container2, new ScrollSecondFragment()).commit();
                }
            }
        });


        return v;
    }

    private ArrayList<Card> getFinalCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (Player p : activity.getPlayers()) {
            if (!(p.equals(player))) {
                cards.add(p.getPlayerCard());

            }
        }
        Collections.shuffle(cards);
        return cards;
    }

    private Player findCardHost(Card card) {
        for (Player player : activity.getPlayers()) {
            if (player.getPlayerCard().equals(card)) {
                return player;
            }
        }
        return null;
    }
}
