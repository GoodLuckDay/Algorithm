#include <iostream>
#include <cmath>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    float diagonal, widthPro, heightPro;

    cin >> diagonal >> heightPro >> widthPro;

    int diagonalPow = pow(diagonal, 2);

    float temp = (1.0 + (pow(widthPro, 2) / pow(heightPro, 2)));

    float height =  sqrt(diagonalPow / temp);
    float width = widthPro / heightPro * height;

    cout << (int)height << ' '<< (int)width;

}
