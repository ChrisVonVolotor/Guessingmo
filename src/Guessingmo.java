public class Guessingmo {
    public static void main(String[] args) {
        //creates the guessGame object from the Guesser class
        Guesser guessGame = new Guesser();
        boolean playAnother = true;
        //loops through the game script until guessSolution returns false
        while (playAnother){
           playAnother = guessGame.guessSolution();
        }


    }

}
