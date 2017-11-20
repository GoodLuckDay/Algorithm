package 강의실배정;

import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static PriorityQueue<Subject> priorityQueue = new PriorityQueue<>();
    static int N;

    public static void main(String[] args) {
        N = scanner.nextInt();

        for(int i=0; i<N; i++){
            int Si = scanner.nextInt();
            int Ti = scanner.nextInt();
            priorityQueue.add(new Subject(Si,1));
            priorityQueue.add(new Subject(Ti, -1));
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        while(!priorityQueue.isEmpty()){
            sum += priorityQueue.poll().value;
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}

class Subject implements Comparable{
    int date;
    int value;

    public Subject(int date, int value){
        this.date = date;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Subject temp = (Subject)o;
        if(this.date < temp.date){
            return -1;
        }
        else if(this.date > temp.date){
            return 1;
        }
        else{
            if(this.value < temp.value){
                return -1;
            }
            else if(this.value > temp.value){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}
