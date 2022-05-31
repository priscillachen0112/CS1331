import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String operation = new String();
        int firstInteger;
        int secondInteger;
        int intResult;

        double firstDouble;
        double secondDouble;
        double doubleResult;

        String firstString = new String();
        String secondString = new String();

        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation: ");
        operation = input.nextLine().toUpperCase();

        switch (operation) {
            case "ADD":
                System.out.println("Enter two integers: ");

                if (!input.hasNextInt()) {
                    System.out.println("Invalid input entered. Terminating...");
                } else {
                    firstInteger = input.nextInt();
                    secondInteger = input.nextInt();

                    intResult = firstInteger + secondInteger;
                    System.out.println("Answer: " + intResult);
                }
                break;

            case "SUBTRACT":
                System.out.println("Enter two integers: ");

                if (!input.hasNextInt()) {
                    System.out.println("Invalid input entered. Terminating...");
                } else {
                    firstInteger = input.nextInt();
                    secondInteger = input.nextInt();
                    intResult = firstInteger - secondInteger;
                    System.out.println("Answer: " + intResult);
                }
                break;

            case "MULTIPLY":
                System.out.println("Enter two doubles: ");

                if (!input.hasNextDouble() && !input.hasNextInt()) {
                    System.out.println("Invalid input entered. Terminating...");
                } else {
                    firstDouble = input.nextDouble();
                    secondDouble = input.nextDouble();
                    doubleResult = firstDouble * secondDouble;
                    System.out.println("Answer: " + String.format("%.2f", doubleResult));
                }
                break;

            case "DIVIDE":
                System.out.println("Enter two doubles: ");

                if (!input.hasNextDouble() && !input.hasNextInt()) {
                    System.out.println("Invalid input entered. Terminating...");
                } else {
                    firstDouble = input.nextDouble();
                    secondDouble = input.nextDouble();

                    if (secondDouble == 0) {
                        System.out.println("Invalid input entered. Terminating...");
                    } else {
                        doubleResult = firstDouble / secondDouble;
                        System.out.println("Answer: " + String.format("%.2f", doubleResult));
                    }
                }
                break;
            case "ALPHABETIZE":
                System.out.println("Enter two words: ");
                firstString = input.next();
                secondString = input.next();

                char ch1 = firstString.toUpperCase().charAt(0);
                char ch2 = secondString.toUpperCase().charAt(0);

                int ascii1 = ch1;
                int ascii2 = ch2;

                if (ascii1 < ascii2) {
                    System.out.println("Answer: " + firstString + " comes before " + secondString + " alphabetically.");
                } else if (ascii1 > ascii2) {
                    System.out.println("Answer: " + secondString + " comes before " + firstString + " alphabetically.");
                } else if (ascii1 == ascii2) {
                    System.out.println("Answer: Chicken or Egg.");
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}