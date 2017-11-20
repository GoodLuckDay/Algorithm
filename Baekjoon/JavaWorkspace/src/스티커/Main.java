package 스티커;

import java.util.*;
public class Main {
    static int[][] board = new int[3][100003];
    static int[][] answer = new int[3][100003];
    static Scanner scanner = new Scanner(System.in);
    static int N;
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for(int k=0; k<T; k++) {
            fill_board();
            init_answer();
            solve();
        }

    }

    private static void solve() {
        for(int i=2; i<N; i++){
            answer[0][i] = Integer.max(answer[0][i-1], Integer.max(board[0][i] + answer[1][i-1],board[0][i] + answer[1][i-2]));
            answer[1][i] = Integer.max(answer[1][i-1], Integer.max(board[1][i] + answer[0][i-1],board[1][i] + answer[0][i-2]));
        }
        System.out.println(Integer.max(answer[0][N-1], answer[1][N-1]));
    }
    private static void init_answer() {
        answer[0][0] = board[0][0];
        answer[1][0] = board[1][0];
        answer[0][1] = Integer.max(answer[0][0],answer[1][0] + board[0][1]);
        answer[1][1] = Integer.max(answer[1][0],answer[0][0] + board[1][1]);
    }
    private static void fill_board() {
        N = scanner.nextInt();
        for(int i=0; i<2; i++){
            for(int j=0; j<N; j++){
                board[i][j] = scanner.nextInt();
            }
        }
    }
    /*
    private static void init_answer() { 이 방식은 최댓값을 찾는 것이 아니다. answer는 스티커를 선택하였을 때 점수가 최대가 되는 지점.
        answer[0][0] = board[0][0];
        answer[1][0] = board[1][0];
        answer[0][1] = answer[1][0] + board[0][1];
        answer[1][1] = answer[0][0] + board[1][1];
    }
    private static void solve() {
        for(int i=2; i<N; i++){
            answer[0][i] = board[0][i] + Integer.max(answer[0][i-2], Integer.max(answer[0][i-2],answer[1][i-1]));
            answer[1][i] = board[1][i] + Integer.max(answer[0][i-2], Integer.max(answer[1][i-2],answer[0][i-1]));
        }
        System.out.println(Integer.max(answer[0][N-1], answer[1][N-1]));
    }
    */
}
