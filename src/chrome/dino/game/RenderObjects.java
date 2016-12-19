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
public interface RenderObjects {
    public void render_objects(Graphics g);
    public boolean movable(String x);
    public boolean movable();
}
