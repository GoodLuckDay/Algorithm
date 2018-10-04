package 피보나치수3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine())%1500000;

        int x1 = 0;
        int x2 = 1;
        int temp = 0;
        for(int i=0; i<N; i++){
            temp = x2;
            x2 = (x1 + x2)%1000000;
            x1 = temp;
        }

        System.out.println(x1);
    }
}
