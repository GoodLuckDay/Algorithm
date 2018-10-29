package 장훈이의높은선반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static boolean[] cache;
    private static Queue<Integer> queue;
    private static int N, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            B = Integer.parseInt(stringTokenizer.nextToken());
            queue = new LinkedList<>();

            int sum = 0;
            stringTokenizer = new StringTokenizer(br.readLine());
            while(stringTokenizer.hasMoreTokens()){
                int value = Integer.parseInt(stringTokenizer.nextToken());
                queue.add(value);
                sum += value;
            }

            cache = new boolean[sum+1];
            cache[0] = true;
            while(!queue.isEmpty()){
                int value = queue.poll();

                for(int j=sum; j>=0; j--){
                    if(cache[j] && j+value<=sum){
                        cache[j+value] = true;
                    }
                }

            }

            for(int j=B; j<=sum; j++){
                if(cache[j]){
                    System.out.printf("#%d %d\n", i+1, j-B);
                    break;
                }
            }
        }
    }

}
