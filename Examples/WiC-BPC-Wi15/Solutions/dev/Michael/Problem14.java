import java.util.*;

public class Problem14 {

  //Paramter(s): int bowlcakes - The number of bowlcakes ordered
  //Return:      String        - Dimensions of box in format "widthxheight"
  public static String feedTheHangry(int bowlcakes) {
    if(bowlcakes == 0){
      return "0x0";
    }
    int sqrt = (int)(Math.sqrt(bowlcakes));
    int num = 0;
    for(int i = sqrt; i > 0; i--){
      if(bowlcakes % i == 0){
        num = i;
        break;
      }
    }
    return "" + num + "x" + bowlcakes/num;
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


