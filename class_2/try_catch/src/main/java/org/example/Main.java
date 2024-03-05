package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

      try {
            FileReader fr = new FileReader("/Users/nashu/Desktop/Source_code/software_testing/SoftwareTesting/class_2/try_catch/src/main/java/org/example/Bryan");
            // read the data
           int data = 0;
           while (data != -1) {
                data = fr.read();
                System.out.println( (char) data);
            }
       } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
          throw new RuntimeException(e);
      }

    }
}