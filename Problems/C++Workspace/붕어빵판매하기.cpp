#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    vector<int> item;
    vector<vector<int> > array;
    int N;

    cin >> N;
    item.assign(N, 0);
    array.assign(N+1, vector<int>(N+1, 0));

    for(int i=0; i<N; i++){
        cin >> item[i];
    }

    for(int i=1; i<=N; i++){
        array[0][i] = item[0] * i;
    }

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(j-i<=0){
                array[i][j] = array[i-1][j];
            }
            else{
                if(array[i][j-i-1]+item[i] > array[i-1][j]){
                    array[i][j] = array[i][j-i-1]+item[i];
                }
                else{
                    array[i][j] = array[i-1][j];
                }
            }
        }
    }

    cout << *max_element(array[N].begin(), array[N].end());

}
