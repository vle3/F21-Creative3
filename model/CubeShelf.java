package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class CubeShelf extends Shelf{

    public String dimension;

    public CubeShelf(int x, int y , String name, double price, String dimension)
    {
        super(x, y, name, price);
        this.dimension = dimension;
    }

    @Override
    public String toString()
    {
        return "[Cube]" + super.toString() + ", Dimension: " + dimension;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(getImage(), null, getX() , getY());    
        g2.setColor(Color.blue);    
        g2.drawString("Dimension =" + dimension, getX(), getY());
    }
    
}
