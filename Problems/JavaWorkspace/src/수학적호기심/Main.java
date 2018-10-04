package 수학적호기심;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int T = scanner.nextInt();
        for(int i=0; i<T; i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for(int j=1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if((j*j + k*k + m)%(j*k) == 0){
                        count++;
                    }
                }
            }
            System.out.println(count);
            count=0;
        }
    }
}
