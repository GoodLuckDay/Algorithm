#include <iostream>

using std::cout;
using std::endl;
using std::cin;

int main(){
    int T;
    int a, b;
    long long amountOfData;
    long long result;

    cin >> T;
    for(int i=0; i<T; i++){
        cin >> a >> b;
        amountOfData = 1;
        for(int j=0; j<b; j++){
            amountOfData *= a;
            amountOfData %= 10;
        }

        cout << ((amountOfData % 10 == 0) ? 10 : amountOfData) << endl;
    }
}