package 치킨먹고싶다;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       int T=0,P=0,M=0,F=0,C=0;
       Scanner scanner = new Scanner(System.in);
       T = scanner.nextInt();
       for(int i=0;i<T;i++) {
           P = scanner.nextInt();
           M = scanner.nextInt();
           F = scanner.nextInt();
           C = scanner.nextInt();

           int order_count = M / P;
           int base_coupon = order_count * C;
           int sang;
           int doo;
           sang = order_count;
           doo = order_count + base_coupon/F;
           while(base_coupon >= F){
               int couponOrder = base_coupon/F;
               sang += couponOrder;
               base_coupon -= couponOrder*F;
               base_coupon += couponOrder*C;
           }
           System.out.println(sang - doo);
       }
    }
}
