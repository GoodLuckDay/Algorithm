package 달팽이;

/*
책에 있는대로 구현하였지만 시간 초과 발생
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static double[][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            cache = new double[1001][2002];

            for(int j=0; j<cache.length; j++){
                for(int k=0; k<cache[j].length; k++){
                    cache[j][k] = -1;
                }
            }


            bufferedWriter.write(String.valueOf(solve(0, 0))+"\n");
        }
        bufferedWriter.flush();

    }

    private static double solve(int days, int climbed) {
        if(days == m){
            return cache[days][climbed] = climbed >= n ? 1 : 0;
        }

        if(cache[days][climbed] != -1){
            return cache[days][climbed];
        }
        return cache[days][climbed] = (0.25 * solve(days+1, climbed+1)) + (0.75 * solve(days+1, climbed+2));
    }
}
