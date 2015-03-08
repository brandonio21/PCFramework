import java.util.*;

public class Problem15 {

  //Paramter(s): int[] bouncer - The bounciness of each trampoline in Bouncer
  //Return:      int           - Smallest number of jumps it takes to get to 
  //                             the top OR the highest trampoline it can
  //                             reach (if the top is unreachable)
  public static int defeatTheBouncer(int[] bouncer) {
    int currentIndex = 0;
    int maxDist = 0;
    int numJumps = 0;
    while(currentIndex + bouncer[currentIndex] < bouncer.length){
      maxDist = 0;
      int indexOfMaxDist = 0;
      int furthest = currentIndex;
      for(int i = 1; i <= bouncer[currentIndex]; i++){
        if(i+bouncer[currentIndex + i] > maxDist && bouncer[currentIndex + i] != 0){
          maxDist = i+bouncer[currentIndex + i];
          indexOfMaxDist = currentIndex + i;
          furthest = currentIndex + i;
        }
      }

      if(maxDist == 0){
        return furthest;
      }
      currentIndex = indexOfMaxDist;
      numJumps++;


    }
    return numJumps + 1;
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


