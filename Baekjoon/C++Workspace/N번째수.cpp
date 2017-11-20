#include <iostream>
#include <queue>
#include <functional>
using namespace std;

int main() {
  int N;
  priority_queue< int, vector<int>, greater<int> > pq;
  cin >> N;
  for(int i=0; i<N*N; i++){
    int val = 0;
    cin >> val;
    if(pq.size() == N && pq.top() < val){
      pq.pop();
      pq.push(val);
    }
    else if(pq.size() == N && pq.top() >= val){

    }
    else{
      pq.push(val);
    }
  }
  cout << pq.top();

  return 0;
}
