/**
 * Description	:Engine for the brick game
 * Copyright	:Copyright (c) 2014
 * Company		:Embla Software Innovations (Pvt) Ltd
 * Created on	:2014.09.01
 * @author 		:Chandimal
 * @version 	:1.0
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements KeyListener {

	private static final long serialVersionUID = 1L;

	BufferedImage buffer; // Create the buffer
        Ball ball;
        Bat bat;
        GameEnd over;
        
        boolean isLeft;
        boolean isRight;
        boolean isFail;
        boolean touchBat;
        
        ScoreBoard board;
        Hole endHole;
        
        
	/**
	 * Create the game using the width and the height specified
     * @param dim
	 */
	public Game(Dimension dim) {
               touchBat = false;
                isFail = false;
		buffer = new BufferedImage(dim.width, dim.height,BufferedImage.TYPE_INT_RGB);
		this.setIgnoreRepaint(true); // Ignore repainting as we are doing all
										// the drawing stuff
                ball = new Ball(dim.width,dim.height,100,dim.height-550,10,1);
                bat = new Bat(dim.width,dim.height,50,dim.height-50,50,10,1);
                char[] x = {'a'};
                over = new GameEnd(50,50,10,10,x);
                board = new ScoreBoard(10,20);
                endHole = new Hole(dim.width,dim.height,200,300,15,15);
                
        }

	/**
	 * Start the game
	 */
	public void Start() {

		while (true) {
                    
                    switch (Integer.parseInt(board.getScore())%6){
                        case 0:
                            endHole.increaseX();
                            break;
                        case 3:
                            endHole.increaseY();
                            break;
                        case 2:
                            endHole.decreaseX();
                            break;
                        case 5: 
                            endHole.decreaseY();
                            break;
                    }

                    if (ball.getY()== ball.gameHight || isFail ){

                       drawEndBuffer();
                       drawScreen();
                    }
                    else{
                    ball.update();
                    detectCollisions();
                    if(isLeft){
                        bat.setLeft();
                    }
                    if (isRight){
                        bat.setRight();
                    }
                    bat.update();
                    if (touchBat){
                        endHole.update();
                        touchBat = false;
                    }
                    // Draw the buffer
                    drawBuffer();
                    // Paint the buffer on screen
                    drawScreen();

                    try {
                            Thread.sleep(3);
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                    }
		}
	}
	
	/**
	 * Draw the image buffer
	 */
	public void drawBuffer() {
		Graphics2D b = buffer.createGraphics();
		
                
             
		// Random color background
		//Color c = new Color(new Random().nextInt());
		b.setColor(Color.BLACK);
		b.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
                
              
                
                b.setColor(Color.WHITE);
                b.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
                
                b.setColor(Color.WHITE);
                b.fillRoundRect(bat.getX(), bat.getY(), bat.getwidth(), bat.getheight(), 6,6);
                
                b.setColor(Color.GREEN);
                b.drawString("SCORE "+board.getScore(), board.getX(), board.getY());
                
                
                b.setColor(Color.RED);
                b.fillOval(endHole.getX(), endHole.getY(), endHole.getWidth(), endHole.getWidth());
                
                b.setColor(Color.WHITE);
                b.fillRect(0, 40, 400, 10);
                
               
                
	}
        
        public void drawEndBuffer() {
                
		Graphics2D b = buffer.createGraphics();
                 
		
		// Random color background
		//Color c = new Color(new Random().nextInt());
        	b.setColor(Color.BLACK);
                b.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

                b.setColor(Color.RED);
                b.drawString("Game Over", over.getX(), over.getY());
                
                b.setColor(Color.GREEN);
                b.drawString("your Score: "+ board.getScore(), 100, 100);
                
               
                
                
	}
 

	/**
	 *  Update it to the screen
	 */
	public void drawScreen() {
		Graphics2D g = (Graphics2D) this.getGraphics();
		g.drawImage(buffer, 0, 0, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
        
    public void detectCollisions(){
        Rectangle rectBall = new Rectangle(ball.getX(),ball.getY(),ball.getSize(),ball.getSize());
        Rectangle rectmidBat = new Rectangle(bat.getX()+5,bat.getY(),bat.getwidth()-10,bat.getheight());
        Rectangle rectleftBat = new Rectangle(bat.getX(),bat.getY(),10,bat.getheight());
        Rectangle rectRightBat = new Rectangle(bat.getX()+40,bat.getY(),10,bat.getheight());
        Rectangle rectHole = new Rectangle(endHole.getX(),endHole.getY(),endHole.getWidth(),endHole.getHeight());
        
        if(rectHole.intersects(rectBall)){
            isFail = true;
        }
        if(rectmidBat.intersects(rectBall)){
            ball.reverse();
            board.increaseScore();
            touchBat = true;
        }
        if(rectleftBat.intersects(rectBall)){
            ball.reverseleft();
            board.increaseScore();
            touchBat = true;
        }
        if(rectRightBat.intersects(rectBall)){
            ball.reverseright(); 
            board.increaseScore();
            touchBat = true;
            
        }
    }
    
    


    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode() == 37){
           isLeft = true;
       }
       
       if (e.getKeyCode() == 39){
           isRight = true;
       }
        //System.out.println(">>>> " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 37){
           isLeft = false;
        }
       
        if (e.getKeyCode() == 39){
           isRight = false;
        }
    }
    
    public int getScore(){
        return Integer.parseInt(board.getScore());
    }
    
   

}
