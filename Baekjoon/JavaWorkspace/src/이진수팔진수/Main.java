package 이진수팔진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String binaryNumber = bufferedReader.readLine();
        StringBuilder result = new StringBuilder();
        int value = 0;
        for(int i=binaryNumber.length()-3; i>=0; i=i-3){
            value = 0;
            if(binaryNumber.charAt(i) == '1'){
                value += 4;
            }
            if(binaryNumber.charAt(i+1) == '1'){
                value += 2;
            }
            if(binaryNumber.charAt(i+2) == '1'){
                value += 1;
            }
            result.append(Integer.toOctalString(value));
        }
        int left = binaryNumber.length() % 3;
        if(left != 0){
            int level = 1;
            value = 0;
            for(int i=left-1; i>=0; i--){
                value += binaryNumber.charAt(i) == '1' ? level:0;
                level *= 2;
            }
            result.append(Integer.toOctalString(value));
        }
        System.out.println(result.reverse());
    }
}
