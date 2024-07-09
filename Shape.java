/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Legion
 */
public abstract class Shape implements GameObject {

    public abstract String getColor();
    public abstract String getShapeName();
    public abstract void setImageObject(ImageObject object);
    public abstract ImageObject getImageObject();
    

}
