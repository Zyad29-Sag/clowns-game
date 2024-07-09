/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

import java.io.IOException;

/**
 *
 * @author Legion
 */
public class CircuisGame {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String c = "Triangle";
        String color = "red";
        Factory f = new Factory();
        Shape p = f.createShape(c, color,new ImageObject((int) (0), (int) (5), "clown3.png"));
        Queue q= new Queue();
        boolean b = p instanceof Triangle;
        q.loadQueue();
        System.out.println("" + b);

    }

}
