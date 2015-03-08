import java.util.*;

public class Problem8 {

  //Paramter(s): int[] rawrray - The array of ints to check
  //Return:      boolean       - Indicating whether each number appears as many
  //                             times as its value.
  public static boolean ohBabies(int[] rawrray) {
    HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();

    for (int i = 0; i < rawrray.length; ++i)
    {
      if (counts.containsKey(rawrray[i]))
        counts.put(rawrray[i], counts.get(rawrray[i]) + 1);
      else
        counts.put(rawrray[i], 1);
    }

    Iterator<Integer> it = counts.keySet().iterator();
    while (it.hasNext())
    {
      int item = it.next();
      if (counts.get(item) != item)
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
