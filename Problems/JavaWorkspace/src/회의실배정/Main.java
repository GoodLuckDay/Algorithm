package 회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
1931번 회의실 배
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>();
        StringTokenizer stringTokenizer;
        int N = Integer.parseInt(br.readLine());
        int meetings = 0;


        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            long startTime = Integer.parseInt(stringTokenizer.nextToken());
            long endTime = Integer.parseInt(stringTokenizer.nextToken());
            priorityQueue.add(new Meeting(startTime, endTime));
        }

        long currentTime = 0;

        while(!priorityQueue.isEmpty()){
            Meeting meeting = priorityQueue.poll();

            if(currentTime <= meeting.startTime){
                currentTime = meeting.endTime;
                meetings++;
            }

        }

        System.out.println(meetings);

    }


    static class Meeting implements Comparable {
        long startTime, endTime;

        Meeting(long startTime, long endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Object o) {
            int result = Long.compare(this.endTime, ((Meeting)o).endTime);
            if(result != 0){
                return result;
            }
            return Long.compare(this.startTime, ((Meeting)o).startTime);
        }
    }
}
