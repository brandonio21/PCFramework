
import java.util.*;

public class Problem9 {
 
  //Paramter(s): int[] numbers - Array of numbers 
  //Return:      int           - Product of two largest prime numbers in array
  public static int isItOverNineThousandYet(int[] numbers) {
	  int num, product=1;
	  int[] arr = new int[numbers.length];
	  boolean prime = true, first = true;
	  for (int j = 0; j < numbers.length; j++){
		  prime = true;
		  num = numbers[j];
		  if (num%2==0)
			  prime = false;
		  for(int i=3;i*i<=num;i+=2) {
			  if(num%i==0)
				  prime = false;	  
		  }
		  if (num==2)
			  prime = true;
		  if (prime)
			  arr[j] = num;
	  }
	  Arrays.sort(arr);
	  if( arr.length >2){
  	    for(int i = arr.length - 1; i >= arr.length - 3; i-- ){
		    if(arr[i] == 0 && first)
			    return 0;
		    first = false;
		    if(arr[i] != 0)
			    product = arr[i] * product;
	    }
	  }
	  else{
		  for (int i = 0; i < arr.length; i++){
			  product = product * arr[i];
		  }
	  }
    return product;
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
