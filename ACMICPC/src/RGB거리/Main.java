package RGB거리;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] map = new int[1003][1003];
        int[][] answer = new int[1003][1003];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=3; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        answer[1][1] = map[1][1];
        answer[1][2] = map[1][2];
        answer[1][3] = map[1][3];

        for(int i=2; i<=N; i++){
            answer[i][1] = map[i][1] + Integer.min(answer[i-1][2],answer[i-1][3]);
            answer[i][2] = map[i][2] + Integer.min(answer[i-1][1],answer[i-1][3]);
            answer[i][3] = map[i][3] + Integer.min(answer[i-1][1],answer[i-1][2]);
        }

        System.out.printf("%d\n",Integer.min(answer[N][1],Integer.min(answer[N][2],answer[N][3])));
    }
}
