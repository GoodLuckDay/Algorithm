#include <iostream>
using namespace std;
int main(){
    int a, b, c, count = 0;
    cin >> a >> b >> c;

    while(!(a == b-1 && b == c-1)){
        int tempA = a;
        int tempB = b;
        int tempC = c;

        if(tempB - tempA < tempC - tempB){
            a = tempB;
            b = tempC-1;
            c = tempC;
        }
        else{
            a = tempA;
            b = tempA+1;
            c = tempB;
        }
        count++;
    }
    cout << count << endl;
}
