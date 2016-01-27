package com.kursach.salvadora2;

import android.graphics.drawable.Drawable;

import java.util.UUID;

/**
 * Карточка
 */
public class Card {

    private UUID id;
    private Drawable cardImage;

    public Card(Drawable cardImage) {
        this.id = UUID.randomUUID();
        this.cardImage = cardImage;
    }

    public UUID getId() {
        return id;
    }

    public Drawable getCardImage() {
        return cardImage;
    }
}
