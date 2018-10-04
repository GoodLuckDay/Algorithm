package 승자예측하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            long n = Long.parseLong(br.readLine());

            if(n <= 3){
                System.out.printf("#%d %s\n", i + 1, n == 1 ? "Bob" : "Alice");
            }
            else{
                long size = 4;
                int depth = 2;
                while(true){
                    if(size <= n && size * 2 > n) break;
                    size *= 2;
                    depth++;
                }

                long x = 1;
                if(depth % 2 == 0){
                    for(int j=1; j<=depth; j++){
                        x = j % 2 == 0 ? x * 2 : x * 2 + 1;
                    }
                    System.out.printf("#%d %s\n", i + 1, x > n ? "Alice" : "Bob");
                }
                else{
                    for(int j=1; j<=depth; j++){
                        x = j % 2 == 0 ? x * 2 + 1 : x * 2;
                    }
                    System.out.printf("#%d %s\n", i + 1, x <= n ? "Alice" : "Bob");
                }
            }

        }
    }

}
