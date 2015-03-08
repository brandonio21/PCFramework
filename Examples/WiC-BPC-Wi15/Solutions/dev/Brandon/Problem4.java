import java.util.*;

public class Problem4 {

  //Paramter(s): int position - The position of the fibonnaci term to retrieve
  //                            where 0th position is 0 and 1st is 1.
  //Return:      int          - The value of the fibonnaci term at given pos 
  public static int noMoreFibbing(int position) {
    return getFibTerm(position);
  }

  public static int getFibTerm(int termNumber)
  {
    if (termNumber == 0)
      return 0;
    if (termNumber == 1)
      return 1;
    if (termNumber == 2)
      return 1;

    return getFibTerm(termNumber - 1) + getFibTerm(termNumber - 2);
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
