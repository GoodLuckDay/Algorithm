package 트리순회_incomplete;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = null;
        int N = scanner.nextInt();
        for(int i=0; i<N; i++){
            String root = scanner.next();
            String leftNode = scanner.next();
            String rightNode = scanner.next();
            if(tree == null){
                tree = new Tree(root,leftNode,rightNode);
            }
            else{
                tree.addTree(root,leftNode,rightNode);
            }
        }
        System.out.println();
    }

    static class Tree{
        String data;
        Tree leftNode;
        Tree rightNode;

        Tree(String data, String left, String right){
            this.data = data;
            if(!left.equals(".")) {
                this.leftNode = new Tree(left, ".", ".");
            }
            if(!right.equals(".")){
                this.rightNode = new Tree(right,".",".");
            }
        }
        public void addTree(String data, String leftData, String rightData){
            if(this.data.equals(data)){
                leftNode = new Tree(leftData,".",".");
                rightNode = new Tree(rightData,".",".");
                return ;
            }
            if (leftNode != null){
                this.leftNode.addTree(data,leftData,rightData);
            }
            if (rightNode != null) {
                this.rightNode.addTree(data, leftData, rightData);
            }
        }

    }
}
