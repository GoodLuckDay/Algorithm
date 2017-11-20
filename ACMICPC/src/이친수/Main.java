package 이친수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] array = new long[91][2];

        array[1][0] = 0;
        array[1][1] = 1;

        for(int i=1; i<N; i++){
            array[i+1][0] = array[i][0] + array[i][1];
            array[i+1][1] = array[i][0];
        }

        System.out.printf("%d\n",array[N][0]+array[N][1]);
    }
}
