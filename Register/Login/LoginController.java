package Register.Login;

import Register.System.*;
import Register.Register.*;
import Register.User.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginController extends Components implements ActionListener {

    JTextField userTf = new JTextField();
    JPasswordField passwordPf = new JPasswordField();
    JLabel loginLogo = new JLabel("Login");
    JLabel userLb = new JLabel("Username");
    JLabel passwordLb = new JLabel("Password");

    JButton loginBtn = new JButton("Login");
    JButton registerBtn = new JButton("Register");
    JCheckBox showPassword = new JCheckBox();

    public LoginController(){
        // Login Logo
        ViewComponents.addLabel(window, loginLogo, 0, 0, 490,120,60, true);

        // login user label and text-field
        ViewComponents.addLabel(window, userLb, 70, 110, 200, 50, 20, false);
        ViewComponents.addJTextField(window, userTf, 70, 150, 350, 50, 25);

        // login password-label password-field check-box
        ViewComponents.addLabel(window, passwordLb, 70, 200, 200, 50, 20, false);
        ViewComponents.addPasswordField(window, passwordPf, 70, 240, 350, 50, 25);
        ViewComponents.addCheckBox(window, showPassword, 75, 300);
        showPassword.addActionListener(this);

        // login buttons Login And Register
        ViewComponents.addButton(window, loginBtn, 130, 350, 230, 50, 20);
        loginBtn.addActionListener(this);

        ViewComponents.addButton(window, registerBtn, 130, 410, 230, 50, 20);
        registerBtn.addActionListener(this);


        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(showPassword.isSelected()){
            passwordPf.setEchoChar((char)0);
        }else passwordPf.setEchoChar('\u2022');

        if(e.getSource() == loginBtn){

            String pwd = new String(passwordPf.getPassword());
            if(SystemModel.isExist(userTf.getText(), pwd)){

                SystemModel.getData(userTf.getText(), pwd);
                System.out.println("Login");

                window.getContentPane().removeAll();
                window.repaint();
                window.revalidate();
                new UserController(userTf.getText());

            } else System.out.println("Invalid User And Password");

        }

        if(e.getSource() == registerBtn){
            window.getContentPane().removeAll();
            window.repaint();
            window.revalidate();
            new RegisterController();
        }
    }
}
