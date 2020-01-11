package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();
        Converter converter = new Converter();
        String targetNumber = converter.convert(sourceNumber, sourceRadix, targetRadix);
        System.out.println(targetNumber);
    }
}
