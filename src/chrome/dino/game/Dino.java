/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrome.dino.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Dino implements RenderObjects{
    private int mass = 5;
    private int dino_start_x;
    private int dino_start_y;
    private int temp_position_y;
    private boolean isDown = false; 
    Rectangle dinoRect;
    Dino(int dino_start){
        dino_start_x=0;
        dino_start_y=temp_position_y=dino_start;
    }

    @Override
    public void render_objects(Graphics g) {
        g.fillRect(dino_start_x, dino_start_y, 20 , 40);
        dinoRect= new Rectangle(dino_start_x, dino_start_y, 20 , 40);
    }
    
    public int get_Dino_centerX(){
        return dino_start_x;
    }
    
    public boolean movable(String x){
        if(x.toLowerCase().equals("intro")){
            if(dino_start_x<=300){
                dino_start_x+=4;
            }
            else{
                return true;
            }
            return false;
        }
        else if(x.toLowerCase().equals("jump")){
            if(!isDown){
                if(dino_start_y>=temp_position_y-100){
                    dino_start_y-=Math.abs(mass+8);
                    mass-=1;
                }
                else{
                    isDown=true;
                    mass=5;
                }
            }
            if(isDown){
                if(dino_start_y<=temp_position_y){
                    dino_start_y+=mass;
                    mass+=2;
                }
                else{
                    isDown=false;
                    dino_start_y=temp_position_y;
                    mass=5;
                    return true;
                }
            }      
            return false;
        }
        return false;
    }

    @Override
    public boolean movable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
