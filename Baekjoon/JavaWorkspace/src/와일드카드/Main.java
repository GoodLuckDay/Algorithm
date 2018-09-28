package 와일드카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static String wildCard;
    private static String fileName;
    private static int[][] cache;
    public static void main(String[] args) throws IOException {
        int N, T;
        ArrayList<String> arrayList;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<T; i++){
            arrayList = new ArrayList<>();
            wildCard = bufferedReader.readLine();
            N = Integer.parseInt(bufferedReader.readLine());

            for(int j=0; j<N; j++){
                cache = new int[101][101];
                fileName = bufferedReader.readLine();
                if(match(0, 0) == 1){
                    arrayList.add(fileName);
                }
            }

            Collections.sort(arrayList);
            for(String filename : arrayList){
                System.out.println(filename);
            }
        }
    }

    private static int match(int w, int s){

        if(cache[w][s] != 0){
            return cache[w][s];
        }

        if((w < wildCard.length() && s < fileName.length()) && ((wildCard.charAt(w) == fileName.charAt(s)) || (wildCard.charAt(w) == '?'))){
            return cache[w][s] = match(w+1, s+1);
        }

        if(w == wildCard.length()){
            return cache[w][s] = (s == fileName.length() ? 1 : -1);
        }

        if(wildCard.charAt(w) == '*'){
            if((match(w+1, s)==1) || (s < fileName.length() && (match(w, s+1) == 1))){
                return cache[w][s] = 1;
            }
        }
        return cache[w][s] = -1;
    }
}
