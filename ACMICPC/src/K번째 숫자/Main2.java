package K번쨰숫자;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;
        Segment segment;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] array = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        segment = new Segment(array);
        for (int i=0; i<m; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int index = Integer.parseInt(stringTokenizer.nextToken());
            ArrayList<Integer> temp = segment.find(1,0,array.length-1,start-1,end-1);
            stringBuilder.append(temp.get(index-1)+"\n");
        }
        System.out.print(stringBuilder);
    }
}

class Segment{
    ArrayList<Integer>[] segmentArray;
    public Segment(int[] array){
        this.segmentArray = new ArrayList[array.length*4];
        for(int i=0; i<this.segmentArray.length; i++){
            segmentArray[i] = new ArrayList<>();
        }
        init(array,1,0,array.length-1);
    }

    private ArrayList<Integer> init(int[] array, int node, int left, int right){
        if(left == right){
            segmentArray[node].add(array[left]);
            return segmentArray[node];
        }
        int mid = (left + right)/2;
        ArrayList<Integer> leftList = init(array,node*2,left,mid);
        ArrayList<Integer> rightList = init(array,node*2+1,mid+1,right);
        int leftSize = 0;
        int rightSize = 0;
        while(leftSize < leftList.size() && rightSize < rightList.size()){
            if(leftList.get(leftSize) < rightList.get(rightSize)){
                segmentArray[node].add(leftList.get(leftSize++));
            }
            else{
                segmentArray[node].add(rightList.get(rightSize++));
            }
        }
        while(leftSize < leftList.size())segmentArray[node].add(leftList.get(leftSize++));
        while(rightSize < rightList.size()) segmentArray[node].add(rightList.get(rightSize++));
        return segmentArray[node];
    }

    public ArrayList<Integer> find(int node, int left, int right, int start, int end){
        if(start > right || end <left){
            return new ArrayList<>();
        }
        if(start <=left && right <= end){
            return segmentArray[node];
        }
        int mid = (left + right) / 2;

        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(find(node*2,left,mid,start,end));
        temp.addAll(find(node*2+1,mid+1,right,start,end));
        return temp;
    }
}

