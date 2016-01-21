package com.kursach.salvadora2;


import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.kursach.salvadora2.fragments.AppIntroFirstFragment;

public class IntroActivity extends AppIntro {

    @Override
    public void init(Bundle savedInstanceState) {

        AppIntroFirstFragment appIntroFirstFragment = new AppIntroFirstFragment();

        addSlide(appIntroFirstFragment);
        addSlide(AppIntroFragment.newInstance(
                getResources().getString(R.string.intro_title_second),
                getResources().getString(R.string.intro_description_second),
                R.drawable.darthvader,
                getResources().getColor(R.color.darthVader)));
        addSlide(AppIntroFragment.newInstance(
                getResources().getString(R.string.intro_title_third),
                getResources().getString(R.string.intro_description_third),
                R.drawable.introstep3,
                getResources().getColor(R.color.introStep3)
        ));
        addSlide(AppIntroFragment.newInstance(
                getResources().getString(R.string.intro_title_fourth),
                getResources().getString(R.string.intro_description_fourth),
                R.drawable.introstep4,
                getResources().getColor(R.color.introStep4)
        ));
        addSlide(AppIntroFragment.newInstance(
                getResources().getString(R.string.intro_title_fifth),
                getResources().getString(R.string.intro_description_fifth),
                R.drawable.introstep5,
                getResources().getColor(R.color.introStep5)
        ));


        showSkipButton(true);


    }

    @Override
    public void onSkipPressed() {

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {

    }

    @Override
    public void onSlideChanged() {

    }
}
