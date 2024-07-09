/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

import javax.imageio.ImageIO;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Legion
 */
public class ImageObject implements GameObject {

    private BufferedImage[] spriteImages = new BufferedImage[1];
    private int x;
    private int y;
    private boolean visible;
    private int z;
    private String s;
    private boolean horizontalOnly;
    int type;

    public ImageObject(int x, int y, String s, int z,int type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s = s;
        this.type=type;
        this.visible = true;
        if (z == 1) {
            horizontalOnly = true;
        }
        try {
            //System.out.println("pic" + s);
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ImageObject() {

    }

    public ImageObject(int x, int y, String s) {

        this(x, y, s, 0,0);
    }
    public ImageObject(int x, int y, String s,int type) {

        this(x, y, s, 0,type);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
       
        this.x = x;
    }

    public String getS() {
        return this.s;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        if (horizontalOnly) {
            return;
        }
        this.y = y;
    }
    public void setBoolean(boolean b)
    {
        this.horizontalOnly=b;
    }
      public boolean getBoolean()
    {
        return this.horizontalOnly;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    public int getz() {
        return z;
    }

    public void setz(int z) {
        this.z = z;
    }
     public int gettype() {
        return type;
    }

    public void settype(int type) {
        this.type = type;
    }

}
