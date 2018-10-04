#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    vector<vector<long> > answer(101, vector<long>(10, 0));
    int N;

    cin >> N;

    for(int i=1; i<10; i++){
        answer[1][i] = 1;
    }

    for(int i=1; i<N; i++){
        for(int j=0; j<10; j++){
            if(j == 0){
                answer[i+1][j+1] += answer[i][j] == 0 ? 0 : answer[i][j]%1000000000;
            }
            else if(j == 9){
                answer[i+1][j-1] += answer[i][j]%1000000000;
            }
            else{
                answer[i+1][j+1] += answer[i][j]%1000000000;
                answer[i+1][j-1] += answer[i][j]%1000000000;
            }
        }
    }

    long long result = 0;
    for(int i=0; i<10; i++){
        result += answer[N][i];
    }

    cout << result%1000000000;
}
