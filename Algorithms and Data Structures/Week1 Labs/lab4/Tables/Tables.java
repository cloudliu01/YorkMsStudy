public class Tables  {
    
    public static void generateTable()  
    {
      //Put the code for your times-table here
    	int n = 12;
    	for (int i=1; i <= n; i++) {
    		System.out.println("");
    		for (int j=1; j <= n; j++) {
        		System.out.printf("%d ", j*i);
    		}
    	}
    
    }
    
	public static void main(String[] args) {
		generateTable();
	}
}