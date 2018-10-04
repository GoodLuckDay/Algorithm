#include <iostream>
#include <queue>
using namespace std;
int main(){
    queue<int> queue;
    int n, T;

    cin >> n >> T;

    for(int i=0; i<n; i++){
        int number = 0;
        cin >> number;
        queue.push(number);
    }

    int count = 0;
    int result = 0;
    while(!queue.empty()){
        if(result + queue.front() <= T){
            result += queue.front();
            queue.pop();
            count++;
        }
        else{
            break;
        }
    }
    cout << count << endl;
}
