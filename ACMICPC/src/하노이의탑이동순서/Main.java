package 하노이의탑이동순서;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println((int)(Math.pow(2,N)-1));
        hanoi(N, 1, 2,3);
    }

    public static void hanoi(int size,int source, int medium, int destination){
        if(size == 1){
            System.out.println(source+" "+destination);
            return ;
        }
        hanoi(size-1, source, destination, medium);
        System.out.println(source+" "+destination);
        hanoi(size-1,medium,source,destination);
    }
}
