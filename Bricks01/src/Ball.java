/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adeesha
 */
public class Ball extends GameEntity {

    private int dx;
    private int dy;
    
    public Ball(int gameW,int gameH,int startX, int startY,int size,int speed){
        
        super (gameW,gameH,startX,startY,size,size);
        dx = speed;
        dy = speed;
        
               
    }
    
    public void update(){
       
        
        if(y>gameHight){
            dy = -1;
        }
        
        if (x>gameWidth-10){
            dx = -1;
        }
        
        if (x<0){
            dx = 1;
        }
        
        if (y<50){
            dy = 1;
        }
        
        x = x + dx;
        y = y + dy;
    }
    
    public int getX(){
        return x;
    }
    
      public int getY(){
        return y;
    }  public int getSize(){
        return width;
    }
    public int getGameHight(){
        return gameHight;
    }
    
    public void setX(int num){
        x = num;
    }
    
    public void SetY(int num){
        y = num;
    }
      
    public void SetSize(int num){
        width = num;
    }

    public void reverse() {
        dy = -1;
    }
    
    public void reverseleft(){
        dy = -1;
        dx = -1;
    }
    
    public void reverseright(){
        dy = -1;
        dx = 1;
    }
      
}
