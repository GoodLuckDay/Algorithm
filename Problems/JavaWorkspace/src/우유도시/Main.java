package 우유도시;

/*
현재 상태에서 우유를 먹지않고 후에 우유를 먹었을 때에 대한 케이스를 고려하지 못했다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int[][] cache;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cache = new int[N][N];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.fill(cache[i], -1);
        }

        System.out.println(dfs(0, 0, -1));

    }

    private static int dfs(int y, int x, int prevMilk) {
        if(y >= N || x >= N){
            return 0;
        }

        if(y == N-1 && x == N-1){
            return (prevMilk+1)%3 == map[y][x] ? 1 : 0;
        }

        int milkCount = 0;
        milkCount += (prevMilk+1)%3 == map[y][x] ? 1 : 0;

        if(cache[y][x] != -1){
            return cache[y][x] + milkCount;
        }

        int lastDrinked = milkCount == 1 ? map[y][x] : prevMilk;
        cache[y][x] = 0;
        cache[y][x] += Math.max(dfs(y+1, x, lastDrinked),dfs(y, x+1, lastDrinked));
        return cache[y][x] + milkCount;

    }
}

//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String... args) {
//        Scanner input = new Scanner(System.in);
//        int N = input.nextInt();
//        int[] milks = new int[] { 0, 1, 2 };
//        int[][] graph = new int[N][N];
//        int[][][] dp = new int[N + 1][N + 1][3];
//
//        for (int i = 0; i < N; i++)
//            for (int j = 0; j < N; j++)
//                graph[i][j] = input.nextInt();
//
//        for (int i = N - 1; i >= 0; i--)
//            for (int j = N - 1; j >= 0; j--)
//                for (int milk : milks)
//                    if (graph[i][j] != milk)
//                        dp[i][j][milk] = Math.max(dp[i + 1][j][milk], dp[i][j + 1][milk]);
//                    else
//                        dp[i][j][milk] = 1 + Math.max(dp[i + 1][j][(milk + 1) % 3], dp[i][j + 1][(milk + 1) % 3]);
//
//        System.out.print(dp[0][0][0]);
//    }
//}
