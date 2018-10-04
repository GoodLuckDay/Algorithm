#include <iostream>

using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int a, d, an, solve;
    cin >> a >> d >> an;

    solve = an - a;
    if(solve % d == 0){
        solve = solve / d;
        cout << solve + 1<< "\n";
    }
    else{
        cout << "X\n";
    }
}
