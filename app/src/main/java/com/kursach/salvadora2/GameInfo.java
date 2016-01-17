package com.kursach.salvadora2;

/**
 Синглтон с важной игровой информацией
 */
public class GameInfo {

    //Количество игроков
    private int playersCount = 0;


    private static GameInfo ourInstance = new GameInfo();

    public static GameInfo getInstance() {
        return ourInstance;
    }

    private GameInfo() {
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }
}
