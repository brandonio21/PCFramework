import java.util.*;

public class Problem14 {

  //Paramter(s): int bowlcakes - The number of bowlcakes ordered
  //Return:      String        - Dimensions of box in format "widthxheight"
  public static String feedTheHangry(int bowlcakes) {
    
    // YOUR CODE HERE
    return "";
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
