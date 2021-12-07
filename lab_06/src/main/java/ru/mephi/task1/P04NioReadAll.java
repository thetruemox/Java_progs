package ru.mephi.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class P04NioReadAll {
  public static void main(String[] args) {

    try{
        Stream<String> lines = Files.lines(Paths.get("hamlet.txt"));

        System.out.println("\n=== Lord Count ===");
        long wordCount = lines
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(word -> word.contains("lord"))
                .peek(s -> System.out.println("Match: " + s))
                .count();

        System.out.println("Word count: " + wordCount);

        lines = Files.lines(Paths.get("hamlet.txt"));

        System.out.println("\n=== Prison Count ===");
        wordCount = lines
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(word -> word.contains("rison"))
                .peek(s -> System.out.println("Match: " + s))
                .count();
        
        System.out.println("Word count: " + wordCount);            

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}
