package 개미굴;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static TreeMap<String, TreeMap> treeMap = new TreeMap<>();
    public static void main(String[] args) {
        int N = scanner.nextInt();
        for(int i=0; i<N; i++){
            TreeMap temp = treeMap;
            int num = scanner.nextInt();
            for(int j=0; j<num; j++){
                String str = scanner.next();
                if(!temp.containsKey(str)){
                    temp.put(str, new TreeMap<>());
                }
                temp = (TreeMap) temp.get(str);
            }
        }
        recurPrint(treeMap, 0);
    }
    public static void recurPrint(TreeMap<String, TreeMap> tree, int depth){
        for (String key : tree.keySet()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);
            recurPrint(tree.get(key), depth+1);
        }
    }
}
