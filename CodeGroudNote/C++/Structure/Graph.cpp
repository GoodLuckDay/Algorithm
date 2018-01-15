#include <iostream>
#include <vector>
#include <list>
using namespace std;
#define MAX 35

int main(){
  int n;
  cin >> n;
  vector<list <int > > head(n+1);

  for(int i=1; i<=n; i++){
    for(int j=1; j<=n; j++){
      int val = 0;
      cin >> val;
        if(val){
          head[i].push_front(j);
        }
    }
  }

  for(int i=1; i<=n; i++){
    cout << i << ":";
    for(list<int>::iterator it = head[i].begin();it != head[i].end();it++){
        cout << *it << " ";
    }
    cout << endl;
  }
  return 0;
}
