package Q인덱스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int N;

        N = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        while(stringTokenizer.hasMoreTokens()){
            int value = Integer.parseInt(stringTokenizer.nextToken());
            arrayList.add(value);
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        for(int k=0; k<=N; k++){
            int count = 0;
            int i;
            for(i=0; i<arrayList.size(); i++){
                int value = arrayList.get(i);
                if(k < value){
                    count++;
                }
                else if(k == value && count < k){
                    count++;
                }
                else{
                    break;
                }
            }

            if(count == k ){
                System.out.println(k);
                break;
            }
            else if(k == N){
                System.out.println(0);
            }
        }
    }
}
