package com.kursach.salvadora2.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.kursach.salvadora2.Card;
import com.kursach.salvadora2.GameActivity;
import com.kursach.salvadora2.Player;
import com.kursach.salvadora2.PortraitContainer;
import com.kursach.salvadora2.R;

import java.util.ArrayList;

public class ScrollFragment extends Fragment {

    private ImageView ivScrollPortrait;
    private ImageView scrollBg;
    private ImageView deck;

    private Player player;

    private PortraitContainer portraitContainer;

    private int step;

    public ScrollFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_scroll, container, false);

        GameActivity activity = (GameActivity) getActivity();

        ivScrollPortrait = (ImageView) v.findViewById(R.id.ivScrollPortrait);
        scrollBg = (ImageView) v.findViewById(R.id.scrollBg);
        deck = (ImageView) v.findViewById(R.id.deck);

        portraitContainer = new PortraitContainer(getContext());

        //Узнаю какой сейчас шаг, получаю игрока
        step = activity.getStep();
        player = activity.getPlayers().get(step);

        //Если игрок главый, ....
        if (activity.getMainPlayer().equals(player)) {
            scrollBg.setImageResource(R.drawable.scroll);
            deck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TableMainFragment tableMainFragment = new TableMainFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container2, tableMainFragment).commit();
                }
            });
        } else {
            scrollBg.setImageResource(R.drawable.scroll2);
            deck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TableSecondFragment tableSecondFragment = new TableSecondFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container2, tableSecondFragment).commit();
                }
            });
        }

        ivScrollPortrait.setImageDrawable(portraitContainer.getSecondPortrait(player.getPortraitNumber()));

        return v;
    }
}
