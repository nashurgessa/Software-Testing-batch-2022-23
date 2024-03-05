package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        try {
            double result = 5 / 0;
        } catch(ArithmeticException err) {
           err.printStackTrace();
        }



        Dog dog = new Dog();
        dog.sound();
        dog.walk();



        /*
        Rectangle rect1 = new Rectangle(3, 5);

        Rectangle rect2 = new Rectangle(5, 4);

        // rect1.height = 10;
        rect1.setHeight(10);

        // rectangle 1
        System.out.println("The perimeter is : " + rect1.getPerimeter() +
                " The area is : " + rect1.getArea());


        Calculator calc = new Calculator();
        double result1 = calc.add(2.0, 3);
        double result2 = calc.add(4.0, 5.0);
        double result3 = calc.add(5);

        */
    }

}