package R2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R1, S;
        int R2;

        R1 = scanner.nextInt();
        S = scanner.nextInt();

        R2 = 2*S - R1;
        System.out.println(R2);
    }
}
