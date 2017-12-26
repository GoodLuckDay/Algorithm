#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
  int num = 0;
  int index = 1;
  cin >> num;
  while(num != 1){
    if(num%2 == 0){
      num /= 2;
    }
    else if(num%2 == 1){
      num = 3 * num + 1;
    }
    index++;
  }

  cout << index << endl;
  return 0;
}
