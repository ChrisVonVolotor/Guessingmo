import java.util.Scanner;

public class Guesser {
    //creates scanner for user input.
    Scanner sc = new Scanner(System.in);
    public boolean guessSolution(){
        int hRange = 0;
        int lRange = 0;
        int count = 0;
        boolean unsolved = true;
        String input;

        //setting upper and lower ranges
        System.out.println("Please enter your lower range: ");
        lRange = rangeChoice();
        //loops while lower is higher or equal to higher range
        while (lRange >= hRange) {

            System.out.println("Please enter your upper range: IT MUST BE GREATER THAN THE LOWER RANGE ");
            hRange = rangeChoice();

        }
        int guess;
        //loop until game ends
        while(unsolved) {

            if (count == 5) {
                System.out.println("hmmm....");
            } else if (count ==8){
                System.out.println("OwO whats this...");
            } else if (count == 3){
                System.out.println("Your weak human mind is not match for me");
            }else if (count == 15){
                System.out.println("You've got to be cheating");
            }else if (count == 1){
                System.out.println("Game on....");
            }else if (count == 20){
                System.out.println("This is tough...");
            }else if (count == 7 || count == 13){
                System.out.println("This is my lucky guess");
            }else if (count == 30){
                System.out.println("Just let me win, I need this more than you.");
            }

            //makes guess halfway between ranges
            guess = (hRange + lRange) / 2;
            System.out.println("Is your number " + guess + "?");
            count++;
            //asks the user fow an answer and does not stop until the answer is h,l or c
            do {
                System.out.println("Please input [H]igher, [L]ower or [C]orrect:");
               input = sc.nextLine();
            }while (!(input.equalsIgnoreCase("h") || input.equalsIgnoreCase("l") || input.equalsIgnoreCase("c")));

            //changes the ranges based upon the previous guess
            if (input.equalsIgnoreCase("h")){
                lRange = guess;

            }else if(input.equalsIgnoreCase("l")){
                hRange = guess;
            }else if(input.equalsIgnoreCase("c")){
                System.out.println("Hurray, I'm the best. I did it in " + count + " turns");
                //ends loop as solution found
                unsolved = false;

            }

            //if ranges are the same there are no more answers
            if (hRange == lRange){
                System.out.println("It could only be " + hRange + "! Hurray, I'm the best. I did it in " + count + " turns");
                unsolved = false;
            }

        }
        do {
            System.out.println("Would you like to play again?(Y/N)");
            input = sc.nextLine();
        } while (!(input.equalsIgnoreCase("Y")|| input.equalsIgnoreCase("N")));

        if(input.equalsIgnoreCase("Y")){
            //returns true tp continue loop in main.
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            System.out.println("Thank you for playing! Goodbye");
            //close the scanner.
            sc.close();
            //returns false to end loop oin main.
            return false;
        }
        return true;
    }

    private int rangeChoice() {
        //method to validate entry of scanner input as a int > 0
        int number;
        do {
            System.out.println("Please enter a positive number!");
            //while last scanner entry was not a number
            while (!sc.hasNextInt()){
                System.out.println("Thats not a number!");
                sc.next();
            }
            number = sc.nextInt();
        } while (number<=0.);
        return number;
    }

}
