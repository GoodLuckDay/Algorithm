package 문자열폭발;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for(int i=0; i < chars1.length; i++){
            int startIndex=0;
            boolean found = false;
            stack.push(chars1[i]);
            if(chars2[0] == chars1[i]){
                startIndex = i;
                found = true;
            }
            else if(found){
                if(chars2[i-startIndex] != chars1[i]){
                    found = false;
                }
                else if(chars2[chars2.length-1] == chars1[i]){
                    for(int k=0; k < i-startIndex; i++){
                        stack.pop();
                    }
                }
            }
        }
        for(int i=0; i < stack.size(); i++){
            System.out.print(stack.pop());
        }
    }
}
