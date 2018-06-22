package com.debugnotes.example.producer.model;

public class ProfileData {

    private int id;
    private String[] cards;

    public ProfileData() {
    }

    public ProfileData(int id, String[] cards) {
        setId(id);
        setCards(cards);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }
}