/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrome.dino.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Obstracle implements RenderObjects{
    
    private int xpos;
    private final int ypos;
    private final int xvel=6;
    private int yheight=10;
    private final int screenwidth;
    private final int obs_id;
    private final int set_gap = 60;
    Random random1 = new Random();
    Random random2 = new Random();
    Rectangle obstracleRect;
    private final Color color;
    
    Obstracle(int ypos,int screenwidth,Color color,int obsid){
        this.obs_id=obsid;
        this.color=color;
        this.screenwidth=screenwidth;
        this.ypos=ypos;
        this.yheight=50;
        reset_start();
    }
    
    public int get_Obstracle_centerX(){
        return xpos;
    }
    
    @Override
    public void render_objects(Graphics g) {
        g.setColor(this.color);
        g.fillRect(xpos, ypos-yheight, 30, yheight);
        obstracleRect=new Rectangle(xpos, ypos-yheight, 30, yheight);
    }

    public boolean movable() {
        if(obs_id==0){
            if(xpos>-20){
                xpos = xpos - xvel;
                return true;
            }      
        }
        if(obs_id==1){
            if(xpos>-10){
                xpos = xpos - xvel;
                return true;
            }
        }
        reset_start();
        return true;
    }
    private void reset_start(){
        if(obs_id==0){
            xpos=screenwidth+random1.nextInt(40);
        }
        else{
            xpos=screenwidth+random2.nextInt(40)+ 100;
        }
    }

    @Override
    public boolean movable(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
