package 삼각형위의최대경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int[][] cache;
    private static ArrayList<Integer>[] maps;
    private static int N;
    public static void main(String[] args) throws IOException {
        int T;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<T; i++){

            N = Integer.parseInt(bufferedReader.readLine());
            cache = new int[101][101];
            maps = new ArrayList[N];

            for(int j=0; j<N; j++){
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                maps[j] = new ArrayList();

                while(stringTokenizer.hasMoreTokens()){
                    maps[j].add(Integer.parseInt(stringTokenizer.nextToken()));
                }
            }

            System.out.println(calculate(0,0));

        }

    }

    private static int calculate(int y, int x){
        if(cache[y][x] != 0){
            return cache[y][x];
        }
        else if(y == N-1){
            return cache[y][x] = maps[y].get(x);
        }
        else{
            return cache[y][x] = maps[y].get(x) + Math.max(calculate(y+1, x), calculate(y+1, x+1));
        }
    }
}
