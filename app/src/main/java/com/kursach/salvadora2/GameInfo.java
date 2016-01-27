package com.kursach.salvadora2;

import java.util.ArrayList;

/**
 * Синглтон с важной игровой информацией
 */
public class GameInfo {

    //Количество игроков
    private int playersCount = 0;

    private ArrayList<Player> players;


    private static GameInfo ourInstance = new GameInfo();

    public static GameInfo getInstance() {
        return ourInstance;
    }

    private GameInfo() {
        players = new ArrayList<>();
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(String name, int portraitNumber, boolean mainPlayer) {
        players.add(new Player(name, portraitNumber, mainPlayer));
    }
}
