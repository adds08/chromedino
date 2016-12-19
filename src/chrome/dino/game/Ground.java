/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrome.dino.game;

import java.awt.Graphics;

/**
 *
 * @author Family
 */
public class Ground implements RenderObjects{

    private int groundy1;
    private int groundx2;
   
    Ground(int ground_start,int screen_width){
        this.groundy1=ground_start;
        this.groundx2=screen_width;
    }
    
    @Override
    public void render_objects(Graphics g) {
        g.drawLine(0, groundy1, groundx2, groundy1);
    }

    @Override
    public boolean movable() {
        return false;
    }

    @Override
    public boolean movable(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
