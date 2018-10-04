#include <iostream>
#include <vector>
#include <stdlib.h>
#include <algorithm>
using namespace std;
#define HOBIT_COUNT 9
vector<int> answer;
int sum = 0;
void getRealHobits(int *hobits, int start){
  if(answer.size() > 7){
    return ;
  }
  else if(answer.size() == 7 && sum == 100){
    sort(answer.begin(), answer.end());
    for(vector<int>::iterator it = answer.begin(); it != answer.end(); it++){
      cout << *it << endl;
    }
    return ;
  }
  if(answer.size() < 7){
    for(int i=start; i<HOBIT_COUNT; i++){
      answer.push_back(hobits[i]);
      sum += hobits[i];
      getRealHobits(hobits, i+1);
      sum -= hobits[i];
      answer.pop_back();
    }
  }
  else{
    return ;
  }
}

int main(int argc, char const *argv[]) {
  int *hobits = (int *)malloc(HOBIT_COUNT * sizeof(int));
  for(int i=0;i<HOBIT_COUNT; i++){
    cin >> hobits[i];
  }

  getRealHobits(hobits, 0);

  return 0;
}
