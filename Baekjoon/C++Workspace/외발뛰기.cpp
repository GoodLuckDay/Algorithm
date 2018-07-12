/*
동적 게획법을 이용하여 외발뛰기 문제 해결
처음에는 DFS를 이용하여 구현을 하려 하였다.
하지만 지금 글을 작성하다가 보니까 현재의 구현또한 BFS와 비슷하게 작동하는거 같다
 */

#include <iostream>

using namespace std;

int n, board[100][100];
int cache[100][100];

bool jump(int y, int x){
  if(y >= n || x >= n){
    return false;
  }

  if(y == n-1 && x == n-1){
    return true;
  }
  int jumpSize = board[y][x];
  return jump(y-jumpSize, x) || jump(y, x+jumpSize);

}

bool jump2(int y, int x){
  if(y >= n || x >= n){
    return false;
  }

  if(y == n-1 && x == n-1){
    return true;
  }

  int& ret = cache[y][x];
  if(ret != -1){
    return ret;
  }
  int jumpSize = board[y][x];
  return ret = jump2(y+jumpSize, x) || jump2(y, x+jumpSize);

}
