/**
 * 
   Class:   CoinSorterGUI
   Author:  Lizhuang Liu
   Date:    Sep 28 2020
 */

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import java.util.*;

public class CoinSorterGUI extends CoinSorter {
    
    // To store program state ( which options has been just selected )
    //String[] STATE = {"Coin calculator", "Multiple coin calculator", "Print coin list", "Set details", "Display program configurations", "Quit the program"};
    Integer currentState;
    
    public CoinSorterGUI(String currency, int minCoinIn, int maxCoinIn, Integer[] cl) {
        super(currency, minCoinIn, maxCoinIn, cl);
    }
    
    /*
     * To constantly prompt user to type in an integer (repeat if not)
     * return the actual input when it passes the validation; otherwise return -1
     */
    public Integer validateIntInput(TextField tf, TextArea result) {
        Integer inputValue;
        try { 
            inputValue = Integer.parseInt(tf.getText());
            return inputValue;
        } catch (NumberFormatException ex) {
            String msg =  "WARNING: Wrong input specified. it's must be an integer. Try again!\n" + ex.toString();
            outFunc(result, result.getText() + msg);
            return null;
        }
    }

    // Validate instance private variable totalCoinValue
    public boolean validateTotalValue(TextField tf, TextArea result) {
        Integer inputValue;
        boolean flag = false;
        inputValue = validateIntInput(tf, result);
        if ( inputValue == null ) {
            // non-integer value inputed
            flag = false;
        } else if ( inputValue < getMinCoinIn() || inputValue > getMaxCoinIn()) {
            // input value not in the specified range
            outFunc(result, result.getText() + "WARNING: totalCoinValue must be in a range: [" 
                    + getMinCoinIn() + ", " + getMaxCoinIn() + "]"); 
            flag = false;
        } else {
            setTotalCoinValue( inputValue);
            flag = true;
        }
        // set global flag so it can be seen by latter validation functions
        return flag;
    }

    // Validate instance private variable excludeCoin
    public boolean validateExcludedCoin(TextField tf, TextArea result) {
        Integer validValue = validateCoin(tf, result);
        boolean flag;
        if (validValue != null ) {
            flag = true;
            setExcludedCoin(validValue);
        } else {
            flag = false;
        }
        return flag;
    }

    // Validate coin (generic)
    public Integer validateCoin(TextField tf, TextArea result) {
        Integer inputValue;
        inputValue = validateIntInput(tf, result);
        if ( Arrays.asList(getCoinList()).contains(inputValue)) {
            return inputValue;
        } else {
            /* When user inputed a value not in the denomination list
            * Warn user and repeat the input prompt
            * */
            outFunc(result,  result.getText() + "Wrong coin specified. It's must be one of " + 
                    Arrays.toString(getCoinList()));
            return null;
        }
    }

    

    // callback when Run button is called. Used to update the content of the form
    // This function is specifically used when user clicked 'Run' but failed, in which case the global
    // currentState needs to be maintained
    public void updateState(VBox root) {
        Integer state = getCurrentState();
        updateState(root, state);
    }


    // callback when Run button is called. Used to update the content of the form
    public void updateState(VBox root, Integer stateIn) {
        // Get all GUI nodes
        TextArea info = getInfoTextArea(root);
        HBox optionHBox = getButtonHBox(root);
        HBox totalCoinValueHBox = getTotalCoinValueHBox(root);
        HBox coinDenominationHBox = getCoinDenominationHBox(root); 
        HBox currencyHBox = getCurrencyHBox(root);
        HBox minCoinInHBox = getMinCoinInHBox(root);
        HBox maxCoinInHBox = getMaxCoinInHBox(root);
        HBox runSetCancelHBox = getRunCancelHBox(root);
        TextArea result = getResultTextArea(root);

        TextField totalCoinValueTextField = (TextField) totalCoinValueHBox.getChildren().get(1);
        TextField coinDenominationTextField = (TextField) coinDenominationHBox.getChildren().get(1);
        TextField currencyTextField = (TextField) currencyHBox.getChildren().get(1);

        Button runButton = getRunButton(root);
        Button cancelButton = getCancelButton(root);
        
        if (stateIn == 0) {
            String s = promptMsg();
            outFunc(info, s);
            optionHBox.setVisible(true);
            totalCoinValueHBox.setVisible(false);
            coinDenominationHBox.setVisible(false);
            currencyHBox.setVisible(false);
            minCoinInHBox.setVisible(false);
            maxCoinInHBox.setVisible(false);

            runSetCancelHBox.setVisible(false);
            runButton.setVisible(false);
            runButton.setText("Calculate");
            cancelButton.setVisible(false);
            cancelButton.setText("Cancel");

            result.setVisible(true);
        } else if (stateIn == 1 || stateIn == 2) {
            // To initialize result TextArea for every updateState call that needs a new output
            result.setText("");

            String msg = "Please input:\n";
            msg = msg + "\t* the totalCoinValue\n";
            msg = msg + "\t* coin denomination\n";
            msg = msg + "in the corresponding fileds below, then click RUN button";
            msg = msg + "NOTE: only integers are accepted";

            optionHBox.setVisible(false);
            totalCoinValueHBox.setVisible(true);
            coinDenominationHBox.setVisible(true);
            currencyHBox.setVisible(false);
            minCoinInHBox.setVisible(false);
            maxCoinInHBox.setVisible(false);

            runSetCancelHBox.setVisible(true);
            runButton.setVisible(true);
            runButton.setText("Calculate");
            cancelButton.setVisible(true);
            cancelButton.setText("Cancel");

            result.setVisible(true);
            
            outFunc(info, msg);
            runButton.setOnAction(e -> 
                {
                    boolean pass1 = validateTotalValue(totalCoinValueTextField, result);
                    boolean pass2 = validateExcludedCoin(coinDenominationTextField, result);
                    if (pass1 && pass2) {
                        Integer coinDeno = validateCoin(coinDenominationTextField, result);
                        String msglambda;
                        if (stateIn == 1) {
                            msglambda = coinCalculator(coinDeno);
                        } else {
                            msglambda = multiCoinCalculator();
                        }
                        outFunc(result, msglambda);
                        // return to the main menu
                        updateState(root, 0);
                    } 
                }
            );

        } else if (stateIn == 3) {
            String msg = printCoinList();
            outFunc(result, msg);
        } else if (stateIn == 4) {
            String msg = promptMsgSub4();
            outFunc(info, msg);
            optionHBox.setVisible(false);
            totalCoinValueHBox.setVisible(false);
            coinDenominationHBox.setVisible(false);
            currencyHBox.setVisible(true);
            minCoinInHBox.setVisible(true);
            maxCoinInHBox.setVisible(true);

            runSetCancelHBox.setVisible(true);
            runButton.setVisible(true);
            runButton.setText("OK & Set");
            cancelButton.setVisible(true);
            cancelButton.setText("4 - Return main menu");

            result.setVisible(true);

            runButton.setOnAction(e -> 
                {
                    // below will always successful as the textFiled has been customized to only accept integer
                    Integer minCoinIn = validateIntInput(getMinCoinInTextField(root), result);
                    Integer maxCoinIn = validateIntInput(getMaxCoinInTextField(root), result);
                    boolean pass = false;
                    if (minCoinIn != null && maxCoinIn != null) {
                        boolean rangeOK = validateMinMaxRange(minCoinIn, maxCoinIn);
                        if (rangeOK) {
                            String currency = getCurrencyTextField(root).getText();
                            setCurrency(currency);
                            setMinCoinIn(minCoinIn);
                            setMaxCoinIn(maxCoinIn);
                            pass = true;
                        } else {
                            outFunc(result, result.getText() + "WARNING: setting failed - minCoinIn ( " + minCoinIn + 
                                    ") is larger than maxCoinIn (" + maxCoinIn + "). Please try again!");
                        }
                    }
                    if (pass) {
                        updateState(root, 0);
                    } else {
                        outFunc(result, result.getText() + "Set values failed for resons listed above.");
                    }

                }
            );

        } else if (stateIn == 5) {
            String msg = displayProgramconfigs();
            outFunc(result, msg);
        } else {
            outFunc(result, "Unknown option");
        }
        
        
        
    }

    // validaeCoin() is not in the Assignment outline but seems better to have here
    //Integer vc = starter.validateCoin();
    //totalValue = starter.getTotalCoinValue();
    //msg = starter.coinCalculator(totalValue, vc);
    //starter.outFunc(msg);
        
    public void outFunc(TextArea resultTextArea, String s) {
        resultTextArea.setText(s+"\n");
    }
    
    public void setCurrentState(Integer i) {
        currentState = i;
    }

    public Integer getCurrentState() {
        return currentState;
    }
    
    // get INFO Node from root
    public TextArea getInfoTextArea (VBox root) {
        return (TextArea) root.getChildren().get(0);
    }

    // get totalCoinValueHBox Node from root
    public HBox getTotalCoinValueHBox (VBox root) {
        return (HBox) root.getChildren().get(2);
    }

    // get optionHBox Node from root
    public HBox getButtonHBox (VBox root) {
        return (HBox) root.getChildren().get(1);
    }

    // get coinDenominationHBox Node from root
    public HBox getCoinDenominationHBox (VBox root) {
        return (HBox) root.getChildren().get(3);
    }

    // get currencyHBox Node from root
    public HBox getCurrencyHBox (VBox root) {
        return (HBox) root.getChildren().get(4);
    }

    // get minCoinInHBox Node from root
    public HBox getMinCoinInHBox (VBox root) {
        return (HBox) root.getChildren().get(5);
    }

    // get maxCoinInHBox Node from root
    public HBox getMaxCoinInHBox (VBox root) {
        return (HBox) root.getChildren().get(6);
    }

    // get currencyTextField Node from root
    public TextField getCurrencyTextField (VBox root) {
        return (TextField) getCurrencyHBox(root).getChildren().get(1);
    }

    // get maxCoinInTextField Node from root
    public TextField getMinCoinInTextField (VBox root) {
        return (TextField) getMinCoinInHBox(root).getChildren().get(1);
    }

    // get maxCoinInTextField Node from root
    public TextField getMaxCoinInTextField (VBox root) {
        return (TextField) getMaxCoinInHBox(root).getChildren().get(1);
    }

    // get runSetCancelHBox Node from root
    public HBox getRunCancelHBox (VBox root) {
        return (HBox) root.getChildren().get(7);
    }
        
    // get runButton Node from root
    public Button getRunButton (VBox root) {
        HBox rcHBox = getRunCancelHBox(root);
        return (Button) rcHBox.getChildren().get(0);
    }

    // get cancelButton Node from root
    public Button getCancelButton (VBox root) {
        HBox rcHBox = getRunCancelHBox(root);
        return (Button) rcHBox.getChildren().get(1);
    }

    // get result Node from root
    public TextArea getResultTextArea (VBox root) {
        TextArea result = (TextArea) root.getChildren().get(8);
        return result;
    }


}