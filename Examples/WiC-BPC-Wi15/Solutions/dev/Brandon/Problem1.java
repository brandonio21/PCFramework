import java.util.*;

public class Problem1 {

  //Paramter(s): int number - The decimal number to be converted to binary
  //Return:      int        - The binary version of the provided decimal number
  public static int twoClawCounting(int number) {
    
    int binaryNum = 0;
    int grower = 1;
    while (number > 0)
    {
      binaryNum += ((number % 2) * grower);
      number /= 2;
      grower *= 10;
    }
    return binaryNum;
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
