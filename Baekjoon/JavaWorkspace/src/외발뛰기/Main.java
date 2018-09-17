package 외발뛰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int count = 0;
    private static int n;
    private static int[][] board;
    private static int[][] isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int C;


        C = Integer.parseInt(bufferedReader.readLine());

        for(int c=0;c<C;c++) {
            count = 0;
            n = Integer.parseInt(bufferedReader.readLine());
            board = new int[n][n];
            isPossible = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            jumb(0, 0);
            System.out.println(count > 0 ? "YES" : "NO");
        }
    }

    private static int jumb(int y, int x){
        if((y == n-1 && x == n-1)){
            count++;
            return 1;
        }
        else if((y >= n || x >= n)){
            return -1;
        }

        if(isPossible[y][x] == 1){
            count++;
            return 1;
        }
        else if(isPossible[y][x] == -1){
            return -1;
        }

        int jumpSize = board[y][x];
        return isPossible[y][x] = jumb(y+jumpSize, x) | jumb(y, x+jumpSize);

    }
}
