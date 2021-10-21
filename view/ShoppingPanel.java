package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShoppingPanel {
    private JFrame window;
    private ShoppingCanvas canvas;

    private JButton quitButton = new JButton("Exit");
    private JButton checkoutButton = new JButton("Check out");
    
    public ShoppingPanel(JFrame window)
    {
        this.window = window;
    }

    public void init()
    {
        Container cp = window.getContentPane();

        canvas = new ShoppingCanvas(this);
        JPanel southPanel = new JPanel();
        southPanel.add(checkoutButton);
        southPanel.add(quitButton);
        
        cp.add(BorderLayout.CENTER, canvas);
        cp.add(BorderLayout.SOUTH, southPanel);
    }
}
