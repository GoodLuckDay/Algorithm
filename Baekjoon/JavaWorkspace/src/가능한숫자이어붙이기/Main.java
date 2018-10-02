package 가능한숫자이어붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static HashSet<String> hashSet;
    static String map[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer;

        for(int i=0; i<T; i++){
            count = 0;
            map = new String[4][4];
            visited = new boolean[4][4];
            hashSet = new HashSet<>();
            for(int j=0; j<4; j++){
                stringTokenizer = new StringTokenizer(br.readLine());
                for(int k=0; k<4; k++){
                    map[j][k] = stringTokenizer.nextToken();
                }
            }
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    visited[j][k] = true;
                    DFS(j, k, map[j][k],1);
                    visited[j][k] = false;
                }
            }

            System.out.println(hashSet.size());
        }
    }

    private static void DFS(int y, int x, String sentence, int length) {
        if(length == 7){
            hashSet.add(sentence);
        }
        if(x - 1 >=0 && !visited[y][x-1]){
            visited[y][x-1] = true;
            DFS(y, x-1, sentence+map[y][x-1], length+1);
            visited[y][x-1] = false;
        }

        if(y - 1 >=0 && !visited[y-1][x]){
            visited[y-1][x] = true;
            DFS(y-1, x, sentence+map[y-1][x], length+1);
            visited[y-1][x] = false;
        }

        if(x + 1 < 4 && !visited[y][x+1]){
            visited[y][x+1] = true;
            DFS(y, x+1, sentence+map[y][x+1], length+1);
            visited[y][x+1] = false;
        }

        if(y + 1 < 4 && !visited[y+1][x]){
            visited[y+1][x] = true;
            DFS(y+1, x, sentence+map[y+1][x], length+1);
            visited[y+1][x] = false;
        }

    }


}
