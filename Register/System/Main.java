package Register.System;
import Register.Login.LoginController;

import javax.swing.*;

public class Main extends Components{
    public static void main(String[] args){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        window.setSize(500,600);
        new LoginController();
    }
}
