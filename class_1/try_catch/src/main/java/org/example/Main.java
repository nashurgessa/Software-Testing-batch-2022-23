package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //1. try-catch block
        try {
            // Code that may throw an exception
            int data = 50 / 0;
        } catch(ArithmeticException errorMessage) {
            // Handling Exception
            System.out.println(errorMessage);
        }

        // 2. Multiple Catch Block
        try {
            int[] numbers = new int[5];
            numbers[10] = 30 / 2;

        } catch (ArithmeticException e) {
            throw e;
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }


        // Finally block Example
        try {
            // Code that may throw an exception
            int data = 50 / 0;
        } catch(ArithmeticException errorMessage) {
            // Handling Exception
            System.out.println(errorMessage);
        } finally {
            System.out.println("The 'try-catch' block is finished");
        }

        // Try-with-Resource
        try {
            FileReader fileReader = new FileReader("file.txt");
            int i;
            // read a file and return -1 when reach end
            int data = fileReader.read();
            while (data != -1) {
                System.out.println((char) data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " +e);;
        } catch (IOException e) {
            System.out.println("Error while reading the file");;
        }
    }
}