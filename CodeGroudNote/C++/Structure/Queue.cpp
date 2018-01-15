#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main(){
  int val, N;
  queue<int> q;
  string cmd;
  cin >> N;
  for(int i=0; i<N; i++){
    cin >> cmd;
    if(cmd[0] == 's'){
      cout << q.size() << endl;
    }
    else if(cmd[0] == 'e'){
      cin >> val;
      q.push(val);
    }
    else if(cmd[0] == 'd'){
      q.pop();
    }
    else if(cmd[0] == 'f'){
      cout << q.front() << endl;
    }
  }
  return 0;
}
