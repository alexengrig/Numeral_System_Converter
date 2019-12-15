package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int radix = scanner.nextInt();
        if (radix == 2) {
            System.out.println("0b" + Integer.toBinaryString(number));
        } else if (radix == 8) {
            System.out.println("0" + Integer.toOctalString(number));
        } else if (radix == 16) {
            System.out.println("0x" + Integer.toHexString(number));
        }
    }
}
