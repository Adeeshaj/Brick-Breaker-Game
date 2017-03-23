
import java.util.Random;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adeesha
 */
    
public class Hole extends GameEntity  {
    
    private int dx;
    private int dy;
    public Hole(int gameW, int gameH, int startX, int startY, int width, int height) {
        super(gameW, gameH, startX, startY, width, height);
        
    }
    
    public void update(){
        x += dx;
        y += dy;
    }
    
    public void increaseX(){
        dx = 5;
    }
    
    public void decreaseX(){
        dx = -5;
    }
    
    public void increaseY(){
        dy = 5;
    }
    
    public void decreaseY(){
        dy = -5;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getGameWidth() {
        return gameWidth;
    }

    public int getGameHight() {
        return gameHight;
    }

    
    
    
    


    
}
