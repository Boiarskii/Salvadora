package com.kursach.salvadora2;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;


public class PortraitContainer {

    private Context context;

    private ArrayList<Drawable> firstPortraits;
    private ArrayList<Drawable> secondPortraits;

    public PortraitContainer(Context context) {
        this.context = context;
        loadPortraits();
    }

    private void loadPortraits() {
        firstPortraits = new ArrayList<Drawable>();

        firstPortraits.add(context.getResources().getDrawable(R.drawable.wanshitong));
        firstPortraits.add(context.getResources().getDrawable(R.drawable.momo));
        firstPortraits.add(context.getResources().getDrawable(R.drawable.godofforest));
        firstPortraits.add(context.getResources().getDrawable(R.drawable.repka));
        firstPortraits.add(context.getResources().getDrawable(R.drawable.kamajji));
        firstPortraits.add(context.getResources().getDrawable(R.drawable.totoro));
        firstPortraits.add(context.getResources().getDrawable(R.drawable.faceless));

        secondPortraits = new ArrayList<Drawable>();

        secondPortraits.add(context.getResources().getDrawable(R.drawable.portraitwanshitong));
        secondPortraits.add(context.getResources().getDrawable(R.drawable.portraitmomo));
        secondPortraits.add(context.getResources().getDrawable(R.drawable.portraitgodofforest));
        secondPortraits.add(context.getResources().getDrawable(R.drawable.portraitrepka));
        secondPortraits.add(context.getResources().getDrawable(R.drawable.portraitkamajji));
        secondPortraits.add(context.getResources().getDrawable(R.drawable.portraittotoro));
        secondPortraits.add(context.getResources().getDrawable(R.drawable.portraitfaceless));
    }

    public ArrayList<Drawable> getFirstPortraits() {
        return firstPortraits;
    }

    public ArrayList<Drawable> getSecondPortraits() {
        return secondPortraits;
    }

    public Drawable getFirstPortrait(int portraitNumber) {
        return firstPortraits.get(portraitNumber);
    }

    public Drawable getSecondPortrait(int portraitNumber) {
        return secondPortraits.get(portraitNumber);
    }
}
