package projectTab.register;

import projectTab.Components;

import projectTab.Data;
import projectTab.login.*;

import javax.swing.*;
import java.awt.event.*;

public class RegisterController extends Components implements ActionListener {

    JLabel loginLogo = new JLabel("Register");

    JLabel userLb = new JLabel("Username");
    JTextField userTf = new JTextField();

    JLabel passwordLb = new JLabel("Password");
    JTextField passwordPf = new JTextField();

    JLabel nameLb = new JLabel("Name");
    JTextField nameTf = new JTextField();

    JLabel lastNameLb = new JLabel("Lastname");
    JTextField lastnameTf = new JTextField();

    JButton registerBtn = new JButton("Register");
    JButton backBtn = new JButton("Back");


    public RegisterController (){
        RegisterView.addLabel(window, loginLogo, 0, 0, 1290,120,60, true);

        // Register user label and text-field
        RegisterView.addLabel(window, userLb, 240, 110, 350, 50, 20, true);
        RegisterView.addJTextField(window, userTf, 240, 150, 350, 50, 25);

        // Register password-label
        RegisterView.addLabel(window, passwordLb, 240, 200, 350, 50, 20, true);
        RegisterView.addJTextField(window, passwordPf, 240, 240, 350, 50, 25);

        // Register name
        RegisterView.addLabel(window, lastNameLb, 700, 200, 350, 50, 20, true);
        RegisterView.addJTextField(window, lastnameTf, 700, 240, 350, 50, 25);

        // Register Lastname
        RegisterView.addLabel(window, nameLb, 700, 110, 350, 50, 20, true);
        RegisterView.addJTextField(window, nameTf, 700, 150, 350, 50, 25);

        // Register buttons Register and Back
        RegisterView.addButton(window, registerBtn, 530, 350, 230, 50, 20);
        registerBtn.addActionListener(this);

        RegisterView.addButton(window, backBtn, 530, 410, 230, 50, 20);
        backBtn.addActionListener(this);

        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == registerBtn){
            if( !userTf.getText().isEmpty() && !passwordPf.getText().isEmpty()
            && !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty() ){

                if(Data.isExistUser(userTf.getText())) {

                    Data.inputUserAndPassword(userTf.getText(), passwordPf.getText());
                    Data.inputNameAndLastname(nameTf.getText(), lastnameTf.getText());

                }else System.out.println("User Already Taken");

            }else System.out.println("Enter Data");
        }

        if(e.getSource() == backBtn){
            RegisterView.removeComponents(window);
            new LoginController();
        }
    }

}
