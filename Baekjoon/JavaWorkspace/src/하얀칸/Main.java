package 하얀칸;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chess = new char[9][9];
        for(int i=1; i<=8; i++){
            char[] str = scanner.nextLine().toCharArray();
            for(int j=1; j<=8; j++){
                chess[i][j] = str[j-1];
            }
        }
        int count = 0;
        for(int i = 1; i <= 8 ; i=i+2){
            if(chess[i][1] == 'F'){
                count++;
            }
            if(chess[i][3] == 'F'){
                count++;
            }
            if(chess[i][5] == 'F'){
                count++;
            }
            if(chess[i][7] == 'F'){
                count++;
            }
        }

        for(int i = 2; i <=8; i=i+2){
            if(chess[i][2] == 'F'){
                count++;
            }
            if(chess[i][4] == 'F'){
                count++;
            }
            if(chess[i][6] == 'F'){
                count++;
            }
            if(chess[i][8] == 'F'){
                count++;
            }
        }
        System.out.println(count);
    }
}
