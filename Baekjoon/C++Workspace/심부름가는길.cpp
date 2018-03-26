#include <iostream>

using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int A, B, C, D;
    int result;
    cin >> A >> B >> C >> D;

    result = A+B+C+D;
    cout << result/60 << "\n" << result%60;

}
