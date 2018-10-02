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
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer;

        for(int i=0; i<T; i++){
            count = 0;
            map = new String[4][4];
            hashSet = new HashSet<>();
            for(int j=0; j<4; j++){
                stringTokenizer = new StringTokenizer(br.readLine());
                for(int k=0; k<4; k++){
                    map[j][k] = stringTokenizer.nextToken();
                }
            }
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    DFS(j, k, map[j][k],1);
                }
            }

            System.out.printf("#%d %d\n",i+1,hashSet.size());
        }
    }

    private static void DFS(int y, int x, String sentence, int length) {
        if(length == 7){
            hashSet.add(sentence);
            return ;
        }
        for(int i=0; i<4; i++){
            if(y+dy[i]>=0 && y+dy[i]<4 && x+dx[i]>=0 && x+dx[i]<4) {
                DFS(y + dy[i], x + dx[i], sentence + map[y+dy[i]][x+dx[i]], length + 1);
            }
        }
    }
}
