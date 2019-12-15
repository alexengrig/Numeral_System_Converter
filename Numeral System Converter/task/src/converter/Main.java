package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();
        int number;
        if (sourceRadix == 1) {
            number = sourceNumber.length();
        } else {
            number = Integer.parseInt(sourceNumber, sourceRadix);
        }
        String targetNumber = "";
        if (targetRadix == 1) {
            for (int i = 0; i < number; i++) {
                targetNumber += "1";
            }
        } else {
            targetNumber = Integer.toString(number, targetRadix);
        }
        System.out.println(targetNumber);
    }
}
