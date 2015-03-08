import java.util.*;

public class Problem1 {

  //Paramter(s): int number - The decimal number to be converted to binary
  //Return:      int        - The binary version of the provided decimal number
  public static int twoClawCounting(int number) {
    
    return Integer.parseInt(Integer.toBinaryString(number));
    // YOUR CODE HERE
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//"))
        System.out.println(twoClawCounting(Integer.parseInt(nextLine)));
    }

  }
}
