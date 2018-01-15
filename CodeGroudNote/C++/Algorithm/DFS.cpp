#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > edge;
vector<bool> visited;
int N, M;
int u, v;

void dfs(int cur){
  visited[cur] = true;
  cout << cur << " ";
  for(int i=0; edge[cur].size(); i++){
    int there = edge[cur][i];
    if(!visited[there]) continue;
    dfs(there);
  }
}

int main(){
  cin >> N >> M;
  edge.resize(N+1);
  visited.resize(N+1);

  for(int i=0; i<M; i++){
    cin >> u >> v;
    edge[u].push_back(v);
  }

  dfs(1);
}
