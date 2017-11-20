package 돌게임;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt() % 2 == 0 ? "CY" : "SK");
    }
}
