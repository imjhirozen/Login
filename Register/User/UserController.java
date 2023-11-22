package Register.User;

import Register.System.Components;
import Register.System.ViewComponents;

import javax.swing.*;

public class UserController extends Components {

    JLabel userName;

    public UserController(String name){
        userName = new JLabel("Hello "+name);
        ViewComponents.addLabel(window, userName,0, 100,490, 60, 40, true);
    }

}
