/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

import java.awt.Color;
import eg.edu.alexu.csd.oop.game.sample.world.circus.ClownPlayer.collectShape;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Legion
 */
public class ClownGame implements World, collectShape {

    private int MaxTime;
    private static final int LeftStick = 123456;
    private static final int RightStick = 654321;
    private int DefaultSpeed;
    private final int DefaultClownSpeed = 20;
    private final int NumberOfFallingObjects = 24;
    private long StartTime = System.currentTimeMillis();
    private int Score;
    private boolean CollectShape;
    private final int height;
    private final int width;
    ClownPlayer clownPlayer;
    private GameState currentState;
    private final List<GameObject> constant = new ArrayList<>();
    private final List<GameObject> moving = new ArrayList<>();
    private final List<GameObject> control = new ArrayList<>();
    private List<PlateObserver> plateObservers = new ArrayList<>();
    ImageObject imageobject;
    ImageObject[] shapes = new ImageObject[25];
    Stack stick1 = new Stack();
    Stack stick2 = new Stack();
    Stack stick3 = new Stack();
    Queue q = new Queue();
    int k = 0;
    int k1;
    int k2;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int flag2 = 0;
    int flag3 = 0;
    int flag4 = 0;
    int flag5 = 0;
    int index;
    int health = 3;
    List<Shape> shapeArray = new ArrayList<>();

    public ClownGame(int height, int width, Difficulty x) throws IOException {
        currentState = new PlayingState(this);
        clownPlayer = ClownPlayer.getInstance();
        this.height = height;
        this.width = width;
        MaxTime = x.getTime();
        DefaultSpeed = x.getSpeed();
        Factory factory = new Factory();
        Queue q = new Queue();
        q.loadQueue();
        control.add(clownPlayer.getImagestick1());
        k1 = k;
        k++;
        control.add(clownPlayer.getImagestick2());
        k2 = k;
        k++;
        control.add(clownPlayer.getclownImage());
        k++;
        constant.add(new BarObject(0, 50, 300, true, Color.GREEN));
        constant.add(new BarObject(0, 150, 150, true, Color.CYAN));
        constant.add(new BarObject(500, 50, 300, true, Color.BLUE));
        constant.add(new BarObject(650, 150, 150, true, Color.MAGENTA));
        int xpos = -200;
        int xpos2 = -250;
        int ypos = 25;
        int ypos2 = 125;
        int xpos3 = 1000;
        int ypos3 = 26;
        int xpos4 = 1050;
        int ypos4 = 126;
        int temp = 35;
        int temp2 = 35;
        int temp3 = 35;
        int temp4 = 35;

        for (int i = 0; i < 6; i++) {
            Shape s = q.Dequeue(1);
            ImageObject o = s.getImageObject();
            o.setX(xpos);
            o.setY(ypos);
            o.setz(1);
            moving.add(o);
            shapeArray.add(s);
            xpos = xpos + temp;
            temp = temp + 15;
            shapes[i] = o;
        }
        for (int i = 6; i < 12; i++) {
            Shape s = q.Dequeue(2);
            ImageObject o = s.getImageObject();
            o.setX(xpos2);
            o.setY(ypos2);
            o.setz(2);
            moving.add(o);
            shapeArray.add(s);
            xpos2 = xpos2 + temp2;
            temp2 = temp2 + 15;
            shapes[i] = o;
        }
        for (int i = 12; i < 18; i++) {
            Shape s = q.Dequeue(3);
            ImageObject o = s.getImageObject();
            o.setX(xpos3);
            o.setY(ypos3);
            o.setz(3);
            moving.add(o);
            shapeArray.add(s);
            xpos3 = xpos3 - temp3;
            temp3 = temp3 + 15;
            shapes[i] = o;
        }
        for (int i = 18; i < 24; i++) {
            Shape s = q.Dequeue(4);
            ImageObject o = s.getImageObject();
            o.setX(xpos4);
            o.setY(ypos4);
            o.setz(4);
            moving.add(o);
            shapeArray.add(s);
            xpos4 = xpos4 - temp4;
            temp4 = temp4 + 15;
            shapes[i] = o;
        }

    }

    private boolean intersect(GameObject o1, GameObject o2) {
        if (o2.getY() > o1.getY()) {
            return false;
        }
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth() / 2) && (Math.abs((o1.getY() + o1.getHeight()) - (o2.getY() + o2.getHeight())) <= o1.getHeight());

    }

    @Override
    public List<GameObject> getConstantObjects() {
        return this.constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return this.moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return this.control;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void updatePlayingState() {
        for (GameObject o : moving.toArray(new GameObject[moving.size()])) {
            moveShapes(o);
            if (control.get(0) != o) {
                if (o.isVisible()) {
                    if (count1 >= 1 && count2 == 0) {
                        if (intersect(stick1.peakImage(stick1.size() - 1), o) || intersect(control.get(k2), o)) {
                            ImageObject m = (ImageObject) o;
                            if (m.gettype() == 2) {
                                //health--;
                                notifyBomb();

                                m.setVisible(false);
                            } else {
                                if (intersect(stick1.peakImage(stick1.size() - 1), o)) {

                                    count1++;
                                    addToStack(stick1, o);
                                    stick3 = stick1;
                                    count3 = count1;
                                    index = 1;
                                } else if (intersect(control.get(k2), o)) {

                                    count2++;
                                    addToStack(stick2, o);
                                    stick3 = stick2;
                                    count3 = count2;
                                    index = 2;
                                }
                                for (int j = 0; j < 4; j++) {
                                    if (shapes[j].getX() == o.getX() && shapes[j].getY() == o.getY()) {
                                        shapes[j].setBoolean(true);
                                    }
                                }
                                constant.add(moving.remove(moving.indexOf(o)));
                                control.add(o);
                                k++;
                                if (stick3 != null) {
                                    checkStack(stick3, count3, index);
                                }
                                o.setY(o.getY());
                            }
                        }
                    } else if (count2 >= 1 && count1 == 0) {
                        ImageObject m = (ImageObject) o;
                        if (intersect(control.get(k1), o) || intersect(stick2.peakImage(stick2.size() - 1), o)) {
                            if (m.gettype() == 2) {
                                notifyBomb();
                                m.setVisible(false);
                            } else {
                                if (intersect(control.get(k1), o)) {
                                    count1++;
                                    addToStack(stick1, o);
                                    stick3 = stick1;
                                    count3 = count1;
                                    index = 1;
                                } else if (intersect(stick2.peakImage(stick2.size() - 1), o)) {
                                    count2++;
                                    addToStack(stick2, o);
                                    stick3 = stick2;
                                    count3 = count2;
                                    index = 2;
                                }
                                for (int j = 0; j < 4; j++) {
                                    if (shapes[j].getX() == o.getX() && shapes[j].getY() == o.getY()) {
                                        shapes[j].setBoolean(true);
                                    }
                                }
                                constant.add(moving.remove(moving.indexOf(o)));
                                control.add(o);
                                k++;
                                if (stick3 != null) {
                                    checkStack(stick3, count3, index);
                                }
                                o.setY(o.getY());
                            }
                        }
                    } else if (count1 == 0 && count2 == 0) {
                        ImageObject m = (ImageObject) o;
                        if (intersect(control.get(k1), o) || intersect(control.get(k2), o)) {
                            if (m.gettype() == 2) {
                                notifyBomb();
                                m.setVisible(false);
                            } else {
                                if (intersect(control.get(k1), o)) {
                                    count1++;
                                    addToStack(stick1, o);
                                    stick3 = stick1;
                                    count3 = count1;
                                    index = 1;

                                } else if (intersect(control.get(k2), o)) {
                                    count2++;
                                    addToStack(stick2, o);
                                    stick3 = stick2;
                                    count3 = count2;
                                    index = 2;
                                }
                                for (int j = 0; j < 4; j++) {
                                    if (shapes[j].getX() == o.getX() && shapes[j].getY() == o.getY()) {
                                        shapes[j].setBoolean(true);
                                    }
                                }

                                constant.add(moving.remove(moving.indexOf(o)));
                                control.add(o);
                                k++;
                                if (stick3 != null) {
                                    checkStack(stick3, count3, index);
                                }
                                o.setY(o.getY());
                            }
                        }
                    } else if ((intersect(stick1.peakImage(stick1.size() - 1), o) || intersect(stick2.peakImage(stick2.size() - 1), o)) && (count1 != 0 || count2 != 0)) {
                        int platePos = control.get(k - 1).getX();
                        ImageObject m = (ImageObject) o;
                        int c = 0;
                        if (m.gettype() == 2) {
                            notifyBomb();
                            m.setVisible(false);
                        } else {
                            if (intersect(stick1.peakImage(stick1.size() - 1), o)) {

                                count1++;
                                addToStack(stick1, o);
                                stick3 = stick1;
                                count3 = count1;
                                index = 1;
                            } else if (intersect(stick2.peakImage(stick2.size() - 1), o)) {

                                count2++;
                                addToStack(stick2, o);
                                stick3 = stick2;
                                count3 = count2;
                                index = 2;
                            }
                            for (int j = 0; j < 4; j++) {
                                if (shapes[j].getX() == o.getX() && shapes[j].getY() == o.getY()) {
                                    shapes[j].setBoolean(true);
                                }
                            }
                            constant.add(moving.remove(moving.indexOf(o)));
                            control.add(o);
                            k++;
                            if (stick3 != null) {
                                checkStack(stick3, count3, index);
                            }
                            o.setY(o.getY());
                        }
                    }

                }
            }
        }

    }

    @Override
    public boolean refresh() {

        boolean timeout = System.currentTimeMillis() - StartTime > MaxTime;
        ImageObject clown = (ImageObject) control.get(0);
        if (health == 0) {
            currentState = new GameOverState(this);
            timeout = true;
        }
        currentState.update();
        return !timeout;
    }

    @Override
    public String getStatus() {
        return "Score=" + Score + "   |   Time=" + Math.max(0, (MaxTime - (System.currentTimeMillis() - StartTime)) / 1000) + "    |    Health=" + health;
    }

    @Override
    public int getSpeed() {
        return this.DefaultSpeed;
    }

    @Override
    public int getControlSpeed() {
        return this.DefaultClownSpeed;
    }

    @Override
    public void collect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addToStack(Stack stick, GameObject o) {
        int i = 0;
        while (i < shapeArray.size()) {
            if (shapeArray.get(i).getImageObject() == (ImageObject) o) {
                stick.push(shapeArray.get(i), shapeArray.get(i).getImageObject());
            }
            i++;
        }
    }

    public void checkStack(Stack stick, int count, int index) {
        int i = stick.size();
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        if (i >= 3) {
            if (stick.peak(i - 1).getColor().equals(stick.peak(i - 2).getColor()) && stick.peak(i - 1).getColor().equals(stick.peak(i - 3).getColor())) {

                int m = control.size();
                int j = 0;
                stick.peakImage(i - 1).setVisible(false);
                while (j < shapeArray.size()) {
                    if (shapeArray.get(j).getImageObject() == stick.peakImage(i - 1)) {
                        shapeArray.remove(j);
                    }
                    j++;
                }
                while (counter1 < control.size()) {
                    if (control.get(counter1).equals(stick.peakImage(i - 1))) {
                        control.remove(counter1);
                    }
                    counter1++;

                }
                k--;
                stick.peakImage(i - 2).setVisible(false);
                j = 0;
                while (j < shapeArray.size()) {
                    if (shapeArray.get(j).getImageObject() == stick.peakImage(i - 2)) {
                        shapeArray.remove(j);
                    }
                    j++;
                }
                while (counter2 < control.size()) {
                    if (control.get(counter2).equals(stick.peakImage(i - 2))) {
                        control.remove(counter2);
                    }
                    counter2++;

                }
                k--;
                stick.peakImage(i - 3).setVisible(false);
                j = 0;
                while (j < shapeArray.size()) {
                    if (shapeArray.get(j).getImageObject() == stick.peakImage(i - 3)) {
                        shapeArray.remove(j);
                    }
                    j++;
                }
                while (counter3 < control.size()) {
                    if (control.get(counter3).equals(stick.peakImage(i - 3))) {
                        control.remove(counter3);
                    }
                    counter3++;

                }
                k--;
                stick.popShape();
                stick.popShape();
                stick.popShape();
                stick.popImage();
                stick.popImage();
                stick.popImage();
                if (count == count1) {
                    count1 = count1 - 3;
                } else if (count == count2) {
                    count2 = count2 - 3;
                }
                Score = Score + 10;

            }

        }

    }

    public void moveShapes(GameObject o) {
        if ((o.getY() == 25 && ((ImageObject) o).getz() == 1) || (flag2 == 1 && o.getX() == 300)) {
            if (o.getX() != 300) {
                o.setX((o.getX() + 1));
                o.setY((o.getY()));
            } else {
                o.setX(o.getX());
                o.setY(o.getY() + 1);
                flag2 = 1;
            }
        } else if ((o.getY() == 125 && ((ImageObject) o).getz() == 2) || (flag3 == 1 && o.getX() == 150)) {
            if (o.getX() != 150) {
                o.setX((o.getX() + 1));
                o.setY((o.getY()));
            } else {
                o.setX(o.getX());
                o.setY(o.getY() + 1);
                flag3 = 1;
            }
        } else if ((o.getY() == 26) && ((ImageObject) o).getz() == 3 || (flag4 == 1 && o.getX() == 450)) {
            if (o.getX() != 450) {
                o.setX((o.getX() - 1));
                o.setY((o.getY()));
            } else {
                o.setX(o.getX());
                o.setY(o.getY() + 1);
                flag4 = 1;
            }
        } else if ((o.getY() == 126 && ((ImageObject) o).getz() == 4) || (flag5 == 1 && o.getX() == 600)) {
            if (o.getX() != 600) {
                o.setX((o.getX() - 1));
                o.setY((o.getY()));
            } else {
                o.setX(o.getX());
                o.setY(o.getY() + 1);
                flag5 = 1;
            }

        }
        if (o.getY() == getHeight()) {
            if (((ImageObject) o).getz() == 1) {
                o.setY((int) (25));
                o.setX((int) (0));
            }
            if (((ImageObject) o).getz() == 2) {
                o.setY((int) (125));
                o.setX((int) (0));
            }
            if (((ImageObject) o).getz() == 3) {
                o.setY((int) (26));
                o.setX((int) (800));
            }
            if (((ImageObject) o).getz() == 4) {
                o.setY((int) (126));
                o.setX((int) (800));
            }
        }
    }

    public void notifyBomb() {
        health--;
    }

    public void addPlateObserver(PlateObserver plateObserver) {
        plateObservers.add(plateObserver);
    }

    public void removePlateObserver(PlateObserver plateObserver) {
        plateObservers.remove(plateObserver);
    }

    public void notifyPlateReachedEnd() {
        for (PlateObserver observer : plateObservers) {
            observer.onPlateReachedEnd();
        }
    }
}
