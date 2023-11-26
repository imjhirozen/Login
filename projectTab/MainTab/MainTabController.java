package projectTab.MainTab;


import projectTab.*;
import projectTab.login.*;

import javax.swing.*;
import java.awt.event.*;


public class MainTabController extends Components implements ActionListener {

    String[] months = {"Name","Lastname","January","February","March","April","May","June"
                        ,"July","August","September","October","November ","December"};

    JTable table = new JTable(Data.outputData(), months);
    JScrollPane sp = new JScrollPane(table);

    JPanel buttonPanel = new JPanel();

    JButton viewRecord = new JButton("Records");
    JButton paymentBtn = new JButton("Payment");
    JButton logoutBtn = new JButton("Logout");

    public MainTabController(){

        MainTabView.addPanel(window, buttonPanel, 0,0,200,600, "#252525");
        MainTabView.addPanel(window, mainPanel, 200,0,1200,600, "#64867E");


        MainTabView.addButton(buttonPanel, logoutBtn, 10, 500, 180, 50, 20);
        logoutBtn.addActionListener(this);

        MainTabView.addButton(buttonPanel, viewRecord, 10, 30, 180, 50, 20);
        viewRecord.addActionListener(this);

        MainTabView.addButton(buttonPanel, paymentBtn, 10, 90, 180, 50, 20);
        paymentBtn.addActionListener(this);

        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == viewRecord){
            table.setEnabled(false);
            table.getTableHeader().setReorderingAllowed(false);
            sp.setBounds(0,80, 1090,400);
            mainPanel.add(sp);
        }

        if(e.getSource() == paymentBtn){



            int count = Data.countLineOnAFile();
            System.out.println(count);
        }

        if(e.getSource() == logoutBtn){
            MainTabView.removeComponents(window);

            new LoginController();
        }

    }


}
