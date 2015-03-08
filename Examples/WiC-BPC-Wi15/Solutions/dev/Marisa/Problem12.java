import java.util.*;

public class Problem12 {
 
  //Paramter(s): int numPings - The number of pings to time
  //Return:      int          - The seconds timed from the beginning of the
  //                            first ping to the end of the last ping.
  public static int timePongsPings(int numPings) {
     if(numPings > 2){
      int[][] arr = new int[numPings][2];
        arr[0][0] = 0;
        arr[0][1] = 2;
      for (int i = 1; i < numPings; i++){
    	  arr[i][0] = arr[i-1][0] + arr[i-1][1]/2;
    	  arr[i][1] = arr[i-1][1] * 2;
      }
	  return arr[numPings - 1][0] + arr[numPings - 1][1];
     }
     else if(numPings == 0){
    	 return 0;
     }
     else if(numPings == 1){
    	 return 1;
     }
     else
    	 return 5;
     
  }
 
 
  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//"))
        System.out.println(timePongsPings(Integer.parseInt(nextLine)));
    }
 
  }
}
