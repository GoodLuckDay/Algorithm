package 단어공부;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        char[] array = inputStr.toLowerCase().toCharArray();
        int[] solve = new int[27];
        for(int i=0; i<array.length; i++){
            solve[array[i]-96]+=1;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        boolean multi = false;
        for(int i=0; i<solve.length; i++){
            if(max == solve[i]){
                multi = true;
            }
            else if(max < solve[i]){
                index = i;
                max = solve[i];
                multi = false;
            }
        }
        if(multi){
            System.out.println("?");
        }
        else{
            char temp = (char) (index + 64);
            System.out.println(temp);
        }
    }
}
