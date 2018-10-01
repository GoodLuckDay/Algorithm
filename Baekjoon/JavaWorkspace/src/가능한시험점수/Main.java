package 가능한시험점수;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    private static int N, sum, count;
    private static boolean[] visit;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer stringTokenizer;
            N = Integer.parseInt(br.readLine());
            stringTokenizer = new StringTokenizer(br.readLine());
            sum = 0;
            count = 0;
            while(stringTokenizer.hasMoreTokens()){
                int value = Integer.parseInt(stringTokenizer.nextToken());
                queue.offer(value);
                sum += value;
            }
            visit = new boolean[sum+1];
            visit[0] = true;
            DFS(0);
            System.out.println("#"+i+" "+count);
        }


    }

    private static void DFS(int depth) {
        if(depth == N){
            for(int i=0; i<=sum; i++){
                if(visit[i]){
                    count++;
                }
            }
            return ;
        }

        int value = queue.poll();

        for(int i=sum-1; i>=0; i--){
            if(visit[i]){
                visit[i+value] = true;
            }
        }
        DFS(depth+1);
    }
}