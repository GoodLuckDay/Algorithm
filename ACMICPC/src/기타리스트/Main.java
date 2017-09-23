package 기타리스트;
import java.util.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int N, S, M;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        N = scanner.nextInt();
        S = scanner.nextInt();
        M = scanner.nextInt();

        for(int i=0; i<N; i++){
            arrayList.add(scanner.nextInt());
        }

        queue.add(S);
        for(int i=0; i<arrayList.size(); i++){
            int qSize = queue.size();
            for(int j=0; j<qSize;j++) {
                int temp = queue.poll();
                int plusValue = temp + arrayList.get(i);
                int minusValue = temp - arrayList.get(i);
                if (plusValue >= 0 && plusValue <= M) {
                    queue.add(plusValue);
                }
                if(minusValue >= 0 && minusValue <= M){
                    queue.add(minusValue);
                }
            }
        }
        int max = -1;
        int qSize = queue.size();
        for(int i=0; i<qSize; i++){
            int temp = queue.poll();
            max = Integer.max(max, temp);
        }
        System.out.println(max);
    }
}
