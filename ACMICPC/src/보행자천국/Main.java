package 보행자천국;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution(3,3,new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}));
        System.out.println(solution(3,6,new int[][]{{0,2,0,0,0,2}, {0,0,2,0,1,0}, {1,0,0,2,2,0}}));
    }

    public static int solution(int m, int n, int[][] cityMap) {
        int MOD = 20170805;
        int answer = 0;
        int[][] visit = new int[m][n];
        answer = BFS(m,n,0,0,false,visit,cityMap);
        return answer%MOD;
    }
    public static int BFS(int m, int n, int y, int x, boolean preLeft, int[][] visit, int[][] cityMap){
        if(y == m-1 && x == n-1){
            return 1;
        }
        else{
            int answer = 0;
            if(visit[y][x] != 0 && cityMap[y][x] != 2){
                return visit[y][x];
            }
            if(cityMap[y][x] == 0){
                if(y + 1 < m){
                    visit[y][x] += BFS(m,n,y+1,x,false,visit,cityMap);
                }
                if(x + 1 < n){
                    visit[y][x] += BFS(m,n,y,x+1,true,visit,cityMap);
                }
                answer = visit[y][x];
            }
            else if(cityMap[y][x] == 1){
                cityMap[y][x] = -1;
                return 0;
            }
            else if(cityMap[y][x] == 2){
                if(preLeft && x + 1 < n){
                    visit[y][x] += BFS(m,n,y,x+1,true,visit,cityMap);
                    answer = visit[y][x];
                }
                else if(!preLeft && y + 1 < m){
                    visit[y][x] += BFS(m,n,y+1,x,false,visit,cityMap);
                    answer = visit[y][x];
                }

            }
            return answer;
        }
    }

}
