package ru.mephi.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
  public static void main(String[] args) {


    try{ // Add Try with resources here

        Stream<Path> files = Files.list(Paths.get("."));

        System.out.println("\n=== Dir list ===");
        // Print directory list here
        files.forEach(line -> System.out.println(line));
    
    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}
