package projectTab.login;

import projectTab.*;
import projectTab.register.*;
import projectTab.MainTab.*;

import javax.swing.*;
import java.awt.event.*;

public class LoginController extends Components implements ActionListener{

    JTextField userTf = new JTextField();
    JPasswordField passwordPf = new JPasswordField();

    JLabel loginLogo = new JLabel("Login");
    JLabel userLb = new JLabel("Username");
    JLabel passwordLb = new JLabel("Password");

    JButton loginBtn = new JButton("Login");
    JButton registerBtn = new JButton("Register");
    JCheckBox showPassword = new JCheckBox();


    public LoginController (){
        LoginView.addLabel(window, loginLogo, 0, 0, 1290,120,60, true);

        // login user label and text-field
        LoginView.addLabel(window, userLb, 0, 110, 1290, 50, 20, true);
        LoginView.addJTextField(window, userTf, 470, 150, 350, 50, 25);

        // login password-label password-field check-box
        LoginView.addLabel(window, passwordLb, 0, 200, 1290, 50, 20, true);
        LoginView.addPasswordField(window, passwordPf, 470, 240, 350, 50, 25);
        LoginView.addCheckBox(window, showPassword, 470, 300);
        showPassword.addActionListener(this);

        // login buttons Login And Register
        LoginView.addButton(window, loginBtn, 530, 350, 230, 50, 20);
        loginBtn.addActionListener(this);

        LoginView.addButton(window, registerBtn, 530, 410, 230, 50, 20);
        registerBtn.addActionListener(this);

        window.setVisible(true);
    }

    public void  actionPerformed(ActionEvent e){

        if(showPassword.isSelected()) passwordPf.setEchoChar((char)0);
        else passwordPf.setEchoChar('\u2022');

        if(e.getSource() == loginBtn){

            String password = new String(passwordPf.getPassword());

            if(!userTf.getText().isEmpty()) {

                if(Data.isExist(userTf.getText(), password)){

                    LoginView.removeComponents(window);
                    new MainTabController();

                }else System.out.println("Wrong Username And Password");

            } else System.out.println("Input A Data");

        }

        if(e.getSource() == registerBtn){
            LoginView.removeComponents(window);
            new RegisterController();
        }

    }

}
