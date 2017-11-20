package 과제;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] destinations = new int[1001];
        int result=0;
        boolean found = false;
        for(int i=0;i<destinations.length;i++){
            destinations[i] = -1;
        }
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int destination, score;
            destination = scanner.nextInt();
            score = scanner.nextInt();
            int temp = 0;
            int j = destination;
            while(!found && j>0){
                if(destinations[j]==-1) {
                    found = true;
                    destinations[j] = score;
                }
                else if(destinations[j]<score){
                    temp = destinations[j];
                    destinations[j] = score;
                    score = temp;
                }
                j--;
            }
            found = false;
        }
        for(int i=0;i<destinations.length;i++){
            if(destinations[i] != -1){
                result+=destinations[i];
            }
        }
        System.out.println(result);
    }
}
