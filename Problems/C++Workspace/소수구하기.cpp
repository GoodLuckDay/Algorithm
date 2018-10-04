/*
이 문제는 내가 문제를 내었지만 11번 틀려버린 그 문제
printf scanf보다 cin과 cout이 느리다
ios::sync_with_stdio()를 이용하여 cin 과 cout를 사용해서 속도를 높일수 있다고 한다.
또학 endl보다 "\n"을 사용하는것이 더 빠르다고 한다 이것 때문에 11번 시간 초과 나버렸다.
 */

#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);

    vector<bool> array;
    int M, N;

    cin >> M >> N;

    array.assign(N+1, true);

    array[1] = false;
    for (int i = 2; i <= N; i++) {
        if (array[i]) {
            for (int j = i+i; j <= N; j += i) {
                array[j] = false;
            }
        }
    }

    for (int i = M; i <= N; i++) {
        if (array[i]) {
            cout << i << "\n";
        }
    }
}
