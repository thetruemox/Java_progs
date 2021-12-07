package ru.mephi.quest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        try {
        List<String> fileArr = Files.readAllLines(Paths.get(args[0]));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type string you want to search");

        final String str = in.readLine();

        fileArr.stream()
                .filter(line -> line.toLowerCase(Locale.ROOT).contains(str))
                .forEach(line -> System.out.println(line));

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
