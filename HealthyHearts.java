import java.util.Scanner;

public class HealthyHearts {

    public static void main(String[] args)  {
        // Make the scanner variable
        Scanner scanner = new Scanner(System.in);

        // Get the age of the user
        System.out.println("What is your age? ");
        String ageStr = scanner.nextLine();
        try {
            // Convert the age into an int, get the max heart rate and the targets
            int age = Integer.parseInt(ageStr);
            int maxHeartRate = 220 - age;
            int targetMin = maxHeartRate / 2;
            int targetMax = (int) (maxHeartRate * 0.8);

            // Print out the results
            System.out.printf("Your maximum heart rate should be %s beats per minute%n", maxHeartRate);
            System.out.printf("Your target HR Zone is %s - %s beats per minute%n", targetMin, targetMax);
        } catch (NumberFormatException e)   {
            System.out.println("ERROR, Invalid age");
        }
    }
}
