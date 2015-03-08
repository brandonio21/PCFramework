import java.util.*;

public class Problem12 {

  //Paramter(s): int numPings - The number of pings to time
  //Return:      int          - The seconds timed from the beginning of the
  //                            first ping to the end of the last ping.
  public static int timePongsPings(int numPings) {
    
    return (int)(Math.pow(2, numPings - 1) - 1 + Math.pow(2, numPings));
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//"))
        System.out.println(timePongsPings(Integer.parseInt(nextLine)));
    }

  }
}
