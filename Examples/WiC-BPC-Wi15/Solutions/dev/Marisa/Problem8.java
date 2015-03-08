import java.util.*;

public class Problem8 {
 
  //Paramter(s): int[] rawrray - The array of ints to check
  //Return:      boolean       - Indicating whether each number appears as many
  //                             times as its value.
  public static boolean ohBabies(int[] rawrray) {
	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	int num;
	for(int i = 0; i < rawrray.length; i++){
	   	num = rawrray[i];
    	if (hash.containsKey(num))
    		hash.put(num, (hash.get(num) + 1));
    	else
    		hash.put(num, 1);
	}

    for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
    	//System.out.println(entry.getValue());
    	//System.out.println(entry.getKey());
        if(entry.getValue() != entry.getKey())
        	return false;
    }    
    return true;
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
