package org.example;

import javax.swing.*;

public class OpeningWindow extends JFrame{

    private JButton btnClick;
    private JPanel openingPanel;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JTextField textField1;
    private JTextField textField2;

    // JFrame frame;

    OpeningWindow() {
        openingPanel = new JPanel();
        openingPanel.add(usernameLabel);


        super.setContentPane(openingPanel);
    }


}
