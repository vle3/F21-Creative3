package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ShoppingEventListener;
import model.CubeShelf;
import model.FloatShelf;
import model.IRender;
import model.images.ImageStore;

public class ShoppingPanel {
    private JFrame window;
    private ShoppingCanvas canvas;

    private JButton quitButton = new JButton("Exit");
    private JButton checkoutButton = new JButton("Check out");
    private JButton addButton = new JButton("Add");
    
    private boolean directToCart = false;

    public ShoppingPanel(JFrame window)
    {
        this.window = window;
    }

    public void init()
    {
        Container cp = window.getContentPane();

        canvas = new ShoppingCanvas(this);
        JPanel southPanel = new JPanel();
        southPanel.add(addButton);
        southPanel.add(checkoutButton);
        southPanel.add(quitButton);
        
        cp.add(BorderLayout.CENTER, canvas);
        cp.add(BorderLayout.SOUTH, southPanel);

        populateItems();

        ShoppingEventListener listener = new ShoppingEventListener(this);
        canvas.addMouseListener(listener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);

        addButton.addActionListener(listener);
        checkoutButton.addActionListener(listener);
        quitButton.addActionListener(listener);
    }

    private void populateItems()
    {
        ArrayList<IRender> items = canvas.getItems();
        CubeShelf c1 = new CubeShelf(50, 50, "EKET", 19.99, "20x20x20");
        items.add(c1);
        c1.setImage(ImageStore.cubeShelf);

        FloatShelf f1 = new FloatShelf(50, 200, "LACK", 29.00, 43);
        items.add(f1);
        f1.setImage(ImageStore.floatShelf);
    }

    public ShoppingCanvas getCanvas() {
        return canvas;
    }
    public JButton getQuitButton() {
        return quitButton;
    }
    public JButton getAddButton() {
        return addButton;
    }
    public JButton getCheckoutButton() {
        return checkoutButton;
    }
    public JFrame getWindow() {
        return window;
    }
    public boolean getDirectToCart()
    {
        return directToCart;
    }
    public void setDirectToCart(boolean direct)
    {
        this.directToCart = direct;
    }
}
