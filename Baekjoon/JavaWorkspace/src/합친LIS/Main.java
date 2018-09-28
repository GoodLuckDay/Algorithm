package 합친LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] A, B;
    private static int[][] cache;
    private static final int MIN = Integer.MIN_VALUE;
    private static final int RET = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());
            A = new int[N+1];
            B = new int[M+1];
            cache = new int[N+1][M+1];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++){
                A[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<M; j++){
                B[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            System.out.println(lis(-1, -1)-2);

        }
    }

    private static int lis(int indexA, int indexB){
        if(cache[indexA+1][indexB+1] != 0){
            return cache[indexA+1][indexB+1];
        }

        cache[indexA+1][indexB+1] = RET;
        int valueA = indexA == -1 ? MIN : A[indexA];
        int valueB = indexB == -1 ? MIN : B[indexB];

        int maxElement = Integer.max(valueA, valueB);

        for(int i=indexA+1; i<N; i++){
            if(maxElement < A[i]){
                cache[indexA+1][indexB+1] = Integer.max(cache[indexA+1][indexB+1],lis(i, indexB)+1);
            }
        }

        for(int i=indexB+1; i<M; i++){
            if(maxElement < B[i]){
                cache[indexA+1][indexB+1] = Integer.max(cache[indexA+1][indexB+1],lis(indexA, i)+1);
            }
        }

        return cache[indexA+1][indexB+1];
    }

}

