package com.kursach.salvadora2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.kursach.salvadora2.fragments.ScrollFragment;
import com.kursach.salvadora2.fragments.TableSecondFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private Deck deck;

    private GameInfo gameInfo;

    Score score;

    private ArrayList<Player> players;

    private String association;

    private Card mainCard;

    private int step = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        deck = new Deck(this);
        deck.loadCards();
        deck.shuffleDeck();

        gameInfo = GameInfo.getInstance();

        players = gameInfo.getPlayers();

        score = Score.getInstance();
        score.createScoresMap(players);

        ScrollFragment scrollFragment = new ScrollFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container2, scrollFragment).commit();

    }

    public Deck getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getMainPlayer() {
        for (Player player : players) {
            if (player.isMainPlayer())
                return player;
        }
        return null;
    }

    //Смена ведущего. Ведущий всегда первый в ArrayList.
    public void nextMainPlayer() {
        for (int i = 0; i < players.size(); ++i) {
            Player player = players.get(i);
            if (player.isMainPlayer()) {
                player.setMainPlayer(false);
                players.get(players.size() - 1).setMainPlayer(true);

                Player mainPlayer = getMainPlayer();
                players.remove(mainPlayer);
                players.add(0, mainPlayer);
                break;
            }
        }
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Card getMainCard() {
        return mainCard;
    }

    public void setMainCard(Card mainCard) {
        this.mainCard = mainCard;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public void nextStep() {
        ++step;
        //Если шаг не первый и не последний
        if ((step != gameInfo.getPlayersCount()) && (step != 0)) {
            ScrollFragment tableSecondFragment = new ScrollFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container2,
                    tableSecondFragment).commit();

        }
        if (step == gameInfo.getPlayersCount()) {
            step = 0;
            nextMainPlayer();
            ScrollFragment tableSecondFragment = new ScrollFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container2,
                    tableSecondFragment).commit();
        }
    }

    public void nextAlternativeStep() {
        ++step;
    }

    @Override
    public void onBackPressed() {

    }
}
