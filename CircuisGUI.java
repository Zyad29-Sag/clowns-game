/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.world.circus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImagePanel extends JPanel {

    private  Image backgroundImage;

    public ImagePanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
        setOpaque(true); // Set JPanel to be opaque
        setBackground(new Color(153, 0, 0));
        setLayout(null); // Using null layout for absolute positioning of buttons
        createButtons();
    }
    
     public ImagePanel(String imagePath,int x) {
        backgroundImage = new ImageIcon(imagePath).getImage();
        setOpaque(true); // Set JPanel to be opaque
        setBackground(new Color(153, 0, 0));
        setLayout(null); 
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    private void createButtons() {
        // Create buttons and set their sizes and positions
         ImageIcon icon1 = new ImageIcon("C:\\Users\\Legion\\Desktop\\play now.jpeg"); 
        JButton button1 = new JButton(icon1);
         button1.setBounds(390, 380, 310, 100); // Using icon size
         button1.setBackground(Color.BLACK);
         button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when button1 is clicked
                CircuisGUI c = new CircuisGUI();
                c.setVisible(false);
               newGUI n= new newGUI(); // Open AnotherFrame when button1 is clicked
                n.setVisible(true);
                System.out.println("hewlloo");
              
            }
        });
        add(button1);
    }
}

public class CircuisGUI extends JFrame{
             
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame
            System.out.println("this class");
            JFrame frame = new JFrame("Clown Game");
            ImageIcon icon = new ImageIcon("C:\\Users\\Legion\\Desktop\\i55.png"); 
            Image image = icon.getImage();
            frame.setIconImage(image);
            ImagePanel panel = new ImagePanel("C:\\Users\\Legion\\Desktop\\28613.jpg");
            panel.setLayout(new BorderLayout());
            frame.add(panel);
            frame.setSize(1100, 900);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
