package ru.mephi;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Exeptions {
    public static void main(String[] args) {
        try {
            int a[] = new int[1];
            System.out.println(a[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        };

        try {
            Scanner inputFile = new Scanner(new File("notReal.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        };

        try {
            ((Object) null).toString();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        };

        try {
            FileWriter fw = new FileWriter("file.txt", true);
            fw.write("smth");
            fw.close();
            fw.write("smth2");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        };

        try {
            Object str = "a";
            Integer num = (int)str;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        };

        try {
            System.out.println(1/0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        };

        //StackOverflowError
        //Exeptions.recursivePrint(1);

        //OutOfMemoryError
        /*
        List<Object[]> arrays = new LinkedList<>();
        for (; ; ) {
            arrays.add(new Object[100]);
        }
        */
    }

    public static void recursivePrint(int num) {
        if (num == 0)
            return;
        else
            recursivePrint(++num);
    }
}
