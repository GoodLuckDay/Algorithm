#include <iostream>
using namespace std;

int coin[100], d[10001];
int main(int argc, char const *argv[]) {
  int n, k;
  cin >> n >> k;

  for(int i=0; i<n; i++){
    cin >> coin[i];
  }

  for(int i=1; i<=k; i++){
    d[i] = -1;
    for(int j=0; j<n; j++){
        if(coin[j] <= i){
          if(d[i - coin[j]] < 0) continue;
          if(d[i] < 0) d[i] = d[i-coin[j]] + 1;
          else if(d[i-coin[j]]+1 < d[i]) d[i] = d[i-coin[j]] + 1;
        }
    }
  }
  cout << d[k] << endl;
  return 0;
}
