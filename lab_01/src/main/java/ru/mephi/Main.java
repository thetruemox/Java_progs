package ru.mephi;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name;

        while (scanner.hasNext())
        {
            name = scanner.next();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        System.out.println(map);


    }
}


/*


public class Main {
    public static void main(String[] args) {
        Map map = new Map();

        map.put("agabatY", 124);
        map.put("agabatY", 23248);
        map.put("agabatY", 5637);
        //map.remove("agabatY");

        System.out.println(map.get("agabatY"));
    }
}
*/