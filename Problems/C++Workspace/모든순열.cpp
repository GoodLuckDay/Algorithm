#include <iostream>
#include <vector>

using namespace std;
void BFS(int index);

vector<bool> array;
vector<int> route;
int N;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    array.assign(N, false);
    for(int i=1; i<=N; i++){
        array[i] = true;
        route.push_back(i);
        BFS(i);
        array[i] = false;
        route.pop_back();
    }

}

void BFS(int index){

    if(route.size() == N){
        for(vector<int>::iterator iter=route.begin(); iter != route.end(); iter++){
            cout << *iter << " ";
        }
        cout << "\n";
        return ;
    }

    for(int i=1; i<=N; i++){
        if(!array[i]){
            array[i] = true;
            route.push_back(i);
            BFS(i);
            array[i] = false;
            route.pop_back();
        }
    }
}
