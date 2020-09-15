 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DrawingArea extends JPanel {
 
     // You only need to edit the method below.
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      // the size of the circle
      int size = 350;
      
      System.out.println("How many circles you want?");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      // You might want to introduce a loop somewhere here.
      for( int i=1; i <= n; i++) {
    	  
    	  // the color (this is blue, believe it or not, play around with different values)
    	  //int icol = 255;
    	  int icol = (int) (Math.random()*65536);
    	  Color c = new Color(icol);
    	  g.setColor(c);
    	  
    	  //size = size - 20;
    	  //g.drawOval(200-size/2,200-size/2,size,size);
    	  size = (int) (Math.random()*400);
    	  int x = (int) (Math.random()*(200 - size/2));
    	  int y = (int) (Math.random()*(200 - size/2));
    	  g.drawOval(x,y,size,size);

      }// the end of the method....


    }
}