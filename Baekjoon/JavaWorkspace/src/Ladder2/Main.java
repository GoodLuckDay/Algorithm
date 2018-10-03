package Ladder2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 100;
    private static int[][] board;
    private static int[][] cache;
    private static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        for(int i=0; i<10; i++){
            int T = Integer.parseInt(br.readLine());
            board = new int[SIZE][SIZE];
            cache = new int[SIZE][SIZE];
            for(int j=0; j<SIZE; j++){
                stringTokenizer = new StringTokenizer(br.readLine());
                for(int k=0; k<SIZE; k++){
                    board[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    cache[j][k] = -1;
                }
            }
            int value = Integer.MAX_VALUE;
            int answer = -1;
            for(int j=0; j<SIZE; j++){
                visit = new boolean[SIZE][SIZE];
                if(board[0][j] == 1){
                    int cand = solve(0, j);
                    if(cand < value){
                        value = cand;
                        answer = j;
                    }
                }
            }
            System.out.printf("#%d %d", T, answer);
        }
    }

    private static int solve(int y, int x) {
        if(y == SIZE){
            return 0;
        }

        if(board[y][x] != 1){
            return 0;
        }

        if(cache[y][x] != -1){
            return cache[y][x];
        }

        int nextDirection = 0;
        if(x - 1 >= 0 && board[y][x-1] == 1 && !visit[y][x-1]){
            nextDirection = -1;
        }
        else if(x + 1 <SIZE && board[y][x+1] == 1 && !visit[y][x+1]){
            nextDirection = 1;
        }
        visit[y][x] = true;
        return cache[y][x] = solve(y+(nextDirection == 0 ? 1 : 0), x+nextDirection) + 1;
    }
}
