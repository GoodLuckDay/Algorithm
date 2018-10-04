package 점프점프;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[1001];
        Arrays.fill(array,Integer.MAX_VALUE);
        array[1] = 0;
        for(int i=1; i<=N; i++){
            int number = scanner.nextInt();
            for(int j=1; j <= number; j++){
                if(i+j < array.length){
                    array[i+j] = Integer.min(array[i]+1,array[i+j]);
                }
            }
        }
       if(array[N] == Integer.MAX_VALUE || array[N] < 0 ){
           System.out.println(-1);
       }
       else{
           System.out.println(array[N]);
       }
    }
}
