package 침투;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isOK = false;
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int M, N;
    static int[][] map = new int[1005][1005];
    static boolean[][] visit = new boolean[1005][1005];
    public static void main(String[] args) {
        fill_map();
        solve();
        for(int i=1; i<=N; i++){
            if(visit[M][i]){
                isOK = true;
            }
        }
        System.out.println(isOK ? "YES" : "NO");
    }

    private static void solve() {
        for(int i=1; i<=N; i++){
            if(map[1][i] == 0 && !visit[1][i]){
                BFS(1, i);
            }
        }
    }

    private static void BFS(int y, int x) {
        visit[y][x] = true;
        if(y - 1 > 0 && (!visit[y-1][x] && map[y-1][x] == 0)){
            BFS(y-1,x);
        }
        if(y + 1 <= M && (!visit[y+1][x] && map[y+1][x] == 0)){
            BFS(y+1,x);
        }
        if(x - 1 > 0 && (!visit[y][x-1] && map[y][x-1] == 0)){
            BFS(y,x-1);
        }
        if(x + 1 <= N && (!visit[y][x+1] && map[y][x+1] == 0)){
            BFS(y,x+1);
        }
    }

    private static void fill_map() {
        String[] input = scanner.nextLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        for(int i=1; i<=M; i++){
            String[] temp = scanner.nextLine().split("");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }
    }
}
