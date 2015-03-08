import java.util.*;

public class Problem9 {

  //Paramter(s): int[] numbers - Array of numbers 
  //Return:      int           - Product of three largest prime numbers in array
  public static int isItOverNineThousandYet(int[] numbers) {
    int total = 1;
    Arrays.sort(numbers);
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for(int i = numbers.length -1; i >= 0; i--){
      if(isPrime(numbers[i])){
    	  primes.add(numbers[i]);
      }
    }
    if(primes.size() == 0){
    	return 0;
    }
    for(int i = 0; i < 3 && i < primes.size(); i++){
    	total *= primes.get(i);
    }
    // YOUR CODE HERE
    return total;
  }
  public static boolean isPrime(int num){
	  if(num == 1 || num == 0){
		  return false;
	  }
	  if(num == 2){
		  return true;
	  }
	  int sqrt = (int)Math.sqrt(num);
	  for(int i = 2; i <= sqrt; i++){
	      if(num % i == 0){
	          return false;
	      }
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
