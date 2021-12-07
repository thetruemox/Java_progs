package ru.mephi.quest2;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String description;
    private double cost;

    public Item(int id, String description, double cost) {
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    public int getId() {
        return this.id;
    }

    public double getCost() {
        return  this.cost;
    }

    public String getDescription() {
        return this.description;
    }
}
