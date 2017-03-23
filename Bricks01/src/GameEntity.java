/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adeesha
 */
public abstract class GameEntity {
     protected int x;
     protected int y;
     protected int width;
     protected int height;
     
     protected int gameWidth;
     protected int gameHight;



     public GameEntity(int gameW,int gameH,int startX, int startY,int width,int height){
        
        this.gameWidth = gameW;
        this.gameHight = gameH;
        
        this.x = startX;
        this.y = startY;
        
        this.height = height;
        this.width=width;
        
        
        
    }
}