package com.example.demo_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txt_A_input;


    @FXML
    protected void quadraticRootFinderButtonClick(){
        txt_A_input.setText("Welcome NUE!!!");
    }
}