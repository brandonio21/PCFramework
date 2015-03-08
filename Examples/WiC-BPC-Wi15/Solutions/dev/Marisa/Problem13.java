
import java.util.*;

public class Problem13 {
 
  //Paramter(s): int seconds  - The number of seconds that the sound wave has
  //                            travelled.
  //Return:      int          - The max height the sound wave achieves
  public static int canYouHearMeNow(int seconds) {
	if(seconds == 0)
		return 0;
    int lim = 3;
    int height = 0, max = 0, dir = 1;
	for (int i = 1; i <= seconds; i++){
		if(height == lim)
			dir = -1;
		if(height == -lim){
			dir = 1;
			lim = lim * 2;
		}
		height = height + dir*3;
		if (height > max)
			max = height;
	}
    return max;
  }
 
 
  /////////////////////DO NOT MODIFY ANYTHING BELOW THIS LINE///////////////////
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Get information from file
    while (input.hasNext()) {
      String nextLine = input.nextLine();
      if (!nextLine.startsWith("//"))
        System.out.println(canYouHearMeNow(Integer.parseInt(nextLine)));
    }
 
  }
}
