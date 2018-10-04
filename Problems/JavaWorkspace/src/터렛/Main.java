package 터렛;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int r1, r2;
    static double d;
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for(int i=0; i<T; i++){
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            r1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            r2 = scanner.nextInt();
            d = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
            if( d==0 && (r1 == r2)){
                System.out.println(-1);
            }
            else if(r1 + r2 > d && Math.abs(r1-r2) < d){
                System.out.println(2);
            }
            else if(r1 + r2 == d || Math.abs(r1-r2) == d){
                System.out.println(1);
            }
            else if(r1 + r2 < d || Math.abs(r1-r2) > d){
                System.out.println(0);
            }

        }
    }
}
