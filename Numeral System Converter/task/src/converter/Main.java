package converter;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new java.util.ArrayList<>(List.of());
        while (scanner.hasNextLine() && lines.size() != 3) {
            lines.add(scanner.nextLine());
        }
        if (lines.size() != 3) {
            error();
            return;
        }
        String sourceRadix = lines.get(0);
        String radixRegex = "([1-9]|1[0-9]|2[0-9]|3[0-6])";
        if (!sourceRadix.matches(radixRegex)) {
            error();
            return;
        }
        String sourceNumber = lines.get(1);
        if (!sourceNumber.matches("([1-9a-z][0-9a-z]*(\\.[0-9a-z]*)?|0\\.[0-9a-z]+)")) {
            error();
            return;
        }
        String targetRadix = lines.get(2);
        if (!targetRadix.matches(radixRegex)) {
            error();
            return;
        }
        Converter converter = new Converter();
        String targetNumber = converter.convert(
                sourceNumber,
                Integer.parseInt(sourceRadix),
                Integer.parseInt(targetRadix));
        System.out.println(targetNumber);
    }

    private static void error() {
        System.out.println("error");
    }
}
