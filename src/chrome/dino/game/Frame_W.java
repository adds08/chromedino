/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrome.dino.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Screen;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Family
 */
public class Frame_W extends JPanel implements KeyListener{
    
    private final int frame_height = 600;
    private final int frame_width = 800;
    private final int ground_position = frame_height - 50;
    private final int dino_start = ground_position - 50;
    Dino dino = new Dino(dino_start);    
    Obstracle[] obstracle = new Obstracle[2];
    Ground ground = new Ground(ground_position,frame_width);
    Timer timer;
    Timer timerJ;
    private boolean isIntro=true;
    private boolean isJump=false;
    private volatile boolean isObstracleRender=false;
    static int score=0;
    private boolean isGameEnd=false;
    Frame_W(){
        setFocusable(true);
        setPreferredSize(new Dimension(frame_width,frame_height));
        addKeyListener(this);
        obstracle[0]=new Obstracle(ground_position, frame_width,Color.RED,0);
        obstracle[1]=new Obstracle(ground_position, frame_width,Color.BLUE,1);
        timer= new Timer(30,new IntroAction());
        timerJ= new Timer(40,new JumpAction());
        start_game_time();
    }
    
    private void start_game_time(){
        if(isIntro)timer.start();
        if(isJump)timerJ.start();
    }
    
    
    public class JumpAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(dino.movable("jump")){
                isJump=false;
                timerJ.stop();
            }
            
            repaint();
        }
        
    }
    public class IntroAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isIntro){
                if(dino.movable("intro")){
                    isIntro=false;
                    isObstracleRender=true;
                }
                
            }
            if(isObstracleRender){
                for(int i=0;i<2;i++){
                    if(obstracle[i].movable()){
                        check_collision();
                        check_score(i);
                    }
                }
                System.out.println(score);
            }
            repaint();
        } 
        
        public void check_collision(){
            if(obstracle[0].obstracleRect.intersects(dino.dinoRect) || obstracle[1].obstracleRect.intersects(dino.dinoRect)){
                timer.stop();
                timerJ.stop();
                isGameEnd=true;
                JOptionPane.showMessageDialog(null, "Game Over");
                System.exit(0);
            }
        }
        
        public void check_score(int x){
            if(x==0){
                if(obstracle[0].get_Obstracle_centerX()<=dino.get_Dino_centerX()+40 && obstracle[0].get_Obstracle_centerX()>=dino.get_Dino_centerX()-40){
                    score++;
                }
            }
            else{
                if(obstracle[1].get_Obstracle_centerX()<=dino.get_Dino_centerX()+40 && obstracle[1].get_Obstracle_centerX()>=dino.get_Dino_centerX()-40){
                    score++;
                }
            }
        }
    
    }

    public int get_frame_height(){
        return frame_height;
    }
    public int get_frame_width(){
        return frame_width;
    }
    public int get_frame_ground_position(){
        return ground_position;
    }
    public int get_frame_dino_position(){
        return dino_start;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dino.render_objects(g);
        ground.render_objects(g);
        obstracle[0].render_objects(g);
        obstracle[1].render_objects(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Calibri",0,40));
        g.drawString(String.valueOf(score), 50, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(!isJump){
            System.out.println("Key has been Listened");
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                isJump=true;
                start_game_time();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
