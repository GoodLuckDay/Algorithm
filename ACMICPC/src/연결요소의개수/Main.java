package 연결요소의개수;
//어째서 맨 처음에 map과 vist의 사이즈를 정점의 개수  + 1 로 하였을 때는 오답이 되었는가.
//다음부터는 리스트를 이용을 하여 구현을 하도록 하자
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean[][] map = new boolean[1005][1005];
    static boolean[] visit = new boolean[1005];
    static int N, M;
    static int count=0;
    public static void main(String[] args) {
        init_variable();
        find_connectedFactor();
    }

    private static void find_connectedFactor() {
        for(int index=1; index<=N; index++){
            Queue<Integer> queue = new LinkedList<>();
            if(!isVisit(index)){
                count++;
                queue.add(index);
                while(!queue.isEmpty()){
                    int vertex = queue.poll();
                    visit[vertex] = true;
                    for(int i=1; i<=N; i++){
                        if(map[vertex][i] && !isVisit(i)){
                            queue.add(i);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void init_variable() {
        N = scanner.nextInt();
        M = scanner.nextInt();
        for(int i=0; i<M; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            map[start][end]=map[end][start]=true;
        }
    }

    public static boolean isVisit(int index) {
        return visit[index];
    }
}
