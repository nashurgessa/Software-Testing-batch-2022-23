package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        /*
        try {
            double result = 5 / 0.0;
            System.out.println("The result is : " + result);
        }catch(ArithmeticException err) {
            throw err;
        } finally {
            System.out.println("This is the final");
        }

         */

        try {
            FileReader _file = new FileReader("file.txt");

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




        /*
        Dog dog = new Dog();
        dog.sound();

         */

        /*
        Calculator calc = new Calculator();
        double result1 = calc.add(2, 3);
        double result2 = calc.add(2.0, 3.0);

        double result3 = calc.add(2, 3.5);
        */

        /*
        Circle obj1 = new Circle(5);

        Circle obj2 = new Circle(10);

        // obj1.radius = 15;
        obj1.setRadius(15);

//        // Object1
//        double c1 = obj1.getCircumference();
//        double area1 = obj1.getArea();
//        System.out.println("The Circumference of obj1 is :"
//                + c1 +" and the Area is : " + area1 );
//
//        // Object1
//        double c2 = obj2.getCircumference();
//        double area2 = obj2.getArea();
//        System.out.println("The Circumference of obj2 is :"
//                + c2 +" and the Area is : " + area2 );
        */
    }
}