/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;
import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Legion
 */
public class clown extends ImageObject {

    direction dir;
    private int health;
    private int score;
    private boolean isDead;
    int x;
    int y;
    String icon;

    public static interface collectShape {

        void collect();
    }
    private final collectShape collect;

    enum direction {
        Right,
        left
    }

    public clown(int x, int y, String s, collectShape collect) {
        super(x,y,s);
        this.collect=collect;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public String getIcon() {
        return this.icon;
    }
    public direction getDir() {
        return dir;
    }

    public void setDir(direction dir) {
        this.dir = dir;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public void addPoints(int x) {
        score = score + 10;
    }

    public void addHeart() {
        health++;
    }

    public void removeHeart() {
        health--;
        if (health == 0) {
            setIsDead(true);
        }

    }

}
