package 소풍;

import java.util.Scanner;

public class Main {
    static boolean[][] friends;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        for (int j = 0; j < C; j++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            friends = new boolean[n][n];
            check = new boolean[n];
            for (int i = 0; i < m; i++) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                friends[first][second] = true;
                friends[second][first] = true;
            }
            System.out.println(isFriends());
        }
    }

    public static int isFriends(){
        int found = -1;
        for(int i=0; i< check.length; i++){
            if(check[i] == false){
                found = i;
                break;
            }
        }
        if(found == -1){
            return 1;
        }
        int count = 0;
        for(int i=found+1; i< check.length; i++){
            if(friends[found][i] == true && check[i] == false){
                check[found] = true;
                check[i] = true;
                count += isFriends();
                check[i] = false;
                check[found] = false;
            }
        }
        return count;
    }
}
