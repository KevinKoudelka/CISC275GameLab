import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class View {
	final int canvasCount = 10;
    final static int Width = 500;
    final static int Height = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
	int picInd = 0;
    Stage theStage;
    Canvas canvas = new Canvas(Width, Height);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    
    Image orc_img = createImage("/orc_animation/orc_forward_southeast.png");
    Image orc_northwest = createImage("/orc_animation/orc_forward_northwest.png");
    Image orc_northeast = createImage("/orc_animation/orc_forward_northeast.png");
    Image orc_southwest = createImage("/orc_animation/orc_forward_southwest.png");
    
    
    public View(Stage x){
    	this.theStage=x;
    	Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        root.getChildren().add(canvas);
    }

	public int getImageWidth() {
		return imgWidth;
	}

	public int getWidth() {
		return Width;
	}

	public int getImageHeight() {
		return imgHeight;
	}

	public int getHeight() {
		return Height;
	}
	public void update(double x, double y, Direction direction) {
		gc.clearRect(0, 0, Width, Height);
		
		if (direction.getName()=="southeast") {
            gc.drawImage(orc_img, imgWidth*picInd, 0, imgWidth, imgHeight,
                                x, y, imgWidth, imgHeight);
            }
            else if (direction.getName()=="southwest") {
            gc.drawImage(orc_southwest, imgWidth*picInd, 0, imgWidth, imgHeight,
                    x, y, imgWidth, imgHeight);
            }
            else if (direction.getName()=="northwest") {
            gc.drawImage(orc_northwest, imgWidth*picInd, 0, imgWidth, imgHeight,
                   x, y, imgWidth, imgHeight);
            }
            else if (direction.getName()=="northeast") {
                gc.drawImage(orc_northeast, imgWidth*picInd, 0, imgWidth, imgHeight,
                       x, y, imgWidth, imgHeight);
            }
            picInd = (picInd + 1) % canvasCount;
    
        
	}
    private Image createImage(String x) {
        Image img = new Image(x);
        return img;   	
    }

}
