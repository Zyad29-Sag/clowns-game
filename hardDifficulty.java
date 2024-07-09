/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

/**
 *
 * @author Legion
 */
public class hardDifficulty implements Difficulty {

    private final int time = 30 * 1000;
    private final int speed = 1;

    public hardDifficulty() {
    }

    public int getTime() {
        return time;
    }

    public int getSpeed() {
        return speed;
    }

}
