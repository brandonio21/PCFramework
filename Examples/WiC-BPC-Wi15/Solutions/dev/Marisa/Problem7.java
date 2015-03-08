
import java.util.*;
import java.lang.Object.*;

public class Problem7 {
 
  //Paramter(s): String text - The text to "read"
  //Return:      String      - The text with words individually reversed
  public static String ssoBAekiLgnidaer(String text) {
	  StringTokenizer st = new StringTokenizer(text);
	  List<String> list = new LinkedList<String>();
	  String translation = "";
	  int space = 0;
	  while (st.hasMoreTokens()) {
		 space++;
		 String reverse = "", word = st.nextToken();
		 for ( int i = word.length() - 1 ; i >= 0 ; i-- )
	         reverse = reverse + word.charAt(i);
	     list.add(reverse);
	  }
	  
	  space--;
	  
      ListIterator<String> listIterator = list.listIterator();
      while(listIterator.hasNext()){
    	  if (space > 0)
    		  translation =translation + listIterator.next() + " ";
    	  else
    		  translation =translation + listIterator.next();
    	  space--;
      }

	  
    return translation;
  }
 
 
  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
 
     // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//"))
        System.out.println(ssoBAekiLgnidaer((nextLine)));
    }
 
  }
}
