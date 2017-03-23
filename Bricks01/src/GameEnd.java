/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adeesha
 */
public class GameEnd {
    
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected char[] list;
    
    public GameEnd(int placeX,int placeY,int sizeW,int sizeH,char[] word){
        this.x = placeX;
        this.y = placeY;
        this.width = sizeW;
        this.height = sizeH;
        this.list = word;
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
    
    
}
