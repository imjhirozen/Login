package projectTab.MainTab;

import javax.swing.*;
import java.awt.*;

public class MainTabView {

    public static void addButton(JPanel panel, JButton button, int x, int y, int width, int height, int sizeFont){
        button.setBounds(x,y,width,height);
        button.setFocusable(false);
        button.setBackground(new Color(168,226,255));
        button.setFont(new Font("monospace",Font.PLAIN,sizeFont));
        button.setBorder(null);
        panel.add(button);
    }

    public static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int sizeText, Boolean alignment){
        label.setBounds(x,y, width,height);
        label.setFont(new Font("monospace", Font.PLAIN, sizeText));

        if(alignment){
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
        }

        panel.add(label);
    }

    public static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, String color){
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.decode(color));
        panel.setLayout(null);
        frame.add(panel);
    }

    public static void removeComponents (JFrame frame){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();
    }

}
