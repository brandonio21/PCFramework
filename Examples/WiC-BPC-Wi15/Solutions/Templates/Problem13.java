import java.util.*;

public class Problem13 {

  //Paramter(s): int seconds  - The number of seconds that the sound wave has
  //                            travelled.
  //Return:      int          - The max height the sound wave achieves
  public static int canYouHearMeNow(int seconds) {
    
    // YOUR CODE HERE
    return 0;
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//"))
        System.out.println(canYouHearMeNow(Integer.parseInt(nextLine)));
    }

  }
}
