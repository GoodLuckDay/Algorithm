#include <iostream>
#include <cmath>
#define MAX 10000

using namespace std;
bool isPrime[MAX+1];
int T, n;

void getPrimeNumber(){
    for(int i=2; i<=MAX; i++){
        isPrime[i] = true;
    }
    int sqrtn = sqrt(MAX);
    for(int i=2; i<=sqrtn; i++){
        if(!isPrime[i]) continue;
        for(int j=i*2; j<=MAX; j+=i){
            isPrime[j] = false;
        }
    }

}

int main(){
    cin >> T;
    getPrimeNumber();
    for(int i=0; i<T; i++){
        cin >> n;
        int mid = n / 2;
        int tempI=mid, tempJ=mid;
        while(true){
            for(int i=tempI; i>0; i-=1){
                if(!isPrime[i]) continue;
                tempI = i;
                break;
            }

            for(int j=tempJ; j<=n; j+=1){
                if(!isPrime[j]) continue;
                tempJ = j;
                break;
            }

            if(tempI + tempJ == n){
                break;
            }
            else if(tempI + tempJ < n){
                tempJ += 1;
            }
            else if(tempI + tempJ > n){
                tempI -= 1;
            }
        }
        cout << tempI << " " << tempJ << endl;
    }
}
