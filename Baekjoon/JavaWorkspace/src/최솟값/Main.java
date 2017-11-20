package 최솟값;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] array = new int[N];
        for(int i=0; i< array.length; i++){
            array[i] = scanner.nextInt();
        }
        SegmentTree segmentTree = new SegmentTree(array);
        for(int i=0; i < M; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(segmentTree.findMin(1,0,array.length-1,a-1,b-1));
        }
    }
}

class SegmentTree{
    int[] tree;
    public SegmentTree(int[] array){
        tree = new int[array.length*4];
        init(array,1,0,array.length-1);
    }
    public int init(int[] array, int node, int left, int right){
        if(left  == right){
            return  this.tree[node] = array[left];
        }
        int mid = (left + right)/2;
        return tree[node] = Integer.min(init(array,2*node,left,mid),init(array,2*node+1,mid+1,right));
    }

    public int findMin(int node, int start, int end, int left, int right){
        if(left > end || start > right){
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end)/2;
        return Integer.min(findMin(node*2, start, mid,left,right), findMin(node*2+1,mid+1,end,left,right));
    }

}

