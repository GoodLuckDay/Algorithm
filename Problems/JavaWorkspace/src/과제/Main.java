package 과제;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer>[] priorityQueues = new PriorityQueue[1001];
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<priorityQueues.length;i++){
            priorityQueues[i] = new PriorityQueue(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return (Integer)o2 - (Integer)o1;
                }
            });
        }
        int N = scanner.nextInt();
        int maxDay = -1;
        for(int i=0; i<N;i++){
            int day = scanner.nextInt();
            int score = scanner.nextInt();
            if(maxDay < day){
                maxDay = day;
            }
            priorityQueues[day].add(score);
        }
        int answer=0;
        int maxIndex;
        for(int i=maxDay; i>0; i--){
            boolean found = false;
            maxIndex = i;
            while(!found && (maxIndex <= maxDay)){
                if(priorityQueues[maxIndex].size() != 0){
                    found = true;
                }
                maxIndex++;
            }
            maxIndex--;
            found= false;
            int j = maxIndex+1;
            while(j <= maxDay){
                if(priorityQueues[j].size() == 0){
                    j++;
                }
                else{
                    if(priorityQueues[maxIndex].peek() < priorityQueues[j].peek()){
                        maxIndex = j;
                    }
                    j++;
                }
            }
            if(priorityQueues[maxIndex].size() != 0){
                answer += priorityQueues[maxIndex].poll();
            }
        }
        System.out.println(answer);
    }

}
