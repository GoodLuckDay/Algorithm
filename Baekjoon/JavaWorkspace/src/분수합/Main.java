package 분수합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int answerB = b * d;
        int answerA = a * (answerB / b) + c * (answerB / d);
        int temp = gcc(answerA,answerB);
        System.out.println(answerA/temp+" "+answerB/temp);
    }

    public static int gcc(int n, int k){
        if(n % k == 0 ){
            return k;
        }
        return gcc(k,n%k);
    }
}
