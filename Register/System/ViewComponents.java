package Register.System;

import javax.swing.*;
import java.awt.*;

public class ViewComponents {

    public static void addJTextField(JFrame frame, JTextField textField, int x, int y, int width, int height , int sizeText){
        textField.setBounds(x,y,width,height);
        textField.setBackground(Color.GRAY);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("monospace", Font.PLAIN, sizeText));
        //textField.setBorder(null);
        frame.add(textField);
    }

    public static void addPasswordField(JFrame frame, JPasswordField passwordField, int x, int y, int width, int height, int sizeText){
        passwordField.setBounds(x,y,width,height);
        passwordField.setBackground(Color.GRAY);
        passwordField.setForeground(Color.WHITE);
        passwordField.setFont(new Font("monospace", Font.PLAIN, sizeText));
        //passwordField.setBorder(null);
        frame.add(passwordField);
    }

    public static void addCheckBox(JFrame frame, JCheckBox box, int x, int y){
        box.setBounds(x,y,140,15);
        box.setText("Show Password");
        box.setFont(new Font("monospace", Font.PLAIN, 15));
        box.setLayout(null);
        box.setFocusable(false);
        frame.add(box);
    }


    public static void addButton(JFrame frame, JButton button, int x, int y, int width, int height, int sizeFont){
        button.setBounds(x,y,width,height);
        button.setFocusable(false);
        button.setBackground(new Color(168,226,255));
        button.setFont(new Font("monospace",Font.PLAIN,sizeFont));
        button.setBorder(null);
        frame.add(button);
    }

    public static void addLabel(JFrame frame, JLabel label, int x, int y, int width, int height, int sizeText, Boolean alignment){
        label.setBounds(x,y, width,height);
        label.setFont(new Font("monospace", Font.PLAIN, sizeText));

        if(alignment){
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
        }

        frame.add(label);
    }

    public static void authenticationWarning(JFrame frame, JPanel panel, JLabel label, int x, int y, int width, int height){
        label.setBounds(0,0,width,height);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("monospace", Font.PLAIN, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);


        panel.setBounds(x,y,width,height);
        panel.setBackground(Color.BLACK);
        panel.setVisible(false);
        panel.setLayout(null);
        panel.add(label);
        frame.add(panel);
    }

}
