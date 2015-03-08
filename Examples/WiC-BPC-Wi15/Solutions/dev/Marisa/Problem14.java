
import java.util.*;

public class Problem14 {
 
  //Paramter(s): int bowlcakes - The number of bowlcakes ordered
  //Return:      String        - Dimensions of box in format "widthxheight"
  public static String feedTheHangry(int bowlcakes) {
	  if (bowlcakes == 0){
		  return "0x0";
	  }
      String str = "";
	  for(int i = (int)Math.sqrt(bowlcakes); i > 0; i--){
		  if((bowlcakes/i) * i == bowlcakes){
			   str = Integer.toString(i) + 'x' + Integer.toString(bowlcakes/i);
			   return str;
		  }
		  
	  }
	  str = Integer.toString(1) + 'x' + Integer.toString(bowlcakes);
	  return str;
  }
 
 
  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//"))
        System.out.println(feedTheHangry(Integer.parseInt(nextLine)));
    }
 
  }
}
