import java.util.*;

public class Problem14 {

  //Paramter(s): int bowlcakes - The number of bowlcakes ordered
  //Return:      String        - Dimensions of box in format "widthxheight"
  public static String feedTheHangry(int bowlcakes) {
    
    if (bowlcakes == 0)
      return "0x0";

    return getGreatestFactor(bowlcakes) + "x" + 
      bowlcakes/getGreatestFactor(bowlcakes);
  }

  public static int getGreatestFactor(int num)
  {
    int greatest = 1;
    for (int i = 2; i <= Math.sqrt(num); ++i)
    {
      if (num % i == 0 && i > greatest)
        greatest = i;
    }
    return greatest;
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
