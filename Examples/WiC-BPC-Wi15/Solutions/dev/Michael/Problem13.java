import java.util.*;

public class Problem13 {

  //Paramter(s): int seconds  - The number of seconds that the sound wave has
  //                            travelled.
  //Return:      int          - The max height the sound wave achieves
  public static int canYouHearMeNow(int seconds) {
	if(seconds <= 0){
		return 0;
	}
    int cycleNum = 31 - Integer.numberOfLeadingZeros(seconds + 3) - 1;
    int currCycleMaxHeight = 3 * (int)Math.pow(2, cycleNum - 1);
    int currCycleTime = 2 * (int)Math.pow(2, cycleNum);
    int pastCycleTimes = (int) Math.pow(2, cycleNum + 1) - 4;
    int timeInCurrCycle = seconds - pastCycleTimes;
    double percentOfCurrCyclePassed = (double)timeInCurrCycle/currCycleTime;
    if(percentOfCurrCyclePassed >= .25){
    	return currCycleMaxHeight;
    } else if(percentOfCurrCyclePassed <= .125){
    	return currCycleMaxHeight / 2;
    } else {
    	return currCycleMaxHeight / 2 + (int)(currCycleMaxHeight / 2 * (percentOfCurrCyclePassed*8 - 1));
    }
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
