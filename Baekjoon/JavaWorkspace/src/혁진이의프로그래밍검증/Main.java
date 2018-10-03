package 혁진이의프로그래밍검증;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static String[][] commands;
    private static int[][] visit;
    private static int memory;
    private static int R, C;
    private static String[] directions = {">", "^", "v", "<"};
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, -1, 1, 0};
    private static final int LIMIT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());
            memory = 0;
            commands = new String[R][C];
            visit = new int[R][C];

            for(int j=0; j<R; j++){
                commands[j] = br.readLine().split("");
            }

            System.out.printf("#%d %s\n",i+1, excuteCommand(0, 0, 0) ? "YES" : "NO");
        }

    }

    private static boolean excuteCommand(int y, int x, int direction) {
        if(y == -1){
            return excuteCommand(R-1, x, direction);
        }
        else if(y == R){
            return excuteCommand(0, x, direction);
        }

        if(x == -1){
            return excuteCommand(y, C-1, direction);
        }
        else if(x == C){
            return excuteCommand(y, 0, direction);
        }

        visit[y][x] += 1;

        if(visit[y][x] >= LIMIT){
            visit[y][x] -= 1;
            return false;
        }

        if(commands[y][x].equals("@")){
            return true;
        }
        else if(commands[y][x].equals(".")){
            return excuteCommand(y+dy[direction], x+dx[direction], direction);
        }
        else if(commands[y][x].equals("_")){
            direction = memory == 0 ? 0 : 3;
        }
        else if(commands[y][x].equals("|")){
            direction = memory == 0 ? 2 : 1;
        }
        else if(commands[y][x].equals("?")){
            for(int i=0; i<4; i++){
                if(excuteCommand(y+dy[i], x+dx[i], i)){
                    return true;
                }
            }
            return false;
        }
        else if(commands[y][x].equals("+")){
            memory = memory == 15 ? 0 : memory+1;
        }
        else if(commands[y][x].equals("-")){
            memory = memory == 0 ? 15 : memory-1;
        }
        else if(Character.isDigit(commands[y][x].charAt(0))){
            memory = Integer.parseInt(commands[y][x]);
        }

        for(int i=0; i<directions.length; i++){
            if(commands[y][x].equals(directions[i])){
                direction = i;
            }
        }
        return excuteCommand(y+dy[direction], x+dx[direction], direction);
    }
}
