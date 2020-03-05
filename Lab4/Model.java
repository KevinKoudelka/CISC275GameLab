import javafx.scene.image.Image;

public class Model {
	int picInd = 0;
    double xloc = 0;
    double yloc = 0;
    final double xIncr = 8;
    final double yIncr = 2;
    int Width = 500;
    int Height = 300;
    int imgWidth = 165;
    int imgHeight = 165;
    Direction direction = Direction.SOUTHEAST;
    boolean hflag = true;
	boolean vflag = true;
 

	public Model(int width, int height, int imageWidth, int imageHeight) {
		this.Width = width;
		this.Height = height;
		this.imgWidth = imageWidth;
		this.imgHeight = imageHeight;
	}

	public double getX() {
		return xloc;
	}

	public double getY() {
		return yloc;
	}

	public Direction getDirection() {
		return direction;
	}
    public void updateLocationandDirection() {
    	if (xloc >= 400) {
   		 hflag = false;
   	 }
   	 	else if (xloc <= -50) {
   		 hflag = true;
   	 }
   	 	else if (yloc <= -50) {
   		 vflag = true;
   	 }
   	 	else if (yloc >= 200) {
   		 vflag = false;
   	 }
    	if (hflag == true) {
        	xloc += xIncr;
        	direction = Direction.NORTHEAST;
        }
        else{
        	xloc -= xIncr;
        	direction = Direction.NORTHWEST;
        }
        if (vflag == true) {
        	yloc += yIncr;
        	direction = Direction.NORTHWEST;
        }
        else{
        	yloc -= yIncr;
        	direction = Direction.SOUTHWEST;
        }
    	
        
    }

}
