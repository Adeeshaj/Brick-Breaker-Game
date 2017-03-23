 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adeesha
 */
public class ScoreBoard {
    private int score;
    private int x;
    private int y;
    
    
    public ScoreBoard(int placeX,int placeY){
        x= placeX;
        y= placeY;
        score = 0;
    }
    
    public void increaseScore(){
        score += 1;
    }

    public String getScore() {
        return Integer.toString(score);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
