package 내리막길;

import java.util.Scanner;

public class Main {
    private static int M, N;
    private static int[][] board;
    private static int[][] cache;
    private static boolean[][] visit;
    private static int[] dirY = new int[]{-1,0,0,1};
    private static int[] dirX = new int[]{0,-1,1,0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();

        board = new int[M][N];
        cache = new int[M][N];
        visit = new boolean[M][N];

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                board[i][j] = scanner.nextInt();
                cache[i][j] = -1;
            }
        }

        int result = findRoute(0,0);
        System.out.println(result);

    }

    private static int findRoute(int y, int x) {
        if(y == M-1 && x == N-1){
            return 1;
        }
        if(cache[y][x] != -1){
            return cache[y][x];
        }

        int currentHeight = board[y][x];
        int count = 0;
        for(int i=0; i<4; i++){
            int dy = y+dirY[i];
            int dx = x+dirX[i];
            if((0 <= dy && dy < M) && (0 <= dx && dx < N)) {
                if (!visit[dy][dx] && currentHeight > board[dy][dx]){
                    visit[dy][dx] = true;
                    count += findRoute(dy, dx);
                    visit[dy][dx] = false;
                }
            }
        }
        return cache[y][x]=count;
    }
}
