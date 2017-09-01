package 최솟값과최댓값;

import javafx.util.Pair;

import java.util.Scanner;

public class Main {
    static int[] array;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SegmentTree segmentTree;
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        array = new int[N];
        for(int i=0; i<N; i++){
            array[i] = scanner.nextInt();
        }
        segmentTree = new SegmentTree();
        for(int i=0; i<M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Pair<Integer, Integer> temp = segmentTree.find(1, 0, array.length - 1, a-1, b-1);
            System.out.println(temp.getKey() + " " + temp.getValue());
        }
    }
    static class SegmentTree{
        Pair<Integer,Integer>[] segment;
        public SegmentTree(){
            segment = new Pair[array.length*4];
            init(1,0,array.length-1);
        }
        public Pair<Integer,Integer> init(int node, int left, int right){
            if(left == right){
                return segment[node] = new Pair<>(array[left],array[left]);
            }
            int mid = left + (right - left)/2;
            Pair<Integer,Integer> leftPair = init(node*2, left, mid);
            Pair<Integer,Integer> rightPair = init(node*2+1,mid+1,right);
            Pair<Integer,Integer> temp;
            if(leftPair.getKey() < rightPair.getKey()){
                if(leftPair.getValue() < rightPair.getValue()){
                    temp = new Pair<>(leftPair.getKey(), rightPair.getValue());
                }
                else{
                    temp = new Pair<>(leftPair.getKey(), leftPair.getValue());
                }
            }
            else{
                if(leftPair.getValue() < rightPair.getValue()){
                    temp = new Pair<>(rightPair.getKey(), rightPair.getValue());
                }
                else{
                    temp = new Pair<>(rightPair.getKey(), leftPair.getValue());
                }
            }
            return segment[node] = temp;
        }
        public Pair<Integer,Integer> find(int node,int left, int right, int start, int end){
            if(start > right || end < left){
                return new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
            }
            else if(start <= left && right <= end){
                return segment[node];
            }
            int mid = left + (right-left)/2;
            Pair<Integer,Integer> leftPair = find(node*2, left, mid, start, end);
            Pair<Integer,Integer> rightPair = find(node*2+1,mid+1,right,start,end);
            Pair<Integer,Integer> temp;
            if(leftPair.getKey() < rightPair.getKey()){
                if(leftPair.getValue() < rightPair.getValue()){
                    temp = new Pair<>(leftPair.getKey(), rightPair.getValue());
                }
                else{
                    temp = new Pair<>(leftPair.getKey(), leftPair.getValue());
                }
            }
            else{
                if(leftPair.getValue() < rightPair.getValue()){
                    temp = new Pair<>(rightPair.getKey(), rightPair.getValue());
                }
                else{
                    temp = new Pair<>(rightPair.getKey(), leftPair.getValue());
                }
            }
            return temp;
        }
    }
}

