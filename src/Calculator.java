import java.util.Scanner;

public class Calculator {
    void RunAPP() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number: ");
        String num1 = input.nextLine();

        System.out.println("Enter second number: ");
        String num2 = input.nextLine();

        System.out.println("Enter operator (+, -, *, /): ");
        String operator = input.nextLine();

        try {
            if (Converter.isValid(num1) && Converter.isValid(num2)) {
                int result = calculate(Converter.toArabic(num1), Converter.toArabic(num2), operator);
                System.out.println(Converter.toRoman(result));
            } else {
                int result = calculate(Integer.parseInt(num1), Integer.parseInt(num2), operator);
                System.out.println(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator. Please enter a valid operator (+, -, *, /).");
        }
    }
}
