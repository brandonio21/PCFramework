import java.util.*;

public class Problem15 {

  //Paramter(s): int[] bouncer - The bounciness of each trampoline in Bouncer
  //Return:      int           - Smallest number of jumps it takes to get to 
  //                             the top OR the index of the highest trampoline
  //                             (if the top is unreachable)
  public static int defeatTheBouncer(int[] bouncer) {
    
    // YOUR CODE HERE
    return 0;
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//")) {
        String[] numbers;
        if (nextLine.contains(" "))
          numbers = nextLine.split(" ");
        else
          numbers = new String[] {nextLine};

        //convert volumes to int
        int[] numberInts = new int[numbers.length];
        for (int i = 0; i < numbers.length; ++i)
          numberInts[i] = Integer.parseInt(numbers[i]);

        System.out.println(defeatTheBouncer(numberInts));
      }
    }
  }

}
