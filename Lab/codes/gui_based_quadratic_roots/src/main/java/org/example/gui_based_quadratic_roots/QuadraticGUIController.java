package org.example.gui_based_quadratic_roots;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class QuadraticGUIController {
    @FXML
    private Label lblOutput;

    @FXML
    private TextField txtA_input;
    @FXML
    private TextField txtB_input;
    @FXML
    private TextField txtC_input;

    @FXML
    protected void onFIndRootButtonClick(){

        String a = txtA_input.getText();
        String b = txtB_input.getText();
        String c = txtC_input.getText();

        String result = findRoots(a, b, c);

        lblOutput.setText(result);

    }

    public String findRoots(String a, String b, String c) throws NumberFormatException{
        try {
            double A = Double.parseDouble(a);
            double B = Double.parseDouble(b);
            double C = Double.parseDouble(c);

            return quadraticRoots(A, B, C);

        } catch (NumberFormatException e) {
            return "The input must be number";
        }
    }

    public String quadraticRoots(double a, double b, double c) {

        int isValid = 0;
        double D;

        if ((a >= 0) && (a <= 100) && (b >= 0) && (b <= 100) && (c >= 0) && (c <= 100)) {
            isValid = 1;

            if (a == 0) {
                isValid = -1;
            }
        }

        if (isValid == 1) {
            D = b * b - 4 * a * c;

            if (D == 0) {
                double r1 = -b / (2*a);
                return "One Real Root, r = " + String.format("%.2f", r1);
            } else if (D > 0) {
                double r1 = (-b + Math.sqrt(D)) / (2 * a);
                double r2 = (-b - Math.sqrt(D)) / (2 * a);
                return "2 Real Roots, r1 = " + String.format("%.2f", r1) +
                        " and r2 = " + String.format("%.2f", r2);
            } else {
                D = -1 * D;
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-D) / (2 * a);
                return "2 Imaginary Roots, r1 = " + String.format("%.2f", realPart) + " + " +
                        String.format("%.2f", imaginaryPart) + "i and r2 = " +
                        String.format("%.2f", realPart) + " - " +
                        String.format("%.2f", imaginaryPart) + "i";
            }

        } else if (isValid == -1) {
            return "The Equation is not a quadratic equation";
        } else {
            return "The input is out of range";
        }
    }

}