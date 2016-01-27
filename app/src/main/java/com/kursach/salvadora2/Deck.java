package com.kursach.salvadora2;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс для работы с колодой
 */
public class Deck {

    private Context context;

    private ArrayList<Card> cards = new ArrayList<>();

    public Deck(Context context) {
        this.context = context;
    }

    public void loadCards() {
        try {
            cards.clear();
            AssetManager am = context.getAssets();
            String[] files = am.list("Cards");
            InputStream istr = null;

            for (String file : files) {
                Drawable d = Drawable.createFromStream(am.open("Cards/" + file), null);
                Card card = new Card(d);
                cards.add(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

}
