package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class Cart implements IRender{

    private int x = 400;
    private int y = 400;
    public int totalItem = 0;
    public double totalPrice = 0;
    private BufferedImage image;

    public Cart()
    {

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(getImage(), null, x, y);
        g2.setColor(Color.yellow);
        g2.drawString("Total Price: $" + totalPrice, x-300, y-300);
        g2.drawString("Total Quantity: " + totalItem, x-300 , y-200);        
    }

    @Override
    public Rectangle getBoundingbox() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void translate(int dx, int dy) {
        // TODO Auto-generated method stub
        
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
