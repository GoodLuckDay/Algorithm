package 가장큰증가하는수열;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] inputArray = new int[N];
        int[] answer = new int[N];
        for(int i=0; i< N; i++){
            inputArray[i] = scanner.nextInt();
            answer[i] = inputArray[i];
        }
        for(int i=0; i< inputArray.length-1; i++){
            for(int j=0 ; j < i; j++){
                if(inputArray[i] > inputArray[j]){
                    if(answer[i] < answer[j] + inputArray[i])
                        answer[i] = answer[j] + inputArray[i];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<answer.length; i++){
            if(max < answer[i]){
                max = answer[i];
            }
        }
        System.out.println(max);
    }
}
