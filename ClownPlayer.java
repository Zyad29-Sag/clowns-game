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
public class ClownPlayer extends ImageObject implements GameObject, PlateObserver {

    int x = 100;
    int y = 135;
    clown.direction dir;
    private int health = 3;
    private int score = 0;
    private boolean isDead;
    String s = "icon";
    private ImageObject image = new ImageObject(100, 350, "newclown2.png", 1, 0);
    private ImageObject image1 = new ImageObject(100 - 20, 338, "leftredstick.png", 1, 0);
    private ImageObject image2 = new ImageObject(100 + 140, 338, "rightredstick.png", 1, 0);
    private collectShape collect;
    private static ClownPlayer clown = null;

    @Override
    public void onPlateReachedEnd() {
        removeHeart();
    }

    public static interface collectShape {

        void collect();
    }

    private ClownPlayer(int x, int y, String s) {
        super(x, y, s);
    }

    public static ClownPlayer getInstance() {

        if (clown == null) {
            clown = new ClownPlayer(100, 350, "newclown2.png");
        }
        return clown;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getIcon() {
        return this.s;
    }

    public clown.direction getDir() {
        return dir;
    }

    public void setDir(clown.direction dir) {
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

    public boolean isDead() {

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

    public ImageObject getclownImage() {
        return this.image;
    }

    public ImageObject getImagestick1() {
        return this.image1;
    }

    public ImageObject getImagestick2() {
        return this.image2;
    }

}
