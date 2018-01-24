#include <iostream>
#define MAX_SIZE 100000

using namespace std;

char decompressed[MAX_SIZE][MAX_SIZE];
void decompress(string::iterator& it, int y, int x, int size){
  char head = *(it++);

  if(head == 'b' || head == 'w'){
    for(int i=0; i<size; i++){
      for(int j=0; j<size; j++){
        decompressed[y+i][x+j] = head;
      }
    }
  }
  else{
    int half = size / 2;
    decompress(it, y, x, half);
    decompress(it, y, x+half, half);
    decompress(it, y+half, x, half);
    decompress(it, y+half, x+half, half);
  }
}
