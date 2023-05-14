import java.io.File;
import java.util.Scanner;

public class FastFlashcard {
    public static void main(String[] args) throws Exception {

        String flashcardDoc = args[0];

        Scanner input = new Scanner(System.in);
        Scanner reader = new Scanner(new File("/home/neptune/Code/Projects/FastFlashcard/flashcards/" + flashcardDoc));


        while (reader.hasNextLine()) {

            // print the question
            System.out.println("\n" + reader.nextLine() + "\n");

            // ask for the answer
            System.out.print("Answer: ");
            String answer = input.nextLine();

            // check if correct
            String correctAnswer = reader.nextLine();
            if (answer.equals(correctAnswer)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect. The correct answer is '" + correctAnswer + "'");
            }


        }

        System.out.println("document completed");
        input.close();
        
    }
}
