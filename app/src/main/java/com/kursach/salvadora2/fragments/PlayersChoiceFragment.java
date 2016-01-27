package com.kursach.salvadora2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kursach.salvadora2.GameInfo;
import com.kursach.salvadora2.R;

public class PlayersChoiceFragment extends Fragment implements View.OnClickListener {

    private ImageView ivWanshitong;
    private ImageView ivMomo;
    private ImageView ivGodOfForest;
    private ImageView ivRepka;
    private ImageView ivKamajji;
    private ImageView ivTotoro;
    private ImageView ivFaceless;

    private LinearLayout ivHolder;

    private GameInfo gameInfo;

    private int playersCount;

    private int playerNumber = 1;

    public PlayersChoiceFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_players_choice, container, false);

        ivWanshitong = (ImageView) v.findViewById(R.id.ivWanshitong);
        ivMomo = (ImageView) v.findViewById(R.id.ivMomo);
        ivGodOfForest = (ImageView) v.findViewById(R.id.ivGodOfForest);
        ivRepka = (ImageView) v.findViewById(R.id.ivRepka);
        ivKamajji = (ImageView) v.findViewById(R.id.ivKamajji);
        ivTotoro = (ImageView) v.findViewById(R.id.ivTotoro);
        ivFaceless = (ImageView) v.findViewById(R.id.ivFaceless);

        ivHolder = (LinearLayout) v.findViewById(R.id.ivHolder);

        ivWanshitong.setOnClickListener(this);
        ivMomo.setOnClickListener(this);
        ivGodOfForest.setOnClickListener(this);
        ivRepka.setOnClickListener(this);
        ivKamajji.setOnClickListener(this);
        ivTotoro.setOnClickListener(this);
        ivFaceless.setOnClickListener(this);

        gameInfo = GameInfo.getInstance();
        playersCount = gameInfo.getPlayersCount();

        return v;
    }

    @Override
    public void onClick(View v) {


        AddPlayerDialogFragment dialogFragment;

        switch (v.getId()) {
            case R.id.ivWanshitong:
                dialogFragment = AddPlayerDialogFragment.newInstance(playerNumber, 0);
                dialogFragment.show(getActivity().getSupportFragmentManager(), "AddPlayer");
                ivHolder.removeView(ivWanshitong);
                break;
            case R.id.ivMomo:
                dialogFragment = AddPlayerDialogFragment.newInstance(playerNumber, 1);
                dialogFragment.show(getActivity().getSupportFragmentManager(), "AddPlayer");
                ivHolder.removeView(ivMomo);
                break;
            case R.id.ivGodOfForest:
                dialogFragment = AddPlayerDialogFragment.newInstance(playerNumber, 2);
                dialogFragment.show(getActivity().getSupportFragmentManager(), "AddPlayer");
                ivHolder.removeView(ivGodOfForest);
                break;
            case R.id.ivRepka:
                dialogFragment = AddPlayerDialogFragment.newInstance(playerNumber, 3);
                dialogFragment.show(getActivity().getSupportFragmentManager(), "AddPlayer");
                ivHolder.removeView(ivRepka);
                break;
            case R.id.ivKamajji:
                dialogFragment = AddPlayerDialogFragment.newInstance(playerNumber, 4);
                dialogFragment.show(getActivity().getSupportFragmentManager(), "AddPlayer");
                ivHolder.removeView(ivKamajji);
                break;
            case R.id.ivTotoro:
                dialogFragment = AddPlayerDialogFragment.newInstance(playerNumber, 5);
                dialogFragment.show(getActivity().getSupportFragmentManager(), "AddPlayer");
                ivHolder.removeView(ivTotoro);
                break;
            case R.id.ivFaceless:
                dialogFragment = AddPlayerDialogFragment.newInstance(playerNumber, 6);
                dialogFragment.show(getActivity().getSupportFragmentManager(), "AddPlayer");
                ivHolder.removeView(ivFaceless);
                break;
        }
        playerNumber++;
    }
}
