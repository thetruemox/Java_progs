package ru.mephi.quest2;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(0, new Item(0, "gtx1050ti", 20));
        items.add(1, new Item(1, "gt650", 8));
        items.add(2, new Item(2, "gtx2060", 80));
        items.add(3, new Item(3, "gt1080ti", 55));

        cart.addItems(items);

//        cart.items.stream()
//                .map(Item::getDescription)
//                .forEach(System.out::println);

        try {
            FileOutputStream fos = new FileOutputStream("cart.txt");
            ObjectOutputStream obj_os = new ObjectOutputStream(fos);
            obj_os.writeObject(cart);
            obj_os.close();

            FileInputStream fis = new FileInputStream("cart.txt");
            ObjectInputStream obj_is = new ObjectInputStream(fis);

            ShoppingCart cart2 = (ShoppingCart) obj_is.readObject();
            cart2.items.stream()
                .map(Item::getDescription)
                .forEach(System.out::println);


        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
