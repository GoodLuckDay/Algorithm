package 수정렬하기;

import java.util.Scanner;

public class Main {
    static int[] numbers;
    static int[] helper;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        numbers = new int[N];
        helper = new int[N];
        for(int i=0; i< numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }
        mergeSort(0, numbers.length-1);

        for(int i=0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
    private static void mergeSort(int low, int high){
        if(low < high){
            int middle = low + (high-low) /2;
            mergeSort(low, middle);
            mergeSort(middle+1,high);
            merge(low,middle,high);
        }
    }

    private static void merge(int low, int middle, int high) {
        for(int i = low; i <= high; i++){
            helper[i] = numbers[i];
        }
        int i = low;
        int j = middle+1;
        int k = low;

        while( i <= middle && j <= high){
            if(helper[i] <= helper[j]){
                numbers[k] = helper[i];
                i++;
            }
            else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while(i <= middle){
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }
}
