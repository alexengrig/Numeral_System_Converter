import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Map<Character, Character> encodeMapping = new HashMap<>();
        Map<Character, Character> decodeMapping = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String third = scanner.nextLine();
        String fourth = scanner.nextLine();
        for (int i = 0; i < first.length(); i++) {
            char left = first.charAt(i);
            char right = second.charAt(i);
            encodeMapping.put(left, right);
            decodeMapping.put(right, left);
        }
        for (char c : third.toCharArray()) {
            System.out.print(encodeMapping.get(c));
        }
        System.out.println();
        for (char c : fourth.toCharArray()) {
            System.out.print(decodeMapping.get(c));
        }
    }
}