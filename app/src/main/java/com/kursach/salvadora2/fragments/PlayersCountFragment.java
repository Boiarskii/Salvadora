package com.kursach.salvadora2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.kursach.salvadora2.GameInfo;
import com.kursach.salvadora2.R;


public class PlayersCountFragment extends Fragment {

    EditText etPlayersCount;
    ImageButton nextButton;

    GameInfo gameInfo;

    public PlayersCountFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_players_count, container, false);
        gameInfo = GameInfo.getInstance();

        etPlayersCount = (EditText) v.findViewById(R.id.etPlayersCount);

        nextButton = (ImageButton) v.findViewById(R.id.playersCountNextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int playersCount = Integer.parseInt(etPlayersCount.getText().toString());
                if ((playersCount <= 7)&&(playersCount >= 3)) {
                    gameInfo.setPlayersCount(playersCount);
                    //Старт обучающего активити
                }
            }
        });

        return v;
    }
}
