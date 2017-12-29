#include <iostream>
using namespace std;

int main(){
    int S, T, D;
    int F;

    cin >> S >> T >> D;
    int temp = D / (2 * S);
    F = T * temp;
    cout << F << endl;
}
