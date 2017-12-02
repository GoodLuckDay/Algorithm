#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    string a, b;
    cin >> a >> b;

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    int numA = atoi(a.c_str());
    int numB = atoi(b.c_str());
    if(numA > numB){
        cout << numA;
    }
    else{
        cout << numB;
    }
}
