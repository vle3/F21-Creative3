package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Cart;
import model.IRender;

public class ShoppingCanvas extends JPanel{
    private ShoppingPanel panel;
    private ArrayList<IRender> items = new ArrayList<>();
    private int selectIndex = -1;

    public ShoppingCanvas(ShoppingPanel panel)
    {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < items.size(); i++)
        {
            IRender item = items.get(i);
            item.render(g2);
            if(i == selectIndex)
            {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(Color.red);
                g2.draw(item.getBoundingbox());
            }
        }
    }

    public ArrayList<IRender> getItems() {
        return items;
    }
    public int getSelectIndex() {
        return selectIndex;
    }
    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }
}
