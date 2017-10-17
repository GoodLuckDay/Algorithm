package CountingInversions;

import java.util.*;
public class Main {
    static int[] array;
    static int[] heler;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        array = new int[N];
        heler = new int[N];

        for(int i=0; i<N; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println(sortAndCount(0, array.length-1));
    }

    private static long sortAndCount(int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right)/2;
        long rA = sortAndCount(left, mid);
        long rB = sortAndCount(mid+1, right);
        long r = mergeAndCount(left, mid, right);
        return rA + rB + r;
    }

    private static long mergeAndCount(int left, int mid, int right) {
        long inversion_count = 0;
        int indexA = left;
        int indexB = mid+1;
        int k = left;
        for(int i=left; i<=right; i++){
            heler[i] = array[i];
        }
        while(indexA <= mid && indexB <= right){
            if(heler[indexA] > heler[indexB]){
                inversion_count = inversion_count + (mid - indexA+1);
                array[k++] = heler[indexB++];
            }
            else{
                array[k++] = heler[indexA++];
            }
        }

        while(indexA <= mid ){
            array[k++] = heler[indexA++];
        }
        return inversion_count;
    }
}

