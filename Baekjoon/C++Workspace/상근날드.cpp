#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> hamberger;
    vector<int> beverage;

    for(int i=0; i<3; i++){
        int temp;
        cin >> temp;
        hamberger.push_back(temp);
    }

    for(int i=0; i<2; i++){
        int temp;
        cin >> temp;
        beverage.push_back(temp);
    }
    int minHamberger = *min_element(hamberger.begin(), hamberger.end());
    int minBeverage = *min_element(beverage.begin(), beverage.end());
    cout << minHamberger + minBeverage - 50 << "\n";
}
