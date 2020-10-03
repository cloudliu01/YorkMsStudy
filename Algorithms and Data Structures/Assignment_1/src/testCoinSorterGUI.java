/**
 * @author Lizhuang Liu
 * date       Sep 29, 2020
 *
 */


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group; 
import javafx.scene.Node; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Background; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Arc; 
import javafx.scene.shape.ArcType; 
import javafx.scene.shape.Circle; 
import javafx.scene.text.Font; 
import javafx.stage.Stage; 
import javafx.geometry.Pos;
import javafx.beans.value.*;



public class testCoinSorterGUI extends Application {
    
    int FORM_WIDTH  = 500;
    int FORM_HEIGHT = 700;

    // info TextArea width
    int INFO_WIDTH  = 480;
    int INFO_HEIGHT = 200;

    // result TextArea width
    int RESULT_WIDTH  = 480;
    int RESULT_HEIGHT = 200;
        
    @Override
    public void start(Stage stage) {
        // Object of CoinSofterGUI 
        Integer[] coinList = {1,2,5,10,20,50};
        CoinSorterGUI csg = new CoinSorterGUI("Pounds sterling", 1, 999, coinList);

        // create a button that will execute option 1
        Button button1 = new Button("1"); 
        button1.setMinWidth(50);

        // create a button that will execute option 2
        Button button2 = new Button("2"); 
        button2.setMinWidth(50);

        // create a button that will execute option 3
        Button button3 = new Button("3"); 
        button3.setMinWidth(50);
     
        // create a button that will execute option 4
        Button button4 = new Button("4"); 
        button4.setMinWidth(50);

        // create a button that will execute option 5
        Button button5 = new Button("5"); 
        button5.setMinWidth(50);

        // create a button that will execute option 6
        Button button6 = new Button("6"); 
        button6.setMinWidth(50);

        // create and configure a horizontal container to hold the option buttons    
        HBox optionHBox = new HBox(10);         
        optionHBox.setAlignment(Pos.CENTER); 
        
        // Show prompt information
        TextArea info = new TextArea();        
        info.setEditable(false);         
        info.setMinSize(INFO_WIDTH, INFO_HEIGHT);
        info.setMaxSize(INFO_WIDTH, INFO_HEIGHT);
        info.setWrapText(true);
        info.setText(CoinSorter.promptMsg());

        // for totalCoinValue input
        HBox totalCoinValueHBox = createHBoxWithNodes("Total Coin Value");

        // for coinDenomination input
        HBox coinDenominationHBox = createHBoxWithNodes("Coin Denomination");
        
        // for currency input
        HBox currencyHBox = createHBoxWithNodes("1 - Set Currency", "String");

        // for min Coin input
        HBox minCoinInHBox = createHBoxWithNodes("2 - Set minimum coin input value");

        // for max Coin input
        HBox maxCoinInHBox = createHBoxWithNodes("3 - Set maximum coin input value");
        
        
        // create and configure a button to trigger calculation
        Button runButton = new Button();         
        runButton.setText("Calculate");        

        // create and configure a button to perform a back functionality
        Button cancelButton = new Button();         
        cancelButton.setText("Cancel");        

        // create and configure a horizontal container to hold the Run , Set & Cancel buttons    
        HBox runCancelHBox = new HBox(10);         
        runCancelHBox.setAlignment(Pos.CENTER); 

        // Show result
        TextArea result = new TextArea();        
        result.setEditable(false);         
        result.setMinSize(RESULT_WIDTH, RESULT_HEIGHT);
        result.setMaxSize(RESULT_WIDTH, RESULT_HEIGHT);
        result.setWrapText(true);

        //add the option buttons to the horizontal container         
        optionHBox.getChildren().addAll(button1, button2, button3, button4, button5, button6);
        
        // create and configure a vertical container to hold the button box and the face group         
        VBox root = new VBox(10); 
        root.setBackground(Background.EMPTY);         
        root.setAlignment(Pos.CENTER); 
        
        //add the OK, Set & Cancel buttons to the horizontal container         
        runCancelHBox.getChildren().addAll(runButton, cancelButton);

        //add the button box and the face group to the vertical container         
        root.getChildren().addAll(info, optionHBox, totalCoinValueHBox, coinDenominationHBox, currencyHBox, minCoinInHBox, maxCoinInHBox, runCancelHBox, result);
        //root.getChildren().addAll(children);
        
        // Set state to main by default
        csg.updateState(root, 0);
        
        // create and configure a new scene         
        Scene scene = new Scene(root, FORM_WIDTH, FORM_HEIGHT, Color.GREY);
        

        button1.setOnAction(e -> { 
                csg.updateState(root, 1); }
        );

        button2.setOnAction(e -> { 
                csg.updateState(root, 2); }
        );

        button3.setOnAction(e -> { 
                csg.updateState(root, 3); }
        );

        button4.setOnAction(e -> {
                csg.updateState(root, 4); }
        );

        button5.setOnAction(e -> {
            csg.updateState(root, 5); }
        );

        button6.setOnAction(e -> {
            stage.close();
        }
        );

       // Quit to main menu
       cancelButton.setOnAction(e -> { csg.updateState(root, 0);});


        // Not needed here as it will be redefined in each updateState call
        //runButton.setOnAction( e -> {});
         
        // add scene to the stage         
        stage.setScene(scene);         
        stage.setTitle("Coin Sorter GUI");        
        stage.show();     
    }

    public static void main(String[] args) {
        launch(args);
    }
    

    /*
    * To create a HBOx that is containing a label and textFiled which are used for user inputs
    * args:
    *   label => the label name to be shown in the HBox created
    *   type  => what type the textField is to accept. Can be "int" or "String"
    */
    public HBox createHBoxWithNodes (String label, String type) {
        Label tempLabel= new Label(label);         
        tempLabel.setTextFill(Color.BLACK);         
        tempLabel.setFont(Font.font("Arial", 20));
        tempLabel.setMinWidth(FORM_WIDTH * 0.75);
        tempLabel.setMaxWidth(FORM_WIDTH * 0.75);

        TextField tempField = new TextField();         
        tempField.setMaxWidth(FORM_WIDTH * 0.2);         

        // force the field to be numeric only
        tempField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (type.equals("int") && !newValue.matches("\\d*")) {
                    tempField.setText(newValue.replaceAll("[^\\d]", ""));
                } 
            }
        });

        HBox tempHBox = new HBox(10);
        tempHBox.setAlignment(Pos.CENTER);        
        tempHBox.getChildren().addAll(tempLabel, tempField);  

        return tempHBox;
    }

    // To create a HBOx that is containing a label and textFiled which are used for user inputs. 
    // the textField created only validates int type
    public HBox createHBoxWithNodes (String label) {
        return createHBoxWithNodes(label, "int");
    }
        
}
