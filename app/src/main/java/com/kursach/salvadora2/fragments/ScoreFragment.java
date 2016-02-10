package com.kursach.salvadora2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kursach.salvadora2.GameActivity;
import com.kursach.salvadora2.R;
import com.kursach.salvadora2.Score;

public class ScoreFragment extends Fragment {

    ImageView resultCard;
    TextView tvScore;

    GameActivity activity;
    Score score;


    public ScoreFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);

        resultCard = (ImageView) v.findViewById(R.id.resultCard);
        tvScore = (TextView) v.findViewById(R.id.tvScore);

        activity = (GameActivity) getActivity();
        score = Score.getInstance();

        resultCard.setImageDrawable(activity.getMainCard().getCardImage());
        tvScore.setText(score.formScoreString());

        resultCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.resetCorrectCounter();
                activity.nextStep();
            }
        });

        return v;
    }
}
