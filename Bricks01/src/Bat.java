/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adeesha
 */
public class Bat extends GameEntity {
 
    
   
    private int dx;
    private final int speed;
    
    public Bat(int gameW,int gameH,int startX, int startY,int width,int height,int speedbat){
        
       super(gameW,gameH,startX,startY,width,height);
       speed = speedbat;      
    }
    
    public void update(){
        
        x = x + dx;
        //check edges
        if (this.x<= 0){
            this.x = 0;
        }
        
        if (this.x >= this.gameWidth- this.width){
            this.x = this.gameWidth - this.width;
        }

        this.dx = 0;
  
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    } 
    public int getheight(){
        return height;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public int getwidth(){
        return width;
    }
    
    public void setX(int num){
        x = num;
    }
    
    public void SetY(int num){
        y = num;
    }
      
    public void setLeft(){
        this.dx = -(this.speed);
    }
    
    public void setRight(){
        this.dx = (this.speed);
    }
    
}
