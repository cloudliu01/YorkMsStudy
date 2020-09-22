import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group; 
import javafx.scene.Node; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.Background; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Arc; 
import javafx.scene.shape.ArcType; 
import javafx.scene.shape.Circle; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.stage.Stage; 
import javafx.geometry.Pos;

public class ChangingFace2 extends Application {
	
	 @Override     
	 public void start(Stage stage)     
	 { 
		 // create and configure the main circle for the face        
		 Circle face = new Circle(125, 125, 80);          
		 face.setFill(Color.YELLOW);         
		 face.setStroke(Color.RED);  
		 
		 // create and configure the circle for the right eye         
		 Circle rightEye = new Circle(86, 100, 10);         
		 rightEye.setFill(Color.YELLOW);         
		 rightEye.setStroke(Color.BLUE); 
		 
		 // create and configure the circle for the left eye         
		 Circle leftEye = new Circle(162, 100, 10);         
		 leftEye.setFill(Color.YELLOW);         
		 leftEye.setStroke(Color.BLUE);   
		 
		 // create and configure a smiling mouth (this is how it will start)    
		 Arc mouth = new Arc(125, 150, 45, 35, 0, -180);          
		 mouth.setFill(Color.YELLOW);         
		 mouth.setStroke(Color.BLUE);         
		 mouth.setType(ArcType.OPEN); 

		 Arc mouthSmile = new Arc(125, 150, 45, 35, 0, -180);          
		 mouthSmile.setFill(Color.YELLOW);         
		 mouthSmile.setStroke(Color.BLUE);         
		 mouthSmile.setType(ArcType.OPEN); 

		 Arc mouthThink = new Arc(125, 150, 45, 35, 0, 180);          
		 mouthThink.setRadiusY(0);
		 mouthThink.setFill(Color.YELLOW);         
		 mouthThink.setStroke(Color.BLUE);         
		 mouthThink.setType(ArcType.OPEN); 

		 Arc mouthFrown = new Arc(125, 150, 45, 35, 0, 180);          
		 mouthFrown.setFill(Color.YELLOW);         
		 mouthFrown.setStroke(Color.BLUE);         
		 mouthFrown.setType(ArcType.OPEN); 
		 
		 // create and configure the text        
		 Text caption = new Text(68, 240, "Changing Face");         
		 caption.setFill(Color.BLUE);         
		 caption.setFont(Font.font ("Verdana", 15));
		 
		 // create a group that holds all the features           
		 Group group = new Group(face, rightEye, leftEye, mouthSmile,  caption); 
		 
		 // create a button that will make the face smile         
		 Button smileButton = new Button("Smile"); 

		 // create a button that will make the face think
		 Button thinkButton = new Button("Think"); 
		 
		 // create a button that will make the face frown         
		 Button frownButton = new Button("Frown"); 
	 
	     // create and configure a horizontal container to hold the buttons    
		 HBox buttonBox = new HBox(10);         
		 buttonBox.setAlignment(Pos.CENTER); 
		 
		 //add the buttons to the horizontal container         
		 buttonBox.getChildren().addAll(smileButton, thinkButton, frownButton);
		 
		 // create and configure a vertical container to hold the button box and the face group         
		 VBox root = new VBox(10); 
		 root.setBackground(Background.EMPTY);         
		 root.setAlignment(Pos.CENTER); 
		 
		 //add the button box and the face group to the vertical container         
		 root.getChildren().addAll(buttonBox, group);
		 
		 // create and configure a new scene         
		 Scene scene = new Scene(root, 250, 275, Color.YELLOW);
		 

		 // supply the code that is executed when the smile button is pressed  
		 smileButton.setOnAction(e ->
		 	{
		 		// Get all nodes inside the group
		 		ObservableList<Node> nodes = group.getChildren();
		 		if (!nodes.contains(mouthSmile)) {
		 			group.getChildren().remove(3);
		 			group.getChildren().add(3, mouthSmile);
		 			System.out.print("Change to smile\n");
		 		} else {
		 			System.out.print("Kept smile\n");
		 		}
		 	}
		 );

		 // supply the code that is executed when the think button is pressed  
		 thinkButton.setOnAction(e -> 
		 	{
		 		// Get all nodes inside the group
		 		ObservableList<Node> nodes = group.getChildren();
		 		if (!nodes.contains(mouthThink)) {
		 			group.getChildren().remove(3);
		 			group.getChildren().add(3, mouthThink);
		 			System.out.print("Change to think\n");
		 		} else {
		 			System.out.print("Kept think\n");
		 		}
		 	}
		 );
				 
		 // supply the code that is executed when the frown button is pressed   
		 frownButton.setOnAction(e -> 
		 	{
		 		// Get all nodes inside the group
		 		ObservableList<Node> nodes = group.getChildren();
		 		if (!nodes.contains(mouthFrown)) {
		 			group.getChildren().remove(3);
		 			group.getChildren().add(3, mouthFrown);
		 			System.out.print("Change to frown\n");
		 		} else {
		 			System.out.print("Kept frown\n");
		 		}
		 	}
		 );
		 
		 // add the scene to the stage, then set the title        
		 stage.setScene(scene);         
		 stage.setTitle("Changing Face");  
		 
		 // show the stage         
		 stage.show();             
	}         
	 
	 public static void main(String[] args)     
	 {         
		 launch(args);     
	 }
}
	


