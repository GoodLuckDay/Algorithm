#include <iostream>
#include <string>
using namespace std;

int main(int argc, char const *argv[]) {
  int N, ans = 0;
  cin >> N;

  while(N > 0){
      ans = ans << 1;
      ans += N%2;
      N = N >> 1;
  }

  cout << ans;
  return 0;
}
