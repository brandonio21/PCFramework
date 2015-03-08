import java.util.*;

public class Problem15 {
 
  //Paramter(s): int[] bouncer - The bounciness of each trampoline in Bouncer
  //Return:      int           - Smallest number of jumps it takes to get to 
  //                             the top OR the number of jumps it takes to get
  //                             to the highest trampoline (if the top is
  //                             unreachable)
	static int maxLength, maxMin;
  public static int defeatTheBouncer(int[] bouncer) {
	  if (bouncer.length > 0){
		  maxLength = bouncer[0];
	      maxMin = 1;
	  }
	  int max = bouncer[0], min = bouncer.length,count = 0;
	  for (int i = 0; i<bouncer[0]; i++ ){
		 count = 0;
		 if (rec(bouncer, i, min, count) < min){
			 min = rec(bouncer, i, min, count);

		}
	  }
	  if(min < bouncer.length){
		  return min;
	  }
	  else{
		  return maxMin;
	  }
  }
  
  public static int rec(int[]bouncer, int spot, int min, int count ){
	  if ((spot > maxLength && spot < bouncer.length) || (spot == maxLength && count < maxMin)){
		  if (bouncer[spot] !=0)
		  maxMin = count;
	  }
	  if ( spot < bouncer.length){
		  for (int i = 1; i<=bouncer[spot]; i++ ){
				 if (rec(bouncer, i+spot, min, count+1) < min){
					 min = rec(bouncer, i+spot, min, count+1);
				}
		  }
	  }
	  else{
		  min = count;
	  }
	  return min;

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
