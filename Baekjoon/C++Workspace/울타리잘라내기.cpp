#include <iostream>
#include <vector>

using namespace std;

vector<int> h;

int solve(int left, int right){
  //기저 사례 판자가 하나 밖에 없는 경우
  if(left == right) return h[left];
  int mid = (left + right) / 2;//2등분
  int ret = max(solve(left, mid), solve(mid+1, right));

  int lo = mid, hi = mid+1;
  int height = min(h[lo], h[hi]);

  //가운데 너비 2 부터 시작 해서 점차 너비를 증가를 시켜간다.
  ret = max(ret, height * 2);

  while(left < lo || hi < right){
    //hi쪽의 높이가 더 크다면 hi쪽으로 너비를 증가 시키고 그 전에 height와 새로운 height를 비교를 하서 값을 갱신
    if(hi < right && (lo == left || h[lo-1] < h[hi+1])){
      hi++;
      height = min(height, h[hi]);
    }
    else{
      lo--;
      height = min(height, h[lo]);
    }
    //갱신된 구간에서의 넒이와 이전 최적값을 비교를 하여 닶을 구한다.
    ret = max(ret, height * (hi - lo + 1));
  }

  return ret;
}
