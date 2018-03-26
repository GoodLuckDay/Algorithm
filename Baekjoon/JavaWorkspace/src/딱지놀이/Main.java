package 딱지놀이;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputA;
        String[] inputB;
        int N;

        N = Integer.parseInt(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            int[] answer = new int[5];
            int index = 0;
            inputA = bufferedReader.readLine().split(" ");
            inputB = bufferedReader.readLine().split(" ");

            for(int j=1; j<inputA.length; j++){
                index = Integer.parseInt(inputA[j]);
                answer[index]++;
            }

            for(int j=1; j<inputB.length; j++){
                index = Integer.parseInt(inputB[j]);
                answer[index]--;
            }

            String result = "D";
            for(int j=4; j>0; j--){
                if (answer[j] != 0){
                    result = answer[j] > 0 ? "A" : "B";
                    break;
                }
            }
            System.out.println(result);
        }


    }
}
