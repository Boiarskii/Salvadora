package com.kursach.salvadora2;


import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Score {

    private Map<Player, Integer> scores;

    private int correctCounter = 0;

    private static Score ourInstance = new Score();

    public static Score getInstance() {
        return ourInstance;
    }

    private Score() {
        scores = new HashMap<>();
    }

    public void createScoresMap(ArrayList<Player> players) {
        for (Player player : players) {
            scores.put(player, 0);
        }
    }

    public int getPlayerScore(Player player) {
        return scores.get(player);
    }

    public void changePlayerScore(Player player, int pts) {
        scores.put(player, scores.get(player) + pts);
    }

    public void upCorrectCounter() {
        correctCounter++;
    }

    public int getCorrectCounter() {
        return correctCounter;
    }

    public void resetCorrectCounter() {
        correctCounter = 0;
    }

    public String formScoreString() {
        String s = "";
        for (Map.Entry<Player, Integer> entry : scores.entrySet()) {
            s += entry.getKey().getName() + " - " + entry.getValue() + "\n";
        }
        return s;
    }
}
