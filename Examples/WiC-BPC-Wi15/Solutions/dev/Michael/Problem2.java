import java.util.*;

public class Problem2 {

  //Paramter(s): int number - The decimal number to be converted to an array
  //Return:      int[]      - The array representation of the number
  public static int[] breakItDownNow(int number) {
    int[] retVal = {0};
    if(number <= 0){
    	return retVal;
    }
    int copy = number;
    int numDigits = 0;
    while(copy > 0){
    	numDigits++;
    	copy/=10;
    }
    retVal = new int[numDigits];
    for(int i = numDigits - 1; i >= 0; i--){
    	retVal[i] = number % 10;
    	number/=10;
    }
    return retVal;
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
