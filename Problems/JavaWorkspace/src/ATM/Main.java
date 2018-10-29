package ATM;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int N = scanner.nextInt();

        for(int i=0; i<N; i++){
            int P = scanner.nextInt();
            priorityQueue.add(P);
        }

        int times = 0;
        int ans = 0;
        while(!priorityQueue.isEmpty()){
            times += priorityQueue.poll();
            ans += times;
        }
        System.out.println(ans);
    }
}
