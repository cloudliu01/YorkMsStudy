import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * @author David J. Barnes and Michael Kolling.
 * @version 2001.06.08
 */
public class Shopping
{
    private ArrayList shoppingList;
    private String alternatives[] = {"List", "Add", "Show", "Exit"};

    public Shopping()
    {
        shoppingList = new ArrayList();
    }

    public void addItem(String celeb) {
    	shoppingList.add(celeb);
    }

    /**
     * @return The number of items currently in the shoppingList.
     */
    public int numberOfItems()
    {
        return shoppingList.size();
    }


    /**
     * Show a Item.
     * @param itemNumber The number of the item to be shown.
     */
    public void showItem(int itemNumber)
    {
        if(itemNumber < 0) {
            // This is not a valid item number, so do nothing.
        }
        else if(itemNumber < shoppingList.size()) {
            // This is a valid note number, so we can print it.
            System.out.println(shoppingList.get(itemNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    
     public void listItems()
    {
        int index = 0;
        while(index < numberOfItems()) {
            System.out.println(shoppingList.get(index));
            index++;
        }
    }
     
     //public static void main (String args[]) {
    //	 Shopping s = new Shopping();
    //	 s.addItem("AAA");
    //	 s.addItem("BBB");
    //	 s.addItem("CCC");
    //	 s.listItems();
    //	 s.showItem(1);
     //}
     
     public int getChoice()
     {
         int choice = JOptionPane.showOptionDialog(null, "Select from ..","ShoppingList Menu",
                      JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, alternatives, alternatives[0]);
         return choice;
     }

     public void runMenu()
     {
        
        int option = getChoice();
        while (option != 3)
        {
          //Action depending on choice
          if (option == 0)//List notes
          {
           if (numberOfItems() >0 )
           { 
            listItems();
           }
           else System.out.println("No notes in list");
          }
          else if (option == 1) //Add note
          {
           String newItem= JOptionPane.showInputDialog(null,"Enter a new item","New Item", JOptionPane.PLAIN_MESSAGE);
           addItem(newItem) ; 
         
          }
          else if (option == 2)
          {
            if (numberOfItems() >0 )
            {
              String strNum= JOptionPane.showInputDialog(null,"Enter a item Number","Show Item", JOptionPane.PLAIN_MESSAGE);
              int num = Integer.parseInt(strNum); 
              if (num <= numberOfItems())
              {
                showItem(num) ;
              }
              else System.out.println("Invalid number");
            }
            else System.out.println("No items in list");
          }
           else JOptionPane.showMessageDialog(null, "No Comprendo " +option);
         //Prompt again
         option = getChoice();
        }//End while
     }
}
