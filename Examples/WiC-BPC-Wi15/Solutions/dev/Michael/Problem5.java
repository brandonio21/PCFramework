import java.util.*;

public class Problem5 {

  //Paramter(s): int[] coconutVolumes - The volumes of available coconuts
  //             int   max            - The maximum number of coconuts that
  //                                    Gary can hold.
  //Return:      int                  - The volume of coconut water he can drink
  public static int poweredByCoconuts(int[] coconutVolumes, int max) {
    int retVal = 0;
    Arrays.sort(coconutVolumes);
    for(int i = 0; i < max && i < coconutVolumes.length; i++ ){
    	retVal += coconutVolumes[coconutVolumes.length - i -1];
    }
    // YOUR CODE HERE
    return retVal;
  }


  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	 
	    // Get information from file
	    while (input.hasNext()) {
	      String nextLine = input.nextLine();
	      if (!nextLine.startsWith("//")) {
	        String followingLine = input.nextLine();
	        String[] volumes;
	        if (nextLine.contains(" "))
	          volumes = nextLine.split(" ");
	        else
	          volumes = new String[] {nextLine};
	 
	        //convert volumes to int
	        int[] volumeInts = new int[volumes.length];
	        for (int i = 0; i < volumes.length; ++i)
	        {
	          if (!volumes[i].equals(""))
	            volumeInts[i] = Integer.parseInt(volumes[i]);
	        }
	 
	        System.out.println(poweredByCoconuts(volumeInts,
	              Integer.parseInt(followingLine)));
	      }
	    }
	  }
}
