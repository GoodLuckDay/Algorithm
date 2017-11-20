package 숫자카드2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer> hashMap = new HashMap();
        int N = scanner.nextInt();

        for(int i=0;i<N;i++){
            int input = scanner.nextInt();
            if(hashMap.containsKey(input)){
                int temp = hashMap.get(input);
                hashMap.replace(input,temp+1);
            }
            else{
                hashMap.put(input,1);
            }
        }
        int M = scanner.nextInt();
        for(int i=0; i<M; i++){
            int input = scanner.nextInt();
            Integer temp = hashMap.get(input);
            if(temp == null){
                System.out.print(0 +" ");
            }
            else{
                System.out.print(temp+" ");
            }
        }
        System.out.println();
    }
}