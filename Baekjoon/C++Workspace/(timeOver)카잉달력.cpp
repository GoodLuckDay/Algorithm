/*
시간 초과 때문에 틀린 코드
 */
#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    int T, M, N, x, y;

    cin >> T;

    for(int i=0; i<T; i++){
        cin >> M >> N >> x >> y;

        int counter = 1;
        int j=1, k=1;
        bool found = false;
        while((j != M || k != N) && !found){
            if(j == x && k == y){
                cout << counter << "\n";
                found = true;
                break;
            }
            j = j % M + 1;
            k = k % N + 1;
            counter++;
        }

        if(!found){
            cout << "-1" << "\n";
        }
    }
}
