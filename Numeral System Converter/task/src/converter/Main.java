package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String binary = Integer.toOctalString(number);
        System.out.println(binary.charAt(binary.length() - 1));
    }
}
