package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class FloatShelf extends Shelf {
    
    public double length;

    public FloatShelf(int x, int y , String name, double price, double dimension)
    {
        super(x, y, name, price);
        this.length = length;
    }

    @Override
    public String toString()
    {
        return "[Float]" + super.toString() + ", Dimension: " + length;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(getImage(), null, getX() , getY());    
        g2.setColor(Color.blue);    
        g2.drawString("Dimension =" + length, getX(), getY());
    }
     
}
