package com.kursach.salvadora2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;


import com.kursach.salvadora2.fragments.PlayButtonFragment;

public class MainActivity extends AppCompatActivity {

    GameInfo gameInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameInfo = GameInfo.getInstance();

        ImageView mainActivityBG = (ImageView) findViewById(R.id.mainActivityBG);

        Animation parallax = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        parallax.setDuration(10000);
        parallax.setRepeatCount(-1);
        parallax.setRepeatMode(Animation.REVERSE);
        mainActivityBG.startAnimation(parallax);

        FragmentManager fragmentManager = getSupportFragmentManager();
        PlayButtonFragment playButtonFragment = new PlayButtonFragment();
        fragmentManager.beginTransaction().replace(R.id.container, playButtonFragment).commit();

    }

    public void startGameActivity() {
        startActivity(new Intent(this, GameActivity.class));
    }
}
