#include <iostream>
using namespace std;

int main(){
    int map[101][101];
    long long int solve[101][101];
    int N;

    cin >> N;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            cin >> map[i][j];
            solve[i][j] = 0;
        }
    }

    solve[1][1] = 1;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            int step = map[i][j];
            if(step == 0) continue;
            if(i+step <= N){
                solve[i+step][j] += solve[i][j];
            }
            if(j+step <= N){
                solve[i][j+step] += solve[i][j];
            }
        }
    }

    cout << solve[N][N] << endl;

}
