#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int> > edge;
vector<bool> visited;
int N, M;
int u, v;

void bfs(int cur){
    queue<int> q;
    visited[cur] = true;
    q.push(cur);
    while(!q.empty()){
        int here = q.front();
        q.pop();
        cout << here << ' ';
        for(int i=0; i<edge[here].size(); i++){
            int there = edge[here][i];
            if(visited[there]) continue;
            visited[there] = true;
            q.push(there);
        }
    }
}

int main(int argc, char const *argv[]) {
    cin >> N >> M;
    edge.resize(N+1);
    visited.resize(N+1);

    for(int i=0; i<M; i++){
        cin >> u >> v;
        edge[u].push_back(v);
    }
    bfs(1);
    return 0;
}
