package Register.Register;

import Register.System.Components;
import Register.System.*;
import Register.Login.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController extends Components implements ActionListener {

    JLabel registerLogo = new JLabel("REGISTER");
    JLabel RegUserLb = new JLabel("Username");
    JLabel RegPasswordLb = new JLabel("Password");
    JPanel container = new JPanel();
    JLabel displayAuthentication = new JLabel();
    public static JTextField regUserTf = new JTextField();
    public static JTextField regPasswordTf = new JTextField();
    public static JButton regRegisterBtn = new JButton("Register");
    public static JButton regBackBtn = new JButton("BACK");

    public RegisterController(){
        ViewComponents.addLabel(window, registerLogo, 0, 0, 490, 120, 50, true);

        ViewComponents.addLabel(window, RegUserLb, 70,105,350, 50, 20, true);
        ViewComponents.addJTextField(window, regUserTf, 70, 150, 350, 40, 30);

        ViewComponents.addLabel(window, RegPasswordLb, 70,195,350, 50, 20, true);
        ViewComponents.addJTextField(window, regPasswordTf, 70, 240, 350, 40, 30);

        ViewComponents.authenticationWarning(window, container, displayAuthentication, 0, 290, 490, 50);

        ViewComponents.addButton(window, regRegisterBtn, 115, 360, 260, 50, 20);
        regRegisterBtn.addActionListener(this);

        ViewComponents.addButton(window, regBackBtn, 115, 420, 260, 50, 20);
        regBackBtn.addActionListener(this);

        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == regRegisterBtn){
            if(!regUserTf.getText().isEmpty() && !regPasswordTf.getText().isEmpty()) {

                if(SystemModel.isExist(regUserTf.getText(), regPasswordTf.getText())){

                    SystemModel.getData(regUserTf.getText(), regPasswordTf.getText());
                    container.setVisible(true);
                    displayAuthentication.setText("UserName already Exist");
                    System.out.println("UserName already Exist");
                    regUserTf.setText(null);
                    regPasswordTf.setText(null);
                } else {
                    SystemModel.inputData(regUserTf.getText(), regPasswordTf.getText());
                    System.out.println("Successfully Save");
                    regUserTf.setText(null);
                    regPasswordTf.setText(null);
                }

            }
            else {
                container.setVisible(true);
                displayAuthentication.setText("Please input Data");
                System.out.println("Please input Data");
                regUserTf.setText(null);
                regPasswordTf.setText(null);
            }
        }


        if(e.getSource() == regBackBtn){
            window.getContentPane().removeAll();
            window.repaint();
            window.repaint();
            new LoginController();
        }
    }
}
