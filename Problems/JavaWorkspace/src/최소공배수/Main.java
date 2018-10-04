package 최소공배수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0; i<T; i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int result = gcd(n , k);
            n = n/result;
            k = k/result;
            System.out.println(result*n*k);
        }
    }
    public static int gcd(int n, int k){
        if(n%k == 0){
            return k;
        }
        return gcd(k, n%k);
    }
}
