package 내려가기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] maxStair = new int[100004][4];
        int[][] minStair = new int[100004][4];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=3; j++){
                maxStair[i][j] = scanner.nextInt();
                minStair[i][j] = maxStair[i][j];
            }
        }
        for(int i=1; i<=N; i++){
            maxStair[i+1][1] = maxStair[i+1][1] + Integer.max(maxStair[i][1],maxStair[i][2]);
            minStair[i+1][1] = minStair[i+1][1] + Integer.min(minStair[i][1],minStair[i][2]);
            maxStair[i+1][2] = maxStair[i+1][2] + Integer.max(maxStair[i][1],Integer.max(maxStair[i][2],maxStair[i][3]));
            minStair[i+1][2] = minStair[i+1][2] + Integer.min(minStair[i][1],Integer.min(minStair[i][2],minStair[i][3]));
            maxStair[i+1][3] = maxStair[i+1][3] + Integer.max(maxStair[i][2],maxStair[i][3]);
            minStair[i+1][3] = minStair[i+1][3] + Integer.min(minStair[i][2],minStair[i][3]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=3; i++){
            if(max < maxStair[N][i]){
                max = maxStair[N][i];
            }
            if(min > minStair[N][i]){
                min = minStair[N][i];
            }
        }
        System.out.println(max+" "+min);
    }
}
