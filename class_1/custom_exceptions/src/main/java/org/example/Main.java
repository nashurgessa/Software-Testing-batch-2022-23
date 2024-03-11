package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            validateAge(25);
        } catch (CustomException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    // To validate the age
    public static void validateAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or Above");
        }
    }
}