package 덱;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        int N = scanner.nextInt();
        for(int i=0; i<N; i++){
            String command = scanner.next();
            if(command.equals("push_back")){
                int value = scanner.nextInt();
                deck.push_back(value);
            }
            else if(command.equals("push_front")){
                int value = scanner.nextInt();
                deck.push_front(value);
            }
            else if(command.equals("pop_back")){
                System.out.println(deck.pop_back());
            }
            else if(command.equals("pop_front")){
                System.out.println(deck.pop_front());
            }
            else if(command.equals("size")){
                System.out.println(deck.size);
            }
            else if(command.equals("empty")){
                System.out.printf("%d\n",deck.isEmpty() ? 1 : 0);
            }
            else if(command.equals("front")){
                System.out.println(deck.front());
            }
            else if(command.equals("back")){
                System.out.println(deck.back());
            }
        }
    }

    public static class Deck{
        Node head;
        int size;
        public Deck(){
            this.head = null;
            size = 0;
        }
        public void push_back(int data){
            if(isEmpty()){
                this.head = new Node(data);
            }
            else{
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = new Node(data);
            }
            size++;
        }
        public int pop_back(){
            if(isEmpty()){
                return -1;
            }
            else{
                if(this.size == 1){
                    int result = this.head.data;
                    this.size--;
                    this.head = null;
                    return result;
                }
                Node temp = this.head;
                Node preTemp = null;
                while(temp.next != null){
                    preTemp = temp;
                    temp = temp.next;
                }
                int result = temp.data;
                preTemp.next = null;
                this.size--;
                return result;
            }
        }
        public void push_front(int data){
            if(isEmpty()){
                this.head = new Node(data);
            }
            else{
                Node newNode = new Node(data,this.head);
                this.head = newNode;
            }
            this.size++;
        }
        public int pop_front(){
            if(isEmpty()){
                return -1;
            }
            else{
                int result = this.head.data;
                this.size--;
                this.head = this.head.next;
                return result;
            }
        }
        public int front(){
            return isEmpty() ? -1 : this.head.data;
        }

        public int back(){
            if(isEmpty()){
                return -1;
            }
            Node temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            return temp.data;
        }

        public boolean isEmpty() {
            return size == 0 ? true : false;
        }

    }
    public static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
