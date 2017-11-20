package 내일할거야;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        boolean[] answer = new boolean[1000000001];
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        for(int i=0;i<N;i++){
            int d = scanner.nextInt();
            int t = scanner.nextInt();
            while(d > 0 && t > 0){
                if(answer[t] == false){
                    answer[t] = true;
                    d--;
                }
                t--;
            }
        }
        boolean found = false;
        int i = 0;
        while (!found) {
            if (answer[i] == true) {
                found = true;
            }
            i++;
        }
        i--;
        System.out.println(--i);
    }
}
