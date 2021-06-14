import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

    public static void main(String[] args)  {
        // Declare the scanner and random variables
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Get the user's dog name
        System.out.println("What is your dog's name? ");
        String dogName = scanner.nextLine();

        System.out.printf("Well then, I have this highly reliable report on %s's prestigious background right here.\n", dogName);
        System.out.printf("%s is: \n\n", dogName);

        // Generate fake percentages for the dog
        int maxPer = 100;
        // Between 20 to 75
        int firstPer = random.nextInt(75 - 20 + 1) + 20;
        maxPer-=firstPer;
        System.out.print(firstPer);
        System.out.println("% St. Bernard");

        int secondPer = random.nextInt(maxPer+1);
        maxPer-=secondPer;
        System.out.print(secondPer);
        System.out.println("% Chihuahua");

        if (maxPer > 0) {
            int thirdPer = random.nextInt(maxPer+1);
            maxPer-=thirdPer;
            System.out.print(thirdPer);
            System.out.println("% Dramatic RedNosed Asian Pug");
        }
        if (maxPer > 0) {
            int fourthPer = random.nextInt(maxPer+1);
            maxPer-=fourthPer;
            System.out.print(fourthPer);
            System.out.println("% Common Cur");
        }
        if (maxPer > 0) {
            int fifthPer = maxPer;
            System.out.print(fifthPer);
            System.out.println("% King Doberman");
        }

        System.out.println("\nWow, that's QUITE the dog!");

    }
}
