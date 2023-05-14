import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CLICommands {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        Scanner reader = new Scanner("");
        String doc = "";

        try {
            doc = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File not provided on command line.");
            System.exit(0);
        }

        try {
            reader = new Scanner(new File("/home/neptune/Code/Projects/FastFlashcard/flashcards/" + doc));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

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
