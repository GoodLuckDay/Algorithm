#include <iostream>
#include <map>
#include <unordered_set>
using namespace std;

int main(){
    map<int, int> map;
    int N, count = 0;
    cin >> N;

    for(int i=0; i<N; i++){
        int cowNum, pos;
        cin >> cowNum >> pos;
        if(map.find(cowNum) == map.end()){
            map.insert(pair<int, int> (cowNum, pos));
        }
        else if(map[cowNum] != pos){
            map.erase(cowNum);
            map.insert(pair<int, int>(cowNum, pos));
            count++;
        }
    }
    cout << count << endl;
}
