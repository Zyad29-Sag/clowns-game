/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

/**
 *
 * @author Legion
 */
import javax.swing.*;

/*class ImagePanel2 extends JPanel {

    public ImagePanel2(String imagePath) {
        setOpaque(true); // Set JPanel to be opaque
        setBackground(new Color(153, 0, 0));
    }

    
}*/
public class newGUI extends JFrame{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame
            JFrame frame = new JFrame("new");
            System.out.println("in");

            // Create a panel with the background image
            ImagePanel panel = new ImagePanel("C:\\Users\\Legion\\Desktop\\i55.png", 1); // Replace with your image path
            // panel.setLayout(new BorderLayout());
            frame.add(panel);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
