package ru.mephi.quest2;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {
    private int cartID;
    ArrayList<Item> items;
    private int itemCount;
    private transient double cartTotal;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.itemCount = 0;
        this.cartTotal = 0;
    }

    public int getCartID() {
        return cartID;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public int getItemCount() {
        return itemCount;
    }


    public void addItems(ArrayList<Item> items) {
        items.stream()
                .forEach(p -> this.items.add(this.itemCount++, p));
    }

}
