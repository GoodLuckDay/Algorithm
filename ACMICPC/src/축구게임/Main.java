package 축구게임;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 나중에 한번더 다시 보자
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int N = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<N; i++){
            arrayList.add(scanner.nextInt());
        }
        Collections.sort(arrayList);
        int sum = arrayList.get(0);
        boolean is_OK = true;
        for(int i=1; i<N && is_OK; i++){
            int temp_total = i * (i + 1) / 2;
            sum +=arrayList.get(i);
            if(sum < temp_total){
                is_OK = false;
            }
        }
        if(sum == N * (N-1)/2 && is_OK){
            System.out.println(1);
        }
        else{
            System.out.println(-1);
        }

    }


}
