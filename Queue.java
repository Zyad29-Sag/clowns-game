/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Legion
 */
public class Queue implements QueueData {

    Factory f = new Factory();
    List<Shape> queue1 = new ArrayList<>();
    List<Shape> queue2 = new ArrayList<>();
    List<Shape> queue3 = new ArrayList<>();
    List<Shape> queue4 = new ArrayList<>();
    Array array = new Array();

    public void Enqueue(Shape s, int x) {
        switch (x) {
            case 1 ->
                queue1.add(s);
            case 2 ->
                queue2.add(s);
            case 3 ->
                queue3.add(s);
            default ->
                queue4.add(s);
        }

    }

    public Shape Dequeue(int x) {
        return switch (x) {
            case 1 ->
                queue1.remove(0);
            case 2 ->
                queue2.remove(0);
            case 3 ->
                queue3.remove(0);
            default ->
                queue4.remove(0);
        };
    }

    public void loadQueue() throws FileNotFoundException, IOException {
        int i = 0;
        ImageObject[] array2 = array.returnArray();
        Path path1 = Paths.get(FILE_NAME);
        File filepath = new File(path1.toAbsolutePath().toString());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        String line = "";
        int y = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] splitArray = line.split(",");
     //       System.out.println(splitArray[0] + " " + splitArray[1] + " " + array2[i]);
            Shape shape = f.createShape(splitArray[0], splitArray[1], array2[i]);
            if (y < 6) {
                Enqueue(shape, 1);
            } else if (y >= 6 && y < 12) {
                Enqueue(shape, 2);
            } else if (y >= 12 && y < 18) {
                Enqueue(shape, 3);
            } else if (y >= 18 && y < 24) {
                Enqueue(shape, 4);
            }
            y++;
            i++;
        }
        /* while (!queue.isEmpty()) {
           // System.out.println(" " + Dequeue().getShapeName());

        }*/

    }

}
