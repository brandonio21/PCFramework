import java.util.*;

public class Problem2 {

  //Paramter(s): int number - The decimal number to be converted to an array
  //Return:      int[]      - The array representation of the number
  public static int[] breakItDownNow(int number) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    if (number == 0)
      numbers.add(0);
    else
    {
      while (number > 0)
      {
        numbers.add(number % 10);
        number /= 10;
      }
    }

    
    int[] returnArr = new int[numbers.size()];
    for (int i = numbers.size(); i > 0; --i)
      returnArr[numbers.size() - i] = numbers.get(i - 1);

    return returnArr;
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
