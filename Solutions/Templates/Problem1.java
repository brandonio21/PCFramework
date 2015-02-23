import java.util.*;

public class Problem1 {

  //Paramter(s): int number - The decimal number to be converted to binary
  //Return:      int        - The binary version of the provided decimal number
  public static int convertToBinary(int number) {
    
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
        System.out.println(convertToBinary(Integer.parseInt(nextLine)));
    }

  }
}
