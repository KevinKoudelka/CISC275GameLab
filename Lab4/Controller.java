
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

import javafx.animation.AnimationTimer;
//Kevin Koudelka, Jason Belak, Bobby Stahl
public class Controller extends Application {
	// data fields hold Model and View 
	private Model model;
	private View view;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage theStage) {
		view = new View(theStage);
		model = new Model(view.getWidth(), view.getHeight(),                 
				view.getImageWidth(), view.getImageHeight());  
		new AnimationTimer() {            
			public void handle(long currentNanoTime)    {                
			//increment the x and y coordinates, alter direction if necessary                
				model.updateLocationandDirection();
				//input the x coordinates, y coordinates, and direction picture
				view.update(model.getX(), model.getY(), model.getDirection()); 
				view.getGC().getCanvas().getScene().setOnKeyPressed((k) -> {
					KeyCode key = k.getCode();
			    	
			    	if (key == KeyCode.W) {
			    		model.setY();

			    	}
			    	else if (key == KeyCode.S) {
			    		model.setYneg();
			    	}
			    	else if (key == KeyCode.D) {
			    		model.setX();
			    	}
			    		
			    	else if (key == KeyCode.A) {
			    		model.setXneg();
				}
				});
				try {                    
					Thread.sleep(100);                
					} catch (InterruptedException e) {
						e.printStackTrace();                
						}
				}        
			}.start();        
		theStage.show();  
	}
}
