import java.util.*;

public class Problem2 {

  //Paramter(s): int number - The decimal number to be converted to an array
  //Return:      int[]      - The array representation of the number
  public static int[] breakItDownNow(int number) {
    
    // YOUR CODE HERE
    return null;
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//")) {
        int[] result = breakItDownNow(Integer.parseInt(nextLine));
        System.out.print(result[0]);
        for (int i = 1; i < result.length; ++i) 
          System.out.format(" %d", result[i]);
        System.out.println();
      }
    }
  }
}
