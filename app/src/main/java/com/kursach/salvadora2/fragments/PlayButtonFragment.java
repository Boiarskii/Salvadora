package com.kursach.salvadora2.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.kursach.salvadora2.GameInfo;
import com.kursach.salvadora2.R;

public class PlayButtonFragment extends Fragment {

    public PlayButtonFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_play_button, container, false);

        ImageView playButton = (ImageView) v.findViewById(R.id.playButton);
        playButton.setImageResource(R.drawable.play_button_animation);

        AnimationDrawable animationDrawable = (AnimationDrawable) playButton.getDrawable();
        animationDrawable.start();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayersCountFragment playersCountFragment = new PlayersCountFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, playersCountFragment)
                        .commit();
            }
        });
        return v;
    }
}
