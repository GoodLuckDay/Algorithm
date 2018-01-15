#include <iostream>
#include <stdio.h>
#include <string>
#include <cstring>
using namespace std;

int N, root, P;
const int EMPTY = -1;
const int TREE_MAX_SIZE = 10000;
int child[TREE_MAX_SIZE][2];

void insert(int parent_idx, int child_idx){
  if(parent_idx == -1){
    root=child_idx;
  }
  else if(child[parent_idx][0] == EMPTY){
    child[parent_idx][0] = child_idx;
  }
  else if(child[parent_idx][1] == EMPTY){
    child[parent_idx][1] = child_idx;
  }
}

void pre_order(int cur){
  int left = child[cur][0];
  int right = child[cur][1];

  cout << cur << " ";
  if(left != EMPTY){
    pre_order(left);
  }
  if(right != EMPTY){
    pre_order(right);
  }
}

void in_order(int cur) {
    int left = child[cur][0];
    int right = child[cur][1];

    if (left != EMPTY) {
        pre_order(left);
    }
    cout << cur << ' ';
    if (right != EMPTY) {
        pre_order(right);
    }
}
void post_order(int cur) {
    int left = child[cur][0];
    int right = child[cur][1];

    if (left != EMPTY) {
        post_order(left);
    }
    if (right != EMPTY) {
        post_order(right);
    }
    cout << cur << ' ';
}

int main(int argc, char const *argv[]) {
  memset(child, -1, sizeof(child));
  cin >> N;
  for(int i=0; i<N; i++){
    cin >> P;
    if(P == -1){
      root = i;
    }
    else{
      insert(P,i);
    }
  }
  pre_order(root);
  puts("");
  in_order(root);
  puts("");
  post_order(root);
  puts("");
  return 0;
}
