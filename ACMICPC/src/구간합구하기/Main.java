package 구간합구하기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        long[] array = new long[N];
        for(int i=0; i< N; i++){
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Segment segment = new Segment(array);
        for(int i=0; i<M+K; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            if(a == 1){
                segment.update(1,0,array.length-1,b-1,c-array[b-1]);
                array[b-1] = c;
            }
            else if(a == 2){
               stringBuilder.append(segment.sum(1,0,array.length-1,b-1,c-1)+"\n");
            }
        }
        System.out.print(stringBuilder);
    }
}
class Segment{
    long[] segmentTree;
    Segment(long[] array){
     this.segmentTree = new long[array.length*4];
     init(array,1,0,array.length-1);
    }

    public long init(long[] array, int node, int left, int right){
        if(left == right){
            return segmentTree[node] = array[left];
        }
        int mid = (left + right)/2;
        return segmentTree[node]= init(array,node*2,left,mid) + init(array,node*2+1,mid+1,right);
    }

    public long sum(int node, int left, int right, int start, int end){
        if(end < left || start > right){
            return 0;
        }
        if(start <= left && right <= end){
            return this.segmentTree[node];
        }
        int mid = (left + right)/2;
        return sum(node*2,left,mid,start,end) + sum(node*2+1,mid+1, right, start,end);
    }
    public void update(int node, int left, int right, int index, long diff){
        if(left > index || right <index){
            return ;
        }
        if(left <= index && index <= right) {
            segmentTree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(node * 2, left, mid, index, diff);
                update(node * 2 + 1, mid + 1, right, index, diff);
            }
        }
    }
}
