package 소트인사이트;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int num = scanner.nextInt();

        while(num > 0){
            arrayList.add(num%10);
            num = num / 10;
        }

        Collections.sort(arrayList, Collections.reverseOrder());
        for(int i=0; i<arrayList.size(); i++){
            System.out.print(arrayList.get(i));
        }
        System.out.println();
    }
}
