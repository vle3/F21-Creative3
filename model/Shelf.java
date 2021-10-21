package model;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public abstract class Shelf implements IRender{
    private int x;
    private int y;
    private String name;
    private double price;
    private BufferedImage image;

    public Shelf(int x, int y, String name, double price)
    {
        this.x = x;
        this.y = y;
        this.name = name;
        this.price = price;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "Shelf at (" + x +  ", "  + y + " ) name = " + name + ", price = " + price;
    }

    @Override
    public Rectangle getBoundingbox()
    {
        return new Rectangle(x, y , image.getWidth(), image.getHeight());
    }

    @Override
    public void translate(int dx, int dy)
    {
        x += dx;
        y += dy;
    }
}
