#include <iostream>
using namespace std;

pair<int, int> dp[41];
bool check[41];

pair<int, int> fibonacci(int n){
    if(n == 0){
        return dp[0];
    }
    else if(n == 1){
        return dp[1];
    }
    else{
        if(!check[n-1]){
            check[n-1] = true;
            dp[n-1] = fibonacci(n-1);
        }
        if(!check[n-2]){
            check[n-2] = true;
            dp[n-2] = fibonacci(n-2);
        }
        return make_pair(dp[n-1].first + dp[n-2].first, dp[n-1].second +  dp[n-2].second);
    }
}


int main(){
    ios::sync_with_stdio(false);


    int T, N;
    cin >> T;

    dp[0] = make_pair(1, 0);
    dp[1] = make_pair(0, 1);

    check[0] = true;
    check[1] = true;

    for(int i=0; i<T; i++){
        cin >> N;
        pair<int,int> result = fibonacci(N);

        cout << result.first << " " << result.second << "\n";
    }
}
