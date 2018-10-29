package 타임머신;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final int MAX = 620000000;
    static int[][] graph;
    static int[] solve;
    static int vertex;
    static int edge;
    public static void main(String[] args){
        initGraph();
        shortestPath();

    }

    private static void shortestPath() {
        solve[1] = 0;
        for(int i=2; i<=vertex; i++){
            solve[i] = MAX;
        }

        for(int i=0; i<vertex; i++){
            for(int j=1; j<=vertex; j++){
                for(int k=1; k<=vertex; k++){
                    if(graph[j][k] != 0 && solve[k] > solve[j] + graph[j][k]){
                        solve[k] = solve[j] + graph[j][k];
                    }
                }
            }
        }

        for(int i=1; i<=vertex; i++){
            for(int j=1; j<=vertex; j++){
                if(graph[i][j] != 0 && solve[j] > solve[i] + graph[i][j]){
                    System.out.println(-1);
                    return ;
                }
            }
        }

        for(int i=2; i<=vertex; i++){
            System.out.println(solve[i] == MAX ? -1 : solve[i]);
        }

    }
    private static void initGraph() {
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        graph = new int[vertex+1][vertex+1];
        solve = new int[vertex+1];
        for(int i=0; i<edge; i++){
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            if(graph[src][dest] == 0){
                graph[src][dest] = weight;
            }
            else{
                graph[src][dest] = Integer.min(graph[src][dest], weight);
            }
        }
    }
}
