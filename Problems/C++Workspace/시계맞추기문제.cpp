/*
시계 맞추기 문제 알고리즘의 풀아 방법
완전 탐색 방법을 사용을 하여 문제를 해결을 한다.
 */
#include <iostream>
#include <vector>
const int INF = 9999, SWITCHS = 10, CLOCKS = 16;
const char linked[SWITCHS][CLOCKS] = {

};
using namespace std;

/*
모든 시계가 12시를 가리키는지 확인을 하는 함수
 */
bool areAligned(const vector<int>& clocks);

void push(vector<int>& clocks, int swtch){
  for(int clock=0; clock < CLOCKS; clock++){
      if(linked[swtch][clock] == 'x'){
        clocks[clock] += 3;
        if(clocks[clock] == 15) clocks[clock] = 3;
      }
  }
}


int solve(vector<int>& clocks, int swtch){
  if(swtch == SWITCHS) return areAligned(clocks) ? 0 : INF;
  int ret = INF;
  for(int cnt=0; cnt < 4; ++cnt){
    ret = min(ret, cnt + solve(clocks, swtch+1));
    push(clocks, swtch);
  }
  return ret;
}
