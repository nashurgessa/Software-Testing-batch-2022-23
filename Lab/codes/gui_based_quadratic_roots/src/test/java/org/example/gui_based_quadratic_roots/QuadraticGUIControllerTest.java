package org.example.gui_based_quadratic_roots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuadraticGUIControllerTest {

    QuadraticGUIController quadraticController = new QuadraticGUIController();

    @Test
    public void inValid_Type_A_Input_Test() {
        // Arrange & Act
        String result = quadraticController.findRoots("N", "4", "2");
        Assertions.assertEquals("The input must be number", result);

    }
    @Test
    public void inValid_Type_B_Input_Test() {
        // Arrange & Act
        String result = quadraticController.findRoots("4", "N", "2");
        Assertions.assertEquals("The input must be number", result);

    }
    @Test
    public void inValid_Type_C_Input_Test() {
        // Arrange & Act
        String result = quadraticController.findRoots("4", "2", "N");
        Assertions.assertEquals("The input must be number", result);

    }

    @Test
    public void path1() {
        // arrange
        double a = 2, b =4, c = 2;
        String result = quadraticController.quadraticRoots(a, b, c);
        Assertions.assertEquals("One Real Root, r = -1.00", result);
    }

}
