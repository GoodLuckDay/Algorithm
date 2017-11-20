package 피보나치함수;

import java.util.Scanner;

public class Main {
    static int zero = 0;
    static int one = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0; i<T; i++){
            int number = scanner.nextInt();
            fibonacci(number);
            System.out.println(zero+" "+one);
            zero = 0;
            one = 0;
        }
    }

    public static int fibonacci(int n){
        if(n == 0){
            zero +=1;
            return 0;
        }
        else if(n == 1){
            one +=1;
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
