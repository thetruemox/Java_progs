package ru.mephi.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {
    
    public static void main(String[] args) {

        try{ // Create Try with Resources here
            BufferedReader bufInput = new BufferedReader(new FileReader("hamlet.txt"));

            System.out.println("\n=== Entire File ===");
            // print lines here

            bufInput.lines()
                    .forEach(line ->
                            System.out.println("line: " + line));


        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    } 
}
