/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

/**
 *
 * @author Legion
 */
public  class Factory implements MainFactory {

    @Override
    public Shape createShape(String s, String color,ImageObject o) {
        if(s.equalsIgnoreCase("Circle"))
        {
        Shape c = new Circle(color,o);
        return c;
        
        }
        if(s.equalsIgnoreCase("Square") )
        {
        Shape c = new Square(color,o);
        return c;
        
        }
        if(s.equalsIgnoreCase("Triangle") )
        {
        Shape c = new Triangle(color,o);
        return c;
        
        }
        if(s.equalsIgnoreCase("Bomb") )
        {
        Shape c = new Bomb(color,o);
        return c;
        
        }
        return null;
    }
    

}
