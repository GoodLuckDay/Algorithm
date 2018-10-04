package 쉬운계단수;

import java.util.*;
public class Main {

    public static void main(String[] args){
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        long sum=0;
        long[][] result = new long[101][10];
        for(int i=1;i<=9;i++)
            result[1][i]=1;
        for(int i=2;i<=N;i++){
            for(int j=0;j<=9;j++){
                long count=0;
                if(j+1<=9){
                    count+=result[i-1][j+1];
                }
                if(j-1>=0){
                    count+=result[i-1][j-1];
                }
                result[i][j]=count % 1000000000;
            }
        }
        for(int k=0;k<10;k++){
            sum+=result[N][k];
        }
        System.out.println(sum%1000000000);
    }
}
