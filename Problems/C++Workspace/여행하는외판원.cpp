#include <iostream>
#include <vector>
#define MAX 10
#define INF 99999
using namespace std;

/*
재귀를 이용을 하여 해결하는 외판원 문제
BFS와 비슷한 방식으로 해결이 가능하다.
 */

int n; //도시의 수
double dist[MAX][MAX];

//path 지금까지 만든 경로
//visited 각 도시의 방문 여부
//currentLength 지금까지 만든 경로의 길이

double shortestPath(vector<int>& path, vector<bool>& visited, double currentLength){
  if(path.size() == n){
    return currentLength + dist[path[0]][path.back()];
  }
  double ret = INF;
  for(int next = 0; next < n; next++){
    if(visited[next]) continue;
    int here = path.back();
    path.push_back(next);
    visited[next] = true;
    double cand = shortestPath(path, visited, currentLength + dist[here][next]);
    ret = min(ret, cand);
    visited[next] = false;
    path.pop_back();
  }
  return ret;
}
