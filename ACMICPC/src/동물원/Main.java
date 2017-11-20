package 동물원;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] table = new int[100000][3];

        table[0][0] = 1;
        table[0][1] = 1;
        table[0][2] = 1;

        for(int i=1; i<N; i++){
            table[i][0] = (table[i-1][0] + table[i-1][1] + table[i-1][2])%9901;
            table[i][1] = (table[i-1][0] + table[i-1][2])%9901;
            table[i][2] = (table[i-1][0] + table[i-1][1])%9901;
        }

        System.out.printf("%d\n",(table[N-1][0] + table[N-1][1] + table[N-1][2])%9901);
    }
}
