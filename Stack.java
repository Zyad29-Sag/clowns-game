/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Legion
 */
public class Stack {

    private List<Shape> Stick = new ArrayList<>();
    private List<ImageObject> StickImages = new ArrayList<>();
    private int i = 0;
    private int j = 0;

    public void push(Shape s, ImageObject obj) {
        Stick.add(i, s);
        StickImages.add(j, obj);
        i++;
        j++;
    }

    public Shape popShape() {
        i--;
        Shape s = Stick.remove(i);
        return s;
    }

    public ImageObject peakImage(int k) {
        ImageObject s = StickImages.get(k);
        return s;
    }
    public ImageObject popImage(){
        j--;
        ImageObject s = StickImages.remove(j);
        return s;
    }

    public Shape peak(int x) {
        return Stick.get(x);

    }
     public int size() {
        return Stick.size();

    }

}
