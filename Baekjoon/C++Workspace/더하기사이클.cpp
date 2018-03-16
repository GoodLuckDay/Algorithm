#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);

    int N;
    int a, b, c=0;
    int count = 0;
    cin >> N;


    a = N / 10;
    b = N % 10;
    c = 10 * b + (a + b)%10;
    count++;

    while(N != c){
        a = c / 10;
        b = c % 10;
        c = 10 * b + (a + b)%10;
        count++;
    }

    cout << count << "\n";
}
