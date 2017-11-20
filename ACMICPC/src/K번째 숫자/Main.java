package K번쨰숫자;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int[][] array;
    static int[][] helper;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n][2];
        helper = new int[n][2];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<n; i++){
            array[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            array[i][1] = i;
        }
        mergeSort(0,array.length-1);

        for(int i=0; i<m; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int index = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(callQ(start-1,end-1,index)+"\n");
        }
        System.out.print(stringBuilder);
    }
    public static int callQ(int start,int end, int index){
        int indexCounter=0;
        for(int i=0; i<array.length; i++){
            if(array[i][1] >=start && array[i][1] <=end){
                indexCounter++;
                if(indexCounter == index){
                    return array[i][0];
                }
            }
        }
        return 0;
    }

    public static void mergeSort(int left, int right){
        if(left < right){
            int mid = left + (right-left)/2;
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            sorting(left,right,mid);
        }
    }
    private static void sorting(int left, int right , int middle){
       for(int i=left; i<=right; i++){
           helper[i][0] = array[i][0];
           helper[i][1] = array[i][1];
       }
        int i= left;
        int j = middle+1;
        int k = left;

        while(i <= middle && j <= right){
            if(helper[i][0] <= helper[j][0]){
                array[k][0] = helper[i][0];
                array[k][1] = helper[i][1];
                i++;
            }
            else{
                array[k][0] = helper[j][0];
                array[k][1] = helper[j][1];
                j++;
            }
            k++;
        }
        while (i <= middle){
            array[k][0] = helper[i][0];
            array[k][1] = helper[i][1];
            i++;
            k++;
        }
    }
}
