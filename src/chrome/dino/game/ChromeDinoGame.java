/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrome.dino.game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Family
 */
public class ChromeDinoGame extends JFrame{
    
    Frame_W gameFrame = new Frame_W();
    
    ChromeDinoGame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(gameFrame);
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
