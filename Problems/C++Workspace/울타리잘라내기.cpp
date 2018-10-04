/*
분할 정복을 이용한 울타리 문제 해결
맨 처음 모든 울타리 들을 확인을 하면서 완전 탐색으로 값을 구하지만 이 것은 시간이 너무 오래
소요가 된다.
불할 정복 사용시 빠른 시간에 문제 해결 가능
구간을 왼쪽가 오른쪽으로 나눈 후 최대 넒이를 구하고 중간에 걸쳐 있는 지점에서의
최대 넒이를 구한다.
 */
#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int bruteForce(const vector<int>& h) {
    int ret = 0;
    int N = h.size();

    for(int left=0; left<N; left++){
        int minHeight = h[left];
        for(int right=left; right<N; right++){
            minHeight = min(minHeight, h[right]);
            ret = max(ret, (right - left + 1) * minHeight);
        }
    }

    return ret;
}

int solve(const vector<int>& h, int left, int right){
    if(left == right){
        return h[left];
    }
    int mid = (left + right) / 2;
    int ans = max(solve(h, left, mid), solve(h, mid+1, right));

    int lo = mid;
    int hi = mid+1;

    int height = min(h[lo], h[hi]);
    ans = max(ans, height * 2);

    while(left < lo || hi < right ) {
        if(hi < right && (lo == left || h[lo-1] < h[hi+1])){
            hi++;
            height = min(height, h[hi]);
        }
        else{
            lo--;
            height = min(height, h[lo]);
        }
        ans = max(ans, height * (hi - lo + 1));
    }
    return ans;
}

int main(){
    vector<int> fence;
    int C, N, count;

    cin >> C;
    for(int i=0; i<C; i++){
        cin >> N;
        fence.assign(N, 0);
        for(int j=0; j<N; j++){
            cin >> fence[j];
        }
//        count = bruteForce(fence);
        count = solve(fence, 0, N-1);
        cout << count << "\n";
    }

}
