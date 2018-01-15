#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
struct queue{
  int *data;
  int front,rear;
  int maxsize;
  int size;
  queue(int sz =16){
    maxsize = sz;
    front = 0;
    rear = 0;
    size = 0;
    data = (int *)malloc(maxsize*sizeof(int));
  }
};

int queue_size(queue& q){
  return  q.size;
}

bool queue_empty(queue& q){
  return queue_size(q) == 0;
}

bool queue_full(queue& q){
  return queue_size(q) == q.maxsize;
}

void queue_push(queue& q, int val){
    assert(!queue_full(q));
    q.data[q.rear] = val;
    q.rear = (q.rear+1)%q.maxsize;
    q.size++;
}

void queue_pop(queue& q){
  assert(!queue_empty(q));
  q.front = (q.front+1) % q.maxsize;
  q.size--;
}

int queue_front(queue& q){
  assert(!queue_empty(q));
  return q.data[q.front];
}

int main(){
  int val;
  queue q;

  for(int i=0; i<5; i++){
    queue_push(q, i);
  }
  printf("%d\n", q.data[0]);
  printf("output : ");
  while(!queue_empty(q)){
    printf("%d ", queue_front(q));
    queue_pop(q);
  }
  return 0;
}
