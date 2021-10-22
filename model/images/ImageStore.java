package model.images;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageStore 
{
    public static BufferedImage cubeShelf;    
    public static BufferedImage floatShelf;    
    public static BufferedImage bookShelf;    
    public static BufferedImage cart;

    static{
        cubeShelf = readImage("model/images/cube.jpg", 80, 80);
        floatShelf = readImage("model/images/float.jpg", 80, 80);
        //bookShelf = readImage("model/images/book.jpg", 70, 50);
        cart = readImage("model/images/cart.png" , 80, 60);
    }

    public static BufferedImage readImage(String path, int width, int height)
    {
        try{
            BufferedImage originalImage = ImageIO.read(new File(path));
            Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage resizedImage = new BufferedImage(width , height , BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = resizedImage.createGraphics();
            g2.drawImage(tmp, 0, 0, null);
            g2.dispose();
            return resizedImage;
        }
        catch(Exception e)
        {
            System.out.println("Image file load error");
        }
        return null;
    }
}


