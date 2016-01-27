package com.kursach.salvadora2;

import android.graphics.drawable.Drawable;

public class Player {

    private String name;
    private int portraitNumber;
    private boolean mainPlayer;

    public Player(String name, int portraitNumber, boolean mainPlayer) {
        this.name = name;
        this.portraitNumber = portraitNumber;
        this.mainPlayer = mainPlayer;
    }

    public String getName() {
        return name;
    }

    public int getPortraitNumber() {
        return portraitNumber;
    }

    public boolean isMainPlayer() {
        return mainPlayer;
    }

    public void setMainPlayer(boolean mainPlayer) {
        this.mainPlayer = mainPlayer;
    }
}
