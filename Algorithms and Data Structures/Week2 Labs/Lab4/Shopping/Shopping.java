import java.util.ArrayList;

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
     
     public static void main (String args[]) {
    	 Shopping s = new Shopping();
    	 s.addItem("AAA");
    	 s.addItem("BBB");
    	 s.addItem("CCC");
    	 s.listItems();
    	 s.showItem(1);
     }
}
