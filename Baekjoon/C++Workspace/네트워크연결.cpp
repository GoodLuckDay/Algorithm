#include <iostream>

#define MAX 10000000000
using namespace std;

int main() {
    int N, M;
    int networks[1001][1001];
    bool visited[1001];
    int dist[1001];
    cin >> N >> M;

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            networks[i][j] = MAX;
        }
    }

    for (int i = 0; i < M; i++) {
        int src, dest, cost;
        cin >> src >> dest >> cost;
        networks[src][dest] = cost;
        networks[dest][src] = cost;
    }

    for (int i = 0; i < 1001; i++) {
        dist[i] = MAX;
    }
    dist[1] = 0;
    for (int i = 0; i < N; i++) {
        int ret = MAX;
        int retIndex = -1;
        for (int j = 1; j <= N; j++) {
            if (visited[j]) continue;
            if (ret > dist[j]) {
                ret = dist[j];
                retIndex = j;
            }
        }
        visited[retIndex] = true;
        for (int k = 1; k <= N; k++) {
            if (!visited[k] && networks[retIndex][k] != MAX) {
                if(dist[k] > networks[retIndex][k]){
                    dist[k] = networks[retIndex][k];
                }
            }
        }
    }
    long long int answer = 0;
    for(int i=1; i<=N; i++){
        answer += dist[i];
    }
    cout << answer << endl;


    return 0;
}
