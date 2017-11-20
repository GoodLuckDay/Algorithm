package 숨박꼭질3;

import javafx.util.Pair;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        int [] counts = new int[100001];
        for(int i=0; i < counts.length; i++){
            counts[i] = Integer.MAX_VALUE;
        }
        counts[N] = 0;
        queue.add(new Pair<>(N,counts[N]));
        while(!queue.isEmpty()){
            int pos = queue.peek().getKey();
            visit[pos] = true;
            queue.poll();
            if(pos == K){
                System.out.println(counts[pos]);
                return;
            }
            else{
               if(pos*2 <= visit.length && !visit[2*pos]){
                   visit[2*pos] = true;
                   counts[2*pos] = Integer.min(counts[2*pos],counts[pos]);
                   queue.add(new Pair<>(2*pos,counts[2*pos]));
               }
               if(pos-1 >= 0 && !visit[pos-1]){
                   visit[pos-1] = true;
                   counts[pos-1] = Integer.min(counts[pos-1],counts[pos]+1);
                   queue.add(new Pair<>(pos-1,counts[pos-1]));
               }
               if(pos+1 < visit.length && !visit[pos+1]){
                   visit[pos+1] = true;
                   counts[pos+1] = Integer.min(counts[pos+1],counts[pos]+1);
                   queue.add(new Pair<>(pos+1,counts[pos+1]));
               }
            }
        }
    }
}
