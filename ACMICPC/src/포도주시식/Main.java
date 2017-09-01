package 포도주시식;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int[] jan = new int[10000];
        int[] answer = new int[10000];
        for(int i=0; i<n; i++){
            jan[i] = scanner.nextInt();
        }

        answer[0] = jan[0];
        answer[1] = jan[0] + jan[1];
        answer[2] = Integer.max(jan[0]+jan[1],Integer.max(jan[1]+jan[2],jan[0]+jan[2]));

        for(int i=3; i<n; i++){
            answer[i] = Integer.max(answer[i-1],Integer.max(jan[i] + answer[i-2], jan[i] + answer[i-3]+answer[i-1]));
        }
        System.out.println(answer[n-1]);
    }
}
