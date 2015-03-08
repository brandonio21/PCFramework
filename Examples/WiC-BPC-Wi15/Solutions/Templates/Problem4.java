import java.util.*;

public class Problem4 {

  //Paramter(s): int position - The position of the fibonnaci term to retrieve
  //                            where 0th position is 0 and 1st is 1.
  //Return:      int          - The value of the fibonnaci term at given pos 
  public static int noMoreFibbing(int position) {
    
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
        System.out.println((noMoreFibbing(Integer.parseInt(nextLine))));
    }

  }
}
