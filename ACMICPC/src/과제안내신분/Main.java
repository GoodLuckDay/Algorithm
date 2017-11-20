package 과제안내신분;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean[] studentList = new boolean[31];
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<28; i++){
            int checker = scanner.nextInt();
            studentList[checker] = true;
        }
        for(int i=1;i<studentList.length;i++){
            if(studentList[i] == false){
                System.out.println(i);
            }
        }
    }
}
