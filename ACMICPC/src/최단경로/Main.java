package 최단경로;

import javafx.util.Pair;

import java.util.*;

public class Main {
    static ArrayList<Pair<Integer,Integer>>[] map;
    static int[] dist;
    static int V;
    static int E;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        E = scanner.nextInt();
        int startPoint = scanner.nextInt();

        map = new ArrayList[V+1];
        dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0; i<map.length; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            map[start].add(new Pair<Integer,Integer>(end, cost));
        }

        findPath(startPoint);
        for(int i=1; i<dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(dist[i]);
            }
        }
    }

    public static void findPath(int startPoint){
        PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        dist[startPoint] = 0;
        priorityQueue.add(new Pair(startPoint,dist[startPoint]));

        while(!priorityQueue.isEmpty()){
            int startPosition = priorityQueue.peek().getKey();
            priorityQueue.poll();

            for(Pair<Integer,Integer> pair : map[startPosition]){
                if(dist[pair.getKey()] > dist[startPosition] + pair.getValue()){
                    dist[pair.getKey()] = dist[startPosition] + pair.getValue();
                    priorityQueue.add(new Pair(pair.getKey(), pair.getValue()));
                }

            }
        }

    }
}
