package 한수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[1001];
        int N = scanner.nextInt();
        for(int i=0; i<100; i++){
            array[i] = i;
        }

        for(int i=100; i<array.length; i++){
            int onePosition = i%10;
            int twoPosition = (i/10)%10;
            int thrPostion = i/100;
            if(twoPosition - onePosition == thrPostion - twoPosition){
                array[i] = array[i-1]+1;
            }
            else{
                array[i] = array[i-1];
            }
        }

        System.out.println(array[N]);
    }
}
