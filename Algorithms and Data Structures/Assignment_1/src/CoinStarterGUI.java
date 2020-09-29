/**
 * 
   Class:   CoinSorterGUI
   Author:  Lizhuang Liu
   Date:    Sep 28 2020
 */

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

public class CoinStarterGUI extends CoinSorter {

	/**
	 * @param currency
	 * @param minCoinIn
	 * @param maxCoinIn
	 * @param cl
	 */
	public CoinStarterGUI(String currency, int minCoinIn, int maxCoinIn, Integer[] cl) {
		super(currency, minCoinIn, maxCoinIn, cl);
		// TODO Auto-generated constructor stub
	}

}
