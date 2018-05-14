#include <iostream>

using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int N;
    long long result=0;
    int* x;
    long long* calc;
    cin >> N;
    x = new int[N];
    calc = new long long[N];

    cin >> x[0];
    calc[0] = x[0];

    for(int i=1; i<N; i++){
        cin >> x[i];
        calc[i] = calc[i-1] + x[i];
    }

    for(int i=0;i<N-1; i++){
        calc[i] = calc[i] * x[i+1];
        result += calc[i];
    }

    cout << result;
}
