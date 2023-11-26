package projectTab;

import projectTab.login.*;

import javax.swing.*;

class Main extends Components{
    public static void main(String[] args){

        window.setSize(1300, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        new LoginController();
    }
}