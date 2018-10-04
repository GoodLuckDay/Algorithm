/*
동적 계획법을 이용한 이항 계수 계산
 */

#include <iostream>
#include <vector>

int bino(int r, int c);
using namespace std;

vector<vector<int> > array;

int main(){
  int n, r,result;
  cin >> n >> r;
  array.assign(n+1, vector<int>(r+1, 0));
  result = bino(n, r);
  cout << result;
}

int bino(int n, int r){
  if(r == 0 || n == r){
    return 1;
  }
  array[n-1][r-1] = array[n-1][r-1] == 0 ? bino(n-1, r-1) : array[n-1][r-1];
  array[n-1][r] = array[n-1][r] == 0 ? bino(n-1, r) : array[n-1][r];
  return bino(n-1, r-1) + bino(n-1, r);
}
