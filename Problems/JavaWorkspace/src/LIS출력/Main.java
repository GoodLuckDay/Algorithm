package LIS출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] array, cache, choice;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        N = Integer.parseInt(br.readLine());

        array = new int[101];
        cache = new int[101];
        choice = new int[101];
        stringTokenizer = new StringTokenizer(br.readLine());

        Arrays.fill(choice, -1);
        Arrays.fill(cache, -1);
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        lis(-1);

        ArrayList<Integer> route = new ArrayList<>();
        reconstruct(-1, route);

        for(int i=0; i<route.size(); i++){
            System.out.println(route.get(i));
        }

    }

    private static void reconstruct(int start, ArrayList<Integer> route) {
        if(start != -1) route.add(array[start]);
        int next = choice[start+1];
        if(next != -1) reconstruct(next, route);
    }

    private static int lis(int start) {
        if(cache[start+1] != -1){
            return cache[start+1];
        }

        cache[start+1] = 1;
        int bestNext = -1;

        for(int i=start+1; i<N; i++){
            if(start == -1 || array[start] < array[i]){
                int cand = lis(i) + 1;
                if(cache[start+1] < cand){
                    cache[start+1] = cand;
                    bestNext = i;
                }

            }
        }
        choice[start+1] = bestNext;
        return cache[start+1];
    }
}
