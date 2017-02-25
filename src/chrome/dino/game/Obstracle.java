/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrome.dino.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Obstracle implements RenderObjects{
    
    private int xpos;
    private final int ypos;
    private double xvel=3;
    private int yheight=10;
    private final int screenwidth;
    private final int obs_id;
    private final int set_gap = 60;
    Random random1 = new Random();
    Rectangle obstracleRect;
    Image imgObs;
    Obstracle(int ypos,int screenwidth,int obsid){
        this.obs_id=obsid;
        this.xpos=screenwidth; 
        this.screenwidth=screenwidth;
        this.ypos=ypos;
        this.yheight=50;
        try {
            imgObs = ImageIO.read(new File("res/images/snakePic.png"));
        } catch (IOException ex) {
            Logger.getLogger(Obstracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        reset_start();
    }
    
    public int get_Obstracle_centerX(){
        return xpos;
    }
    
    @Override
    public void render_objects(Graphics g) {
        g.drawImage(imgObs, xpos, ypos-yheight, null);
        obstracleRect=new Rectangle(xpos, ypos-yheight, 44, yheight);
    }

    public boolean movable() {
        if(obs_id==0){
            if(xpos>-50){
                xpos = xpos - (int)xvel;
                if(xvel<=5)xvel+=0.25;
                return true;
            }      
        }
        if(obs_id==1){
            if(xpos>-10){
                xpos = xpos - (int)xvel;
                if(xvel<=9)xvel+=0.16;
                return true;
            }
        }
        reset_start();
        return true;
    }
    private void reset_start(){
            xvel=3;
            xpos =(screenwidth)+(random1.nextInt(60)+70);
    }
    @Override
    public boolean movable(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
