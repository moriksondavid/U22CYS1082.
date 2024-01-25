import java.util.Scanner;
public class twoDigitCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        //USER INPUTS A VALID FIRST TWO-DIGIT NUMBER
        System.out.print("Enter the first two-digit number: ");
        int num1 = getTwoDigitNumber(scanner);
    
         //USER INPUTS A VALID OPERATOR
        System.out.print("Enter the operation (+, -, *, /): ");
        char operation = getValidOperation(scanner);
    
         //USER INPUTS A VALID SECOND TWO-DIGIT NUMBER
        System.out.print("Enter the second two-digit number: ");
        int num2 = getTwoDigitNumber(scanner);
    
        //DISPLAYS A VALID RESULT
        int result = performOperation(num1, num2, operation);
        System.out.println("Result: " + result);
    }
    
    private static int getTwoDigitNumber(Scanner scanner) {
        int number;
        do {
            System.out.print("Enter a two-digit number: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a two-digit number: ");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < 10 || number > 99);
    
        return number;
    }
    
    private static char getValidOperation(Scanner scanner) {
        char operation;
        do {
            System.out.print("Enter a valid operation (+, -, *, /): ");
            operation = scanner.next().charAt(0);
        } while (operation != '+' && operation != '-' && operation != '*' && operation != '/');
    
        return operation;
    }
    
    private static int performOperation(int num1, int num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero.");
                    System.exit(1);
                }
                return num1 / num2;
            default:
                System.out.println("Invalid operation");
                System.exit(1);
                return 0; // Unreachable code, added for compilation
        }
    }
}
