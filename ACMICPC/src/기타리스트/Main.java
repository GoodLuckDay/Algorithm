package 기타리스트;
import java.util.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Queue<Integer> queue = new LinkedList<>();
    static int N, S, M;
    public static void main(String[] args) {
        N = scanner.nextInt();
        S = scanner.nextInt();
        M = scanner.nextInt();
        int[][] d = new int[N+1][M+1];

        for(int i=0; i<N; i++){
            queue.add(scanner.nextInt());
            Arrays.fill(d[i],-1);
        }

        d[0][S] = 1;
        for(int i=0; i<N; i++){
            int current = queue.poll();
            for(int k=0; k<=M; k++){
                if(d[i][k] == 1){
                    if(k + current <=M){
                        d[i+1][k+current] = 1;
                    }
                    if(k - current >=0){
                        d[i+1][k-current] = 1;
                    }
                }
            }
        }
        int answer = -1;
        for(int k=M; k>=0; k--){
            if(d[N][k] == 1) {
                answer = k;
                break;
            }
        }
        System.out.println(answer);
    }
}
