#include <iostream>
#include <vector>

using namespace std;

vector<bool> roos;

void gameStart(){
    for(int i=2; i<=100; i++){
        for(int j=i; j<=100; j+=i){
            roos[j] = roos[j] ? false : true;
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int T, N;

    cin >> T;
    roos.assign(101, true);
    gameStart();
    for(int i=0; i<T; i++){
        int count = 0;

        cin >> N;

        for(int j=1; j<=N; j++){
            if(roos[j]){
                count++;
            }
        }
        cout << count << "\n";
    }
}

