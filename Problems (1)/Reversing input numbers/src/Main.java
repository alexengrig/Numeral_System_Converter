import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            integers.add(i);
        }
        Collections.reverse(integers);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}