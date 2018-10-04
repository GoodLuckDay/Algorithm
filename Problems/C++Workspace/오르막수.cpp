#include <iostream>
#include <vector>
#include <numeric>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    vector<vector<int> > ans;
    int N;
    cin >> N;
    ans.assign(N+1, vector<int>(10, 0));
    ans[1].assign(10, 1);

    for(int i=2; i<N+1; i++){
        ans[i][0] = ans[i-1][0];
        for(int j=1; j<10; j++){
            ans[i][j] = (ans[i][j-1] + ans[i-1][j])%10007;
        }
    }
    cout << accumulate(ans[N].begin(), ans[N].end(), 0)%10007 << "\n";
}
