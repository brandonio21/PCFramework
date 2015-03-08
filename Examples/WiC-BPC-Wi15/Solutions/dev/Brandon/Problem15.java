import java.util.*;

public class Problem15 {

  //Paramter(s): int[] bouncer - The bounciness of each trampoline in Bouncer
  //Return:      int           - Smallest number of jumps it takes to get to 
  //                             the top OR the number of jumps it takes to get
  //                             to the highest trampoline (if the top is
  //                             unreachable)
  public static int defeatTheBouncer(int[] bouncer) {
    int minJumps = minJumpsToReachPoint(bouncer, 0, bouncer.length);
    if (minJumps == -1)
    {
      for (int i = bouncer.length - 1; i >= 0; --i)
      {
        if (minJumpsToReachPoint(bouncer, 0, i) != -1)
          return i;
      }
      return 0;
    }
    else
      return minJumps;
  }

  public static int minJumpsToReachPoint(int[] bouncer, int n, int point)
  {
    for (int i = bouncer[n]; i > 0; --i)
    {
      if (n + i == point && (point == bouncer.length || bouncer[point] != 0))
        return 1;
    }

    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    for (int i = bouncer[n]; i > 0; --i)
    {
      int minJumps = minJumpsToReachPoint(bouncer, n+i, point);
      if (minJumps < min && minJumps > -1) {
        min = minJumps;
        minIndex = i;
      }
    }
    if (minIndex == -1)
      return -1;
    else
      return 1+min;
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
