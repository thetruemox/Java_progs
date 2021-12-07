package ru.mephi.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01BufferedReader {
    
    public static void main(String[] args) {
        
        try{
            BufferedReader bReader = 
                new BufferedReader(new FileReader("hamlet.txt"));

            String line = "";

            System.out.println("=== Entire File ===");
            //print out file here
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
                        
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
