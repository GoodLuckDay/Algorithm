package 연속합;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i < N ; i++){
            int temp = scanner.nextInt();
            arrayList.add(temp);
            if(sum + temp > 0 ){
                sum += temp;
                arrayList.add(sum);
            }
            else{
                sum = temp;
                arrayList.add(sum);
                sum = 0;
            }
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.get(arrayList.size()-1));
    }
}
