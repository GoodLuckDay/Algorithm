package 수정렬하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] inputArray = new int[N];
        for(int i=0; i<N; i++){
            inputArray[i] = Integer.parseInt(bufferedReader.readLine());
        }
        QuickSort(inputArray, 0, inputArray.length-1);

        for(int i=0; i < inputArray.length; i++){
            stringBuilder.append(inputArray[i]+"\n");
        }
        System.out.print(stringBuilder);
    }

    private static void QuickSort(int[] inputArray, int left, int right) {
        if(left < right){
            int pivot = left + (right-left)/2;
            int low = left;
            int high = right;
            while(low <= high){
                while(inputArray[low] < inputArray[pivot]) {
                    low++;
                }
                while(inputArray[pivot] < inputArray[high]) {
                    high--;
                }
                if(low <= high ){
                 int temp = inputArray[low];
                 inputArray[low] = inputArray[high];
                 inputArray[high] = temp;
                 low++;
                 high--;
                }
            }
            if(left < high){
                QuickSort(inputArray,left,high);
            }
            if(right > low){
                QuickSort(inputArray,low,right);
            }
        }
    }
}
