package 돌게임;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean SK = true;
        while( N != 1 && N != 3){
            if( N > 3) {
                N -=3;
            }
            else if( N < 3){
                N -=1;
            }
            SK = isSk(SK);
        }
        if(SK){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }

    private static boolean isSk(boolean SK) {
        if(!SK){
            SK = true;
        }
        else{
            SK = false;
        }
        return SK;
    }
}
