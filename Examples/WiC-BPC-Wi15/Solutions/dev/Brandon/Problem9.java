import java.util.*;

public class Problem9 {

  //Paramter(s): int[] numbers - Array of numbers 
  //Return:      int           - Product of three largest prime numbers in array
  public static int isItOverNineThousandYet(int[] numbers) {
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(new 
        Comparator<Integer>() {
          public int compare(Integer i, Integer j) {
            return i >= j ? -1 : 1;
          }
        });
    for (int i = 0; i < numbers.length; ++i)
      maxheap.add(numbers[i]);

    int numCount = 0;
    int product = 1;
    while (maxheap.size() > 0 && numCount < 3)
    {
      int number = maxheap.poll();
      if (isPrime(number))
      {
        product *= number;
        numCount++;
      }
    }

    return (numCount == 0) ? 0 : product;
  }

  public static boolean isPrime(int number)
  {
    if (number == 0) return false;
    if (number == 1) return false;
    if (number == 2) return true;

    for (int i = 2; i <= Math.sqrt(number); ++i)
    {
      if (number % i == 0)
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

        System.out.println(isItOverNineThousandYet(numberInts));
      }
    }
  }

}
