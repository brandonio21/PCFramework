import java.util.*;

public class Problem8 {

  //Paramter(s): int[] rawrray - The array of ints to check
  //Return:      boolean       - Indicating whether each number appears as many
  //                             times as its value.
  public static boolean ohBabies(int[] rawrray) {
    Arrays.sort(rawrray);
    if(rawrray.length == 0){
    	return true;
    }
    int currInt = rawrray[0];
    int numInts = 0;
    for(int i = 0; i < rawrray.length; i++){
    	if(currInt == rawrray[i]){
    		numInts++;
    	} else {
    		if(currInt != numInts){
    			return false;
    		} else {
    			numInts = 1;
    			currInt = rawrray[i];
    		}
    	}
    }
    // YOUR CODE HERE
    return currInt == numInts;
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

        System.out.println(Boolean.toString(ohBabies(numberInts)));
      }
    }
  }

}
