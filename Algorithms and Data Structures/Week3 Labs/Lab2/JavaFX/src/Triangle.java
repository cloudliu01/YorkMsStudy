import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.Group;

public class Triangle extends Application {

	public void start (Stage stage)     {
		Line L1 = new Line(100.0, 70.0, 100.0, 250.0);
		Line L2 = new Line(100.0, 250.0, 400.0, 250.0);
		Line L3 = new Line(400.0, 250.0, 100.0, 70.0);
		L1.setStroke(Color.BLACK);

        // create a group that holds all the lines                     
		Group root = new Group(L1, L2, L3);

		Scene scene = new Scene(root, 500, 300, Color.YELLOW); 
	
		// add the scene to the stage, then set the title         
		stage.setScene(scene);         
		
		stage.show();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
}
