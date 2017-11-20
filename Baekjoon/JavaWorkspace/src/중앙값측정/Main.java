package 중앙값측정;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Queue<Long> queue = new LinkedList<>();
        int midValue = (K + 1)/2;
        long temp = 0;
        for(int i=0; i < N; i++){
            queue.add((long) scanner.nextInt());
        }
        ArrayList<Long> answer = new ArrayList<>();
        for(int i=0; i < N; i++){
            answer.add(queue.poll());
            if(answer.size() == K){
                Collections.sort(answer);
                temp += answer.get(midValue-1);
                answer.remove(0);
            }
        }
        System.out.println(temp);
    }
}
