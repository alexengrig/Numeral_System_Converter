import java.util.Scanner;
import java.util.stream.Stream;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            for (char c : string.toCharArray()) {
                if (!Character.isDigit(c)) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = Stream
                .of(scanner.nextLine().split("\\s+"))
                .toArray(String[]::new);

        String result = concatenateStringsWithoutDigits(strings);

        System.out.println(result);
    }
}