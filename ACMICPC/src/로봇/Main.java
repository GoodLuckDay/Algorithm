package 로봇;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int M, N;
    static int cy=0, cx=0;
    static int[] turnY = new int[]{0,1, 0,-1};
    static int[] turnX = new int[]{1,0,-1, 0};
    static int dir = 0;
    public static void main(String[] args) {
        M = scanner.nextInt();
        N = scanner.nextInt();
        scanner.nextLine();
        solve();
        if (cy < 0 || cx < 0){
            System.out.println(-1);
        }
        else {
            System.out.println(cx + " " + cy);
        }
    }

    private static void solve() {
        for(int i=0; i<N; i++){
            if((cy <= M && cx <= M) && (cy >=0 && cx >=0)) {
                String[] temp = scanner.nextLine().split(" ");
                String command = temp[0];
                int value = Integer.parseInt(temp[1]);
                if (command.equals("MOVE")) {
                    move(value);
                } else if (command.equals("TURN")) {
                    turn_Dir(value);
                }
            }
            else{
                cx = -1;
                cy = -1;
                return ;
            }
        }
    }

    private static void move(int value) {
        cy = cy + value * turnY[dir];
        cx = cx + value * turnX[dir];
    }
    private static void turn_Dir(int value) {
        if(value == 0){
            dir = dir == 3 ? 0 : ++dir;
        }
        else if(value == 1){
            dir = dir == 0 ? 3 : --dir;
        }
    }
}
