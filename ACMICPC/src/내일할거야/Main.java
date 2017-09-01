package 내일할거야;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int minD = Integer.MAX_VALUE;
        int minT = Integer.MAX_VALUE;
        for(int i=0;i < N; i++){
            int D = scanner.nextInt();
            int T = scanner.nextInt();
            if(minT > T ){
                minT = T;
                minD = D;
            }
            else if(T - D <= minT){
                minT = minT - (minT - (T - D));
            }
        }
        System.out.println(minT - minD);
    }
}
