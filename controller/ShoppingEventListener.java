package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.util.ArrayList;

import model.Cart;
import model.IRender;
import model.images.ImageStore;
import view.ShoppingPanel;

public class ShoppingEventListener implements MouseListener, ActionListener{

    public static final int UNIT_MOVE = 5;
    private ShoppingPanel panel;
    private Cart cart = new Cart();

    public ShoppingEventListener(ShoppingPanel panel)
    {
        this.panel = panel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    
       
        if(e.getSource() == panel.getQuitButton())
        {
            System.exit(0);
        }

        if(e.getSource() == panel.getCheckoutButton())
        {
            //panel.setDirectToCart(true);
            panel.getCanvas().getItems().clear();
            cart.setImage(ImageStore.cart);
            panel.getCanvas().getItems().add(cart);
            panel.getCanvas().repaint();

        }

        if(e.getSource() == panel.getAddButton())
        {
            int itemSelected = panel.getCanvas().getSelectIndex();
            
            if(itemSelected == 0)
            {
                cart.totalPrice += 19.99;
                cart.totalItem++;
                System.out.println("added 0");
            }
            else if(itemSelected == 1)
            {
                cart.totalPrice += 29.99;
                cart.totalItem++;
                
                System.out.println("added 1");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ArrayList<IRender> items = panel.getCanvas().getItems();
        for(int i = 0 ; i < items.size(); i++)
        {
            Rectangle r = items.get(i).getBoundingbox();
            if(r.contains(e.getX(), e.getY()))
            {
                panel.getCanvas().setSelectIndex(i);
                panel.getCanvas().repaint();
                return;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
