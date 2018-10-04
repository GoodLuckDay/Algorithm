package 수정렬하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] array;
    static int[] helper;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int N = Integer.parseInt(bufferedReader.readLine());
        array = new int[N];
        helper = new int[N];
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        mergeSort(0, array.length-1);

        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void mergeSort(int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            sort(left,right,mid);
        }
    }
    public static void sort(int left, int right, int mid){
        for(int i=left; i<=right; i++){
            helper[i] = array[i];
        }
        int i=left;
        int j=mid+1;
        int k=left;
        while(i <= mid && j<=right){
            if(helper[i] >= helper[j]){
                array[k] = helper[i];
                i++;
            }
            else{
                array[k] = helper[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            array[k] = helper[i];
            i++;
            k++;
        }
    }
}
