/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

/**
 *
 * @author Legion
 */
public class Array {

    ImageObject[] array = new ImageObject[25];

    public ImageObject[] returnArray() {
        array[0] = new ImageObject((int) (0), (int) (1), "red.png",1);
        array[1] = new ImageObject((int) (0), (int) (1), "sred.png",1);
        array[2] = new ImageObject((int) (0), (int) (1), "red.png",1);
        array[3] = new ImageObject((int) (0), (int) (1), "Bomb.png",2);
        array[4] = new ImageObject((int) (0), (int) (1), "sgreen.png",1);
        array[5] = new ImageObject((int) (0), (int) (1), "sred.png",1);
        array[6] = new ImageObject((int) (0), (int) (1), "red.png",1);
        array[7] = new ImageObject((int) (0), (int) (1), "Bomb.png",2);
        array[8] = new ImageObject((int) (0), (int) (1), "red.png",1);
        array[9] = new ImageObject((int) (0), (int) (1), "sred.png",1);
        array[10] = new ImageObject((int) (0), (int) (1), "purple.png",1);
        array[11] = new ImageObject((int) (0), (int) (1), "spurple.png",1);
        array[12] = new ImageObject((int) (0), (int) (1), "sgreen.png",1);
        array[13] = new ImageObject((int) (0), (int) (1), "spurple.png",1);
        array[14] = new ImageObject((int) (0), (int) (1), "purple.png",1);
        array[15] = new ImageObject((int) (0), (int) (1), "spurple.png",1);
        array[16] = new ImageObject((int) (0), (int) (1), "sgreen.png",1);
        array[17] = new ImageObject((int) (0), (int) (1), "Bomb.png",2);
        array[18] = new ImageObject((int) (0), (int) (1), "purple.png",1);
        array[19] = new ImageObject((int) (0), (int) (1), "sgreen.png",1);
        array[20] = new ImageObject((int) (0), (int) (1), "purple.png",1);
        array[21] = new ImageObject((int) (0), (int) (1), "sred.png",1);
        array[22] = new ImageObject((int) (0), (int) (1), "red.png",1);
        array[23] = new ImageObject((int) (0), (int) (1), "sgreen.png",1);
        return array;
    }
}
