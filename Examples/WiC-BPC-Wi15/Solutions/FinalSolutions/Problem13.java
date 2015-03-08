import java.util.*;

public class Problem13 {

  //Paramter(s): int seconds  - The number of seconds that the sound wave has
  //                            travelled.
  //Return:      int          - The max height the sound wave achieves
  public static int canYouHearMeNow(int seconds) {

    int distance = 0;
    int highest = 0;
    int duration = 1;
    int time = 1;
    int i = 0;
    while (i < seconds)
    {
      for (int t = 0; t < time; ++t) {
      distance += (duration * 3);
      if (distance > highest)
        highest = distance;
      i += duration;
      if (i >= seconds)
        break;
      }
      if (i >= seconds)
        break;

      for (int t = 0; t < time; ++t) {
      distance -= (duration * 3);
      i += duration;
      if (i >= seconds)
        break;
      }
      if (i >= seconds)
        break;

      for (int t = 0; t < time; ++t) {
      distance -= (duration * 3);
      i += duration;
      if (i >= seconds)
        break;
      }
      if (i >= seconds)
        break;

      for (int t = 0; t < time; ++t) {
      distance += (duration * 3);
      if (distance > highest)
        highest = distance;
      i += duration;
      if (i >= seconds)
        break;
      }
      if (i >= seconds)
        break;

      time *= 2;
    }

    
    return highest;
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
