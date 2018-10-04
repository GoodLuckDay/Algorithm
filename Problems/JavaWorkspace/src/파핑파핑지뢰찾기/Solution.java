package 파핑파핑지뢰찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static char[][] board;
    private static boolean[][] visit;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            visit = new boolean[N][N];

            for(int j=0; j<N; j++){
                board[j] = br.readLine().toCharArray();
            }

            completeBoard();

            int answer =0;

            for(int j=0;j<N; j++){
                for(int k=0;k<N; k++){
                    if(board[j][k] == '0' && !visit[j][k]){
                        answer++;
                        dfs(j, k);
                    }
                }
            }

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(!visit[j][k] && board[j][k] != '*'){
                        answer++;
                    }
                }
            }
            System.out.printf("#%d %d\n", i+1, answer);

        }

    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;

        if(board[y][x] != '0'){
            return ;
        }

        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(0<=i+y && i+y<N && 0<=j+x && j+x<N){
                    if(board[y+i][x+j] != '*' && !visit[y+i][x+j]){
                        dfs(y+i,x+j);
                    }
                }
            }
        }
    }

    private static void completeBoard() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == '.'){
                    int mine = 0;

                    for(int y=-1; y<=1; y++){
                        for(int x=-1; x<=1; x++){
                            if(0<=i+y && i+y<N && 0<=j+x && j+x<N){
                                if(board[i+y][j+x] == '*'){
                                    mine += 1;
                                }
                            }
                        }
                    }
                    board[i][j] = String.valueOf(mine).charAt(0);
                }
            }
        }
    }
}
