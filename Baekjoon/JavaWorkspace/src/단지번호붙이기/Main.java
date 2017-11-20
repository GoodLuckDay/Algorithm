package 단지번호붙이기;

import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] array = new int[N+1][N+1];
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            char[] temp = bufferedReader.readLine().toCharArray();
            for(int j=1; j<=N; j++){
                array[i][j] = Integer.parseInt(String.valueOf(temp[j-1]));
            }
        }
        int count =0;
        int temp = 0;
        ArrayList<Integer> solution = new ArrayList<>();
        int[] dirX = new int[]{0, -1, 0, 1};
        int[] dirY = new int[]{-1, 0, 1, 0};
        for(int i=1;i <=N; i++){
            for(int j=1; j<=N ; j++){
                if(array[i][j] >= 1 && visited[i][j] == false){
                    queue.add(new Pair<>(i, j));
                    while(!queue.isEmpty()){
                        Pair<Integer,Integer> pair = queue.poll();
                        int a = pair.getKey();
                        int b = pair.getValue();
                        visited[a][b] = true;
                        for(int k=0; k<4; k++){
                                int m = a + dirY[k];
                                int n = b + dirX[k];
                                if(((0 < m) && (m <= N)) && ((0 < n) && (n <= N))){
                                    if(((array[m][n] == 1 && visited[m][n] == false) && !queue.contains(new Pair<>(m,n))))
                                        queue.add(new Pair<>(m,n));
                                }
                        }
                        temp+=1;
                    }
                    solution.add(count,temp);
                    temp = 0;
                    count++;
                }
            }
        }
        System.out.println(count);
        Collections.sort(solution);
        for(int i=0; i<solution.size(); i++){
            System.out.println(solution.get(i));
        }
    }
}
