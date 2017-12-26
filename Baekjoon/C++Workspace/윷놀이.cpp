#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
  int game[4];
  int front, end;
  for(int i=0; i<3; i++){
      front = 0;
      end = 0;
      cin >> game[0] >> game[1] >> game[2] >> game[3];
      for(int j=0; j<4; j++){
        if(game[j] == 0){
          front += 1;
        }
        else if(game[j] == 1){
          end += 1;
        }
      }

      if(front == 1 && end == 3){
        cout << 'A' << endl;
      }
      else if(front == 2 && end == 2){
          cout << 'B' << endl;
      }
      else if(front == 3 && end == 1){
          cout << 'C' << endl;
      }
      else if(front == 4 && end == 0){
          cout << 'D' << endl;
      }
      else if(front == 0 && end == 4){
          cout << 'E' << endl;
      }
  }

  return 0;
}
