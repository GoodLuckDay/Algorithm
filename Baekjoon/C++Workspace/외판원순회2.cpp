#include <iostream>
#include <vector>

#define MAX 10
#define MAXVALUE 100000001
using namespace std;
vector<int> path;
int map[MAX + 1][MAX + 1], N;

int solve(bool visited[], int sum) {
    if (path.size() == N) {
        if (map[path.back()][path[0]] == 0) {
            return MAXVALUE;
        } else {
            return sum + map[path.back()][path[0]];
        }
    }

    int ret = MAXVALUE;
    for (int i = 0; i < N; i++) {
        int here = path.back();
        if (!visited[i] && map[here][i] > 0) {
            visited[i] = true;
            path.push_back(i);
            ret = min(ret, solve(visited, sum + map[here][i]));
            path.pop_back();
            visited[i] = false;
        }
    }
    return ret;
}

int main() {
    ios::sync_with_stdio(false);
    cin >> N;
    bool visited[N];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
        }
    }
    int answer = MAXVALUE;
    for(int i=0; i<N; i++) {
        visited[i] = true;
        path.push_back(i);
        answer = min(answer, solve(visited, 0));
        path.pop_back();
        visited[i] = false;
    }
    if (answer == MAXVALUE) {
        cout << '0' << endl;
    } else {
        cout << answer << endl;
    }
}
