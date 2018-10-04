package 최대공약수와최소공배수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int maxCommon = gcd(A,B);
        int minMulti = maxCommon * (A / maxCommon) * (B / maxCommon);
        System.out.println(maxCommon);
        System.out.println(minMulti);
    }

    public static int gcd(int n, int k){
        if(n % k ==0){
            return k;
        }
        return gcd(k, n%k);
    }
}
