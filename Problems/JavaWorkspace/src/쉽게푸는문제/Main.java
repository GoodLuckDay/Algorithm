package 쉽게푸는문제;
import java.util.Scanner;

public class Main {
    private static int endIndex=1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int[] array = new int[1001];
        int j=0;
        boolean flag = false;
        for(int i=1; ;i++){
            for(j=1; j<=i; j++){
                array[endIndex] = i;
                endIndex++;
                if(endIndex == 1000){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        int sum = 0;
        for(int i = A; i <= B; i++){
            sum += array[i];
        }
        System.out.println(sum);
    }
}
