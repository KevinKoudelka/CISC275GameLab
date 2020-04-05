import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.scene.image.Image;
//Kevin Koudelka, Jason Belak, Bobby Stahl
public class Model {
	int picInd = 0;
    double xloc = 0;
    double yloc = 0;
    final double xIncr = 20;
    final double yIncr = 20;
    int Width = 1380;
    int Height = 940;
    int imgWidth = 165;
    int imgHeight = 165;
    Direction direction = Direction.SOUTHEAST;
    boolean hflag = true;
    boolean hnegflag = false;
	boolean vflag = false;
	boolean vnegflag = false;
	boolean wflag = false;
	boolean aflag = false;
	boolean sflag = false;
	boolean dflag = false;
 

	public Model(int width, int height, int imageWidth, int imageHeight) {
		this.Width = width;
		this.Height = height;
		this.imgWidth = imageWidth;
		this.imgHeight = imageHeight;
	}

	public double getX() {
		return xloc;
	}
	public void setY() {
		wflag = true;
		aflag = false;
		sflag = false;
		dflag = false;
		vflag = false;
		hflag = false;
		hnegflag = false;
		vnegflag = false;
		
	}
	public void setYneg() {
		sflag = true;
		wflag = false;
		aflag = false;
		dflag = false;
		hflag = false;
		vflag = false;
		hnegflag = false;
		vnegflag = false;
	}
	public void setX() {
		dflag = true;
		wflag = false;
		aflag = false;
		sflag = false;
		vflag = false;
		hflag = false;
		hnegflag = false;
		vnegflag = false;
	}
	public void setXneg() {
		aflag = true;
		wflag = false;
		sflag = false;
		dflag = false;
		hflag = false;
		vflag = false;
		hnegflag = false;
		vnegflag = false;
	}
	public double getY() {
		return yloc;
	}

	public Direction getDirection() {
		return direction;
	}
    public void updateLocationandDirection() {
    	if (xloc >= 1100) {
   		 hnegflag = true;
   		 hflag = false;
   	 }
   	 	else if (xloc <= -50) {
   		 hflag = true;
   		 hnegflag = false;
   	 }
   	 	else if (yloc <= -50) {
   		 vflag = true;
   		 vnegflag = false;
   	 }
   	 	else if (yloc >= 500) {
   		 vnegflag = true;
   		 vflag = false;
   	 }
    	if (hflag == true) {
        	xloc += xIncr;
        }
    	else if (hnegflag == true) {
    		xloc -= xIncr;
    	}
    	else if (vflag == true) {
        	yloc += yIncr;
        }
        else if (vnegflag == true) {
        	yloc -= yIncr;
        }
        else if (wflag == true) {
        	yloc -= yIncr;
        }
        else if (dflag == true) {
    		xloc += xIncr;
    	}
    	else if (aflag == true) {
    		xloc -= xIncr;
    	}
        else if (sflag == true){
        	yloc += yIncr;
        }
    	if (hflag && vflag) {
    		direction = Direction.EAST;
    	} else if (vnegflag && !hnegflag) {
    		direction = Direction.NORTH;
    	} else if (vflag && !vnegflag) {
    		direction = Direction.SOUTH;
    	} else if (hflag && !hnegflag) {
    		direction = Direction.EAST;
    	} else if (hnegflag && !hflag) {
    		direction = Direction.WEST;
    	} else if (wflag){
    		direction = Direction.NORTH;
    	} else if (dflag) {
    		direction = Direction.EAST;
    	} else if (aflag) {
    		direction = Direction.WEST;
    	} else if (sflag) {
    		direction = Direction.SOUTH;
    	}
    }
}
