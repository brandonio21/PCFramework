
import java.util.*;

public class Problem4 {
 
  //Paramter(s): int position - The position of the fibonnaci term to retrieve
  //                            where 0th position is 0 and 1st is 1.
  //Return:      int          - The value of the fibonnaci term at given pos 
  public static int noMoreFibbing(int position) {
    int[] array = new int[position]; 
    
    if(position == 1 || position == 2)
    	return 1;
    array[0] = 1;
    array[1] = 1;

    for(int i = 2; i < position; i++){
    	array[i] = array[i-1] + array[i-2];
    }
    
    return array[position - 1];
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
