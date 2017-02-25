/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrome.dino.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Family
 */
public class ChromeDinoGame extends JFrame{
    
    Frame_W gameFrame;
    final Dimension screen_resolution = Toolkit.getDefaultToolkit().getScreenSize();
    final int screen_width = screen_resolution.width;
    final int screen_height = screen_resolution.height;
    ChromeDinoGame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame = new Frame_W(screen_width,screen_height);
        setUndecorated(true);
        setBackground(new Color(0,0,0,40));
        
        getContentPane().add(gameFrame);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new ChromeDinoGame();
            }
        });
        
    }
    
}
