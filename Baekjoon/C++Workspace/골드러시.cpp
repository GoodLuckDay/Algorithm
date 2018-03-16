#include <iostream>
#include <cmath>

using namespace std;

int main(){
    ios::sync_with_stdio(false);

    int T, n;
    long long a, b, gold;
    int day = 0;
    cin >> T;

    for(int i=0; i<T; i++){
        cin >> n >> a >> b;
        gold = pow(2, n);
        day = 0;

        while(a != 0 && b != 0){
            gold = gold / 2;

            if(a >= gold){
                a -= gold;
            }

            if(b >= gold){
                b -= gold;
            }
            day++;
        }

        cout << day << "\n";
    }

}
