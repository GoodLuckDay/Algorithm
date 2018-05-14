#include <iostream>
#include <vector>
using namespace std;

class Country{
public:
    int countryNum;
    int gold;
    int silver;
    int curi;
    Country(int countryNum, int gold, int silver, int curi);
    bool equals(const Country& country);
};

Country::Country(int countryNum,int gold, int silver, int curi) {
    this->countryNum = countryNum;
    this->gold = gold;
    this->silver = silver;
    this->curi = curi;
}


int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int N, K, targetIndex;
    vector<Country> vector;
    cin >> N >> K;

    for(int i=0; i<N; i++) {
        int index, gold, silver, curi;
        cin >> index >> gold >> silver >> curi;
        if(index == K){
            targetIndex = i;
        }
        Country country = Country(i + 1, gold, silver, curi);
        vector.push_back(country);
    }

    Country target = vector[targetIndex];
    int count = 1;
    for(int i=0; i<N; i++){
        if(i == targetIndex)
            continue;
        if(vector[i].gold > target.gold){
            count++;
        }
        else if(vector[i].gold == target.gold){
            if(vector[i].silver > target.silver){
                count++;
            }
            else if(vector[i].silver == target.silver){
                if(vector[i].curi > target.curi){
                    count++;
                }
            }
        }
    }
    cout << count << "\n";
}
