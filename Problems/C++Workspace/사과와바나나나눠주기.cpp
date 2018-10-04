#include <iostream>

using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int apple, banana;

    cin >> apple >> banana;

    for(int i=1; i<=1000; i++){
        if(apple % i==0 && banana % i == 0){
            cout << i << " " << apple/i << " " << banana/i << " " << "\n";
        }
    }
}
