package 최소비용구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int city = scanner.nextInt();
        int bus = scanner.nextInt();
        int[][] array = new int[city+1][city+1];
        int[] dist = new int[city+1];
        boolean[] visit = new boolean[city+1];

        for(int i=0; i<dist.length;i++){
            Arrays.fill(array[i],Integer.MAX_VALUE);
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<bus; i++){
            int startCity = scanner.nextInt();
            int endCity = scanner.nextInt();
            int cost = scanner.nextInt();
            if(array[startCity][endCity] > cost){
                array[startCity][endCity] = cost;
            }
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        dist[start] = 0;

        for(int i=0; i<city; i++){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int j=1; j<=city; j++){
                if(!visit[j] && min > dist[j]){
                    min = dist[j];
                    index = j;
                }
            }
            visit[index] = true;
            for(int j=1; j<= city; j++){
                if(array[index][j] !=Integer.MAX_VALUE && (dist[j] > dist[index] + array[index][j])){
                    dist[j] = dist[index] + array[index][j];
                }
            }
        }
        System.out.println(dist[end]);

    }
}
