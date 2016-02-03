package com.kursach.salvadora2;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Player {

    private String name;
    private int portraitNumber;
    private boolean mainPlayer;
    private Card playerMainCard;
    private ArrayList<Card> cards;

    public Player(String name, int portraitNumber, boolean mainPlayer) {
        this.name = name;
        this.portraitNumber = portraitNumber;
        this.mainPlayer = mainPlayer;
        cards = new ArrayList<>();
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

    public Card getPlayerCard() {
        return playerMainCard;
    }

    public void setPlayerMainCard(Card playerCard) {
        this.playerMainCard = playerCard;
    }

    public void addPlayerCard(Card card) {
        cards.add(card);
    }

    public void removePlayerCard(int position) {
        cards.remove(position);
    }

    public int getPlayerCardsCount() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
