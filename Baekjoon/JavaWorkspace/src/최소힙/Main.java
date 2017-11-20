package 최소힙;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Heap heap = new Heap();
        int N = scanner.nextInt();

        for(int i=0; i<N; i++){
            long temp = scanner.nextInt();
            if(temp == 0 ){
                System.out.println(heap.remove());
            }
            else{
                heap.add(temp);
            }
        }

    }
    public static class Heap{
        long[] heap = new long[100003];
        int size = 0;
        public void add(long value){
            this.heap[++size] = value;
            int index = size;
            while(index > 1 && heap[index/2] < heap[index]){
                long temp = heap[index/2];
                heap[index/2] = heap[index];
                heap[index] = temp;
                index = index/2;
            }
        }
        public long remove(){
            if(this.size == 0){
                return 0;
            }
            long result = heap[1];
            heap[1] = heap[size];
            heap[size--] = 0;
            int root = 1;
            while(root *2 <= size){
                if(root * 2 + 1 <= size){
                    int bigger = heap[root*2] > heap[root*2+1] ? root*2 : root*2+1;
                    if(heap[root] < heap[bigger]) {
                        long temp = heap[root];
                        heap[root] = heap[bigger];
                        heap[bigger] = temp;
                    }
                    root = bigger;
                }
                else{
                    if(heap[root] < heap[root*2]) {
                        long temp = heap[root];
                        heap[root] = heap[root * 2];
                        heap[root * 2] = temp;
                    }
                    root = root * 2;
                }
            }
            return result;
        }
    }
}
