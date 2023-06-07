import java.util.Scanner;

public class UserInputMethods {

    private static Scanner scanner = new Scanner(System.in);


    public static int getIntInput() {

        int number = -1;
    
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // flush newline
                break;
            } else {
                System.out.println("Try again.");
                scanner.nextLine(); // flush the entire line
            }
        }
    
        return number;
    }
    
}
