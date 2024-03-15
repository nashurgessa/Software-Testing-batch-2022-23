package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            validationAge(15);
        } catch(MyException err) {
            err.printStackTrace();
        }

    }


    public static void validationAge(int age) throws MyException {
        if (age < 18) {
            throw new MyException("Age must be 18 or above");
        }
    }
}