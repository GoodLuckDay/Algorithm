package 숫자삼각형;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][];
        for(int i=0; i < n; i++){
            int inputNum;
            array[i] = new int[i+1];
            for(int j=0; j<=i; j++){
                inputNum = scanner.nextInt();
                array[i][j] = inputNum;
                if(i > 0 ){
                    if(j == 0){
                        array[i][j] += array[i-1][j];
                    }
                    else if(j == array[i].length-1){
                        array[i][j] += array[i-1][j-1];
                    }
                    else{
                        array[i][j] += Integer.max(array[i-1][j-1],array[i-1][j]);
                    }
                }
            }
        }
        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i<array[n-1].length; i++){
            if(maxNum < array[n-1][i]){
                maxNum = array[n-1][i];
            }
        }
        System.out.println(maxNum);
    }
}
